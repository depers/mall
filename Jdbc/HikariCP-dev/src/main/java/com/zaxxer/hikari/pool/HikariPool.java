/*
 * Copyright (C) 2013,2014 Brett Wooldridge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zaxxer.hikari.pool;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariPoolMXBean;
import com.zaxxer.hikari.metrics.MetricsTrackerFactory;
import com.zaxxer.hikari.metrics.PoolStats;
import com.zaxxer.hikari.metrics.dropwizard.CodahaleHealthChecker;
import com.zaxxer.hikari.metrics.dropwizard.CodahaleMetricsTrackerFactory;
import com.zaxxer.hikari.metrics.micrometer.MicrometerMetricsTrackerFactory;
import com.zaxxer.hikari.util.ConcurrentBag;
import com.zaxxer.hikari.util.ConcurrentBag.IBagStateListener;
import com.zaxxer.hikari.util.SuspendResumeLock;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import static com.zaxxer.hikari.util.ClockSource.*;
import static com.zaxxer.hikari.util.ConcurrentBag.IConcurrentBagEntry.STATE_IN_USE;
import static com.zaxxer.hikari.util.ConcurrentBag.IConcurrentBagEntry.STATE_NOT_IN_USE;
import static com.zaxxer.hikari.util.UtilityElf.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * This is the primary connection pool class that provides the basic
 * pooling behavior for HikariCP.
 *
 * @author Brett Wooldridge
 */
public final class HikariPool extends PoolBase implements HikariPoolMXBean, IBagStateListener {
    private final Logger logger = LoggerFactory.getLogger(HikariPool.class);

    // 连接池的状态：正常、暂停、关闭
    public static final int POOL_NORMAL = 0;
    public static final int POOL_SUSPENDED = 1;
    public static final int POOL_SHUTDOWN = 2;

    public volatile int poolState;

    private final long aliveBypassWindowMs = Long.getLong("com.zaxxer.hikari.aliveBypassWindowMs", MILLISECONDS.toMillis(500));
    private final long housekeepingPeriodMs = Long.getLong("com.zaxxer.hikari.housekeeping.periodMs", SECONDS.toMillis(30));

    private static final String EVICTED_CONNECTION_MESSAGE = "(connection was evicted)";
    private static final String DEAD_CONNECTION_MESSAGE = "(connection is dead)";

    // 创建新连接的任务
    private final PoolEntryCreator poolEntryCreator = new PoolEntryCreator();
    // 填充新连接的任务
    private final PoolEntryCreator postFillPoolEntryCreator = new PoolEntryCreator("After adding ");

    // 新增连接执行器
    private final ThreadPoolExecutor addConnectionExecutor;

    // 关闭连接执行器
    private final ThreadPoolExecutor closeConnectionExecutor;

    // 连接池中的连接
    private final ConcurrentBag<PoolEntry> connectionBag;

    private final ProxyLeakTaskFactory leakTaskFactory;
    private final SuspendResumeLock suspendResumeLock;

    // 管家执行器，主要负责工作有：1.定时清理空闲连接和保持连接池中的最小连接数；2.连接最大有效时间的控制，避免连接集中到期失效，及时补充连接到连接池
    //                        3.定时根据
    private final ScheduledExecutorService houseKeepingExecutorService;
    private ScheduledFuture<?> houseKeeperTask;

    /**
     * Construct a HikariPool with the specified configuration.
     *
     * @param config a HikariConfig instance
     */
    public HikariPool(final HikariConfig config) {
        super(config);

        this.connectionBag = new ConcurrentBag<>(this);
        this.suspendResumeLock = config.isAllowPoolSuspension() ? new SuspendResumeLock() : SuspendResumeLock.FAUX_LOCK;

        this.houseKeepingExecutorService = initializeHouseKeepingExecutorService();

        checkFailFast();

        if (config.getMetricsTrackerFactory() != null) {
            setMetricsTrackerFactory(config.getMetricsTrackerFactory());
        } else {
            setMetricRegistry(config.getMetricRegistry());
        }

        setHealthCheckRegistry(config.getHealthCheckRegistry());

        handleMBeans(this, true);

        ThreadFactory threadFactory = config.getThreadFactory();

        final int maxPoolSize = config.getMaximumPoolSize();
        LinkedBlockingQueue<Runnable> addConnectionQueue = new LinkedBlockingQueue<>(maxPoolSize);
        this.addConnectionExecutor = createThreadPoolExecutor(addConnectionQueue, poolName + " connection adder", threadFactory, new CustomDiscardPolicy());
        this.closeConnectionExecutor = createThreadPoolExecutor(maxPoolSize, poolName + " connection closer", threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

        this.leakTaskFactory = new ProxyLeakTaskFactory(config.getLeakDetectionThreshold(), houseKeepingExecutorService);

        this.houseKeeperTask = houseKeepingExecutorService.scheduleWithFixedDelay(new HouseKeeper(), 100L, housekeepingPeriodMs, MILLISECONDS);

        if (Boolean.getBoolean("com.zaxxer.hikari.blockUntilFilled") && config.getInitializationFailTimeout() > 1) {
            addConnectionExecutor.setMaximumPoolSize(Math.min(16, Runtime.getRuntime().availableProcessors()));
            addConnectionExecutor.setCorePoolSize(Math.min(16, Runtime.getRuntime().availableProcessors()));

            final long startTime = currentTime();
            while (elapsedMillis(startTime) < config.getInitializationFailTimeout() && getTotalConnections() < config.getMinimumIdle()) {
                quietlySleep(MILLISECONDS.toMillis(100));
            }

            addConnectionExecutor.setCorePoolSize(1);
            addConnectionExecutor.setMaximumPoolSize(1);
        }
    }

    /**
     * Get a connection from the pool, or timeout after connectionTimeout milliseconds.
     *
     * @return a java.sql.Connection instance
     * @throws SQLException thrown if a timeout occurs trying to obtain a connection
     */
    public Connection getConnection() throws SQLException {
        return getConnection(connectionTimeout);
    }

    /**
     * Get a connection from the pool, or timeout after the specified number of milliseconds.
     *
     * @param hardTimeout the maximum time to wait for a connection from the pool
     * @return a java.sql.Connection instance
     * @throws SQLException thrown if a timeout occurs trying to obtain a connection
     */
    public Connection getConnection(final long hardTimeout) throws SQLException {
        suspendResumeLock.acquire();
        final var startTime = currentTime();

        try {
            var timeout = hardTimeout;
            do {
                var poolEntry = connectionBag.borrow(timeout, MILLISECONDS);
                if (poolEntry == null) {
                    break; // We timed out... break and throw exception
                }

                final var now = currentTime();
                if (poolEntry.isMarkedEvicted() || (elapsedMillis(poolEntry.lastAccessed, now) > aliveBypassWindowMs && isConnectionDead(poolEntry.connection))) {
                    closeConnection(poolEntry, poolEntry.isMarkedEvicted() ? EVICTED_CONNECTION_MESSAGE : DEAD_CONNECTION_MESSAGE);
                    timeout = hardTimeout - elapsedMillis(startTime);
                } else {
                    metricsTracker.recordBorrowStats(poolEntry, startTime);
                    return poolEntry.createProxyConnection(leakTaskFactory.schedule(poolEntry));
                }
            } while (timeout > 0L);

            metricsTracker.recordBorrowTimeoutStats(startTime);
            throw createTimeoutException(startTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new SQLException(poolName + " - Interrupted during connection acquisition", e);
        } finally {
            suspendResumeLock.release();
        }
    }

    /**
     * Shutdown the pool, closing all idle connections and aborting or closing
     * active connections.
     *
     * @throws InterruptedException thrown if the thread is interrupted during shutdown
     */
    public synchronized void shutdown() throws InterruptedException {
        try {
            poolState = POOL_SHUTDOWN;

            if (addConnectionExecutor == null) { // pool never started
                return;
            }

            logPoolState("Before shutdown ");

            if (houseKeeperTask != null) {
                houseKeeperTask.cancel(false);
                houseKeeperTask = null;
            }

            softEvictConnections();

            addConnectionExecutor.shutdown();
            if (!addConnectionExecutor.awaitTermination(getLoginTimeout(), SECONDS)) {
                logger.warn("Timed-out waiting for add connection executor to shutdown");
            }

            destroyHouseKeepingExecutorService();

            connectionBag.close();

            final var assassinExecutor = createThreadPoolExecutor(config.getMaximumPoolSize(), poolName + " connection assassinator",
                    config.getThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
            try {
                final var start = currentTime();
                do {
                    abortActiveConnections(assassinExecutor);
                    softEvictConnections();
                } while (getTotalConnections() > 0 && elapsedMillis(start) < SECONDS.toMillis(10));
            } finally {
                assassinExecutor.shutdown();
                if (!assassinExecutor.awaitTermination(10L, SECONDS)) {
                    logger.warn("Timed-out waiting for connection assassin to shutdown");
                }
            }

            shutdownNetworkTimeoutExecutor();
            closeConnectionExecutor.shutdown();
            if (!closeConnectionExecutor.awaitTermination(10L, SECONDS)) {
                logger.warn("Timed-out waiting for close connection executor to shutdown");
            }
        } finally {
            logPoolState("After shutdown ");
            handleMBeans(this, false);
            metricsTracker.close();
        }
    }

    /**
     * Evict a Connection from the pool.
     *
     * @param connection the Connection to evict (actually a {@link ProxyConnection})
     */
    public void evictConnection(Connection connection) {
        var proxyConnection = (ProxyConnection) connection;
        proxyConnection.cancelLeakTask();

        try {
            softEvictConnection(proxyConnection.getPoolEntry(), "(connection evicted by user)", !connection.isClosed() /* owner */);
        } catch (SQLException e) {
            // unreachable in HikariCP, but we're still forced to catch it
        }
    }

    /**
     * Set a metrics registry to be used when registering metrics collectors.  The HikariDataSource prevents this
     * method from being called more than once.
     *
     * @param metricRegistry the metrics registry instance to use
     */
    @SuppressWarnings("PackageAccessibility")
    public void setMetricRegistry(Object metricRegistry) {
        if (metricRegistry != null && safeIsAssignableFrom(metricRegistry, "com.codahale.metrics.MetricRegistry")) {
            setMetricsTrackerFactory(new CodahaleMetricsTrackerFactory((MetricRegistry) metricRegistry));
        } else if (metricRegistry != null && safeIsAssignableFrom(metricRegistry, "io.micrometer.core.instrument.MeterRegistry")) {
            setMetricsTrackerFactory(new MicrometerMetricsTrackerFactory((MeterRegistry) metricRegistry));
        } else {
            setMetricsTrackerFactory(null);
        }
    }

    /**
     * Set the MetricsTrackerFactory to be used to create the IMetricsTracker instance used by the pool.
     *
     * @param metricsTrackerFactory an instance of a class that subclasses MetricsTrackerFactory
     */
    public void setMetricsTrackerFactory(MetricsTrackerFactory metricsTrackerFactory) {
        if (metricsTrackerFactory != null) {
            this.metricsTracker = new MetricsTrackerDelegate(metricsTrackerFactory.create(config.getPoolName(), getPoolStats()));
        } else {
            this.metricsTracker = new NopMetricsTrackerDelegate();
        }
    }

    /**
     * Set the health check registry to be used when registering health checks.  Currently only Codahale health
     * checks are supported.
     *
     * @param healthCheckRegistry the health check registry instance to use
     */
    public void setHealthCheckRegistry(Object healthCheckRegistry) {
        if (healthCheckRegistry != null) {
            CodahaleHealthChecker.registerHealthChecks(this, config, (HealthCheckRegistry) healthCheckRegistry);
        }
    }

    // ***********************************************************************
    //                        IBagStateListener callback
    // ***********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public void addBagItem(final int waiting) {
        // 如果等待的线程大于 添加连接执行器的缓冲队列大小，执行添加一个新的连接
        if (waiting > addConnectionExecutor.getQueue().size())
            addConnectionExecutor.submit(poolEntryCreator);
    }

    // ***********************************************************************
    //                        HikariPoolMBean methods
    // ***********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public int getActiveConnections() {
        return connectionBag.getCount(STATE_IN_USE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIdleConnections() {
        return connectionBag.getCount(STATE_NOT_IN_USE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTotalConnections() {
        return connectionBag.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getThreadsAwaitingConnection() {
        return connectionBag.getWaitingThreadCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void softEvictConnections() {
        connectionBag.values().forEach(poolEntry -> softEvictConnection(poolEntry, "(connection evicted)", false /* not owner */));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void suspendPool() {
        if (suspendResumeLock == SuspendResumeLock.FAUX_LOCK) {
            throw new IllegalStateException(poolName + " - is not suspendable");
        } else if (poolState != POOL_SUSPENDED) {
            suspendResumeLock.suspend();
            poolState = POOL_SUSPENDED;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void resumePool() {
        if (poolState == POOL_SUSPENDED) {
            poolState = POOL_NORMAL;
            fillPool(false);
            suspendResumeLock.resume();
        }
    }

    // ***********************************************************************
    //                           Package methods
    // ***********************************************************************

    /**
     * Log the current pool state at debug level.
     *
     * @param prefix an optional prefix to prepend the log message
     */
    void logPoolState(String... prefix) {
        if (logger.isDebugEnabled()) {
            logger.debug("{} - {}stats (total={}, active={}, idle={}, waiting={})",
                    poolName, (prefix.length > 0 ? prefix[0] : ""),
                    getTotalConnections(), getActiveConnections(), getIdleConnections(), getThreadsAwaitingConnection());
        }
    }

    /**
     * Recycle PoolEntry (add back to the pool)
     *
     * @param poolEntry the PoolEntry to recycle
     */
    @Override
    void recycle(final PoolEntry poolEntry) {
        metricsTracker.recordConnectionUsage(poolEntry);

        connectionBag.requite(poolEntry);
    }

    /**
     * Permanently close the real (underlying) connection (eat any exception).
     * 永久关闭实际(底层)连接(排除任何异常)
     *
     * @param poolEntry     poolEntry having the connection to close
     * @param closureReason reason to close
     */
    void closeConnection(final PoolEntry poolEntry, final String closureReason) {
        // 从连接池中移除这个连接
        if (connectionBag.remove(poolEntry)) {
            final var connection = poolEntry.close();
            closeConnectionExecutor.execute(() -> {
                quietlyCloseConnection(connection, closureReason);
                // 如果线程池是正常的，填充空闲连接到线程池中
                if (poolState == POOL_NORMAL) {
                    fillPool(false);
                }
            });
        }
    }

    @SuppressWarnings("unused")
    int[] getPoolStateCounts() {
        return connectionBag.getStateCounts();
    }


    // ***********************************************************************
    //                           Private methods
    // ***********************************************************************

    /**
     * Creating new poolEntry.  If maxLifetime is configured, create a future End-of-life task with 2.5% variance from
     * the maxLifetime time to ensure there is no massive die-off of Connections in the pool.
     *
     * 创建新的池对象，如果配置了连接的最大有效时间，创建一个占有最大有效时间2.5%的未来的结束任务，来确保不要有大量的连接在最大有效时间到达时都关闭
     */
    private PoolEntry createPoolEntry() {
        try {
            final var poolEntry = newPoolEntry();

            final var maxLifetime = config.getMaxLifetime();
            if (maxLifetime > 0) {
                // variance up to 2.5% of the maxlifetime
                final var variance = maxLifetime > 10_000 ? ThreadLocalRandom.current().nextLong(maxLifetime / 40) : 0;
                final var lifetime = maxLifetime - variance;
                poolEntry.setFutureEol(houseKeepingExecutorService.schedule(new MaxLifetimeTask(poolEntry), lifetime, MILLISECONDS));
            }

            final long keepaliveTime = config.getKeepaliveTime();
            if (keepaliveTime > 0) {
                // variance up to 10% of the heartbeat time
                final var variance = ThreadLocalRandom.current().nextLong(keepaliveTime / 10);
                final var heartbeatTime = keepaliveTime - variance;
                poolEntry.setKeepalive(houseKeepingExecutorService.scheduleWithFixedDelay(new KeepaliveTask(poolEntry), heartbeatTime, heartbeatTime, MILLISECONDS));
            }

            return poolEntry;
        } catch (ConnectionSetupException e) {
            if (poolState == POOL_NORMAL) { // we check POOL_NORMAL to avoid a flood of messages if shutdown() is running concurrently
                logger.error("{} - Error thrown while acquiring connection from data source", poolName, e.getCause());
                lastConnectionFailure.set(e);
            }
        } catch (Exception e) {
            if (poolState == POOL_NORMAL) { // we check POOL_NORMAL to avoid a flood of messages if shutdown() is running concurrently
                logger.debug("{} - Cannot acquire connection from data source", poolName, e);
            }
        }

        return null;
    }

    /**
     * Fill pool up from current idle connections (as they are perceived at the point of execution) to minimumIdle connections.
     * 将当前空闲连接(在执行时感知到的)填充到最小空闲连接
     *
     * @param isAfterAdd 是否是因为处理空闲时间的批量触发的
     */
    private synchronized void fillPool(final boolean isAfterAdd) {
        final var idle = getIdleConnections();
        // 当总连接数（有效连接和空闲连接）小于最大连接数，且空闲连接数小于最小空闲连接数时，进行连接数的补充和添加
        final var shouldAdd = getTotalConnections() < config.getMaximumPoolSize() && idle < config.getMinimumIdle();

        if (shouldAdd) {
            // 需要添加的空闲连接数
            final var countToAdd = config.getMinimumIdle() - idle;
            for (int i = 0; i < countToAdd; i++)
                addConnectionExecutor.submit(isAfterAdd ? postFillPoolEntryCreator : poolEntryCreator);
        } else if (isAfterAdd) {
            logger.debug("{} - Fill pool skipped, pool has sufficient level or currently being filled.", poolName);
        }
    }

    /**
     * Attempt to abort or close active connections.
     *
     * @param assassinExecutor the ExecutorService to pass to Connection.abort()
     */
    private void abortActiveConnections(final ExecutorService assassinExecutor) {
        for (var poolEntry : connectionBag.values(STATE_IN_USE)) {
            Connection connection = poolEntry.close();
            try {
                connection.abort(assassinExecutor);
            } catch (Throwable e) {
                quietlyCloseConnection(connection, "(connection aborted during shutdown)");
            } finally {
                connectionBag.remove(poolEntry);
            }
        }
    }

    /**
     * If initializationFailFast is configured, check that we have DB connectivity.
     *
     * @throws PoolInitializationException if fails to create or validate connection
     * @see HikariConfig#setInitializationFailTimeout(long)
     */
    private void checkFailFast() {
        final var initializationTimeout = config.getInitializationFailTimeout();
        if (initializationTimeout < 0) {
            return;
        }

        final var startTime = currentTime();
        do {
            final var poolEntry = createPoolEntry();
            if (poolEntry != null) {
                if (config.getMinimumIdle() > 0) {
                    connectionBag.add(poolEntry);
                    logger.info("{} - Added connection {}", poolName, poolEntry.connection);
                } else {
                    quietlyCloseConnection(poolEntry.close(), "(initialization check complete and minimumIdle is zero)");
                }

                return;
            }

            if (getLastConnectionFailure() instanceof ConnectionSetupException) {
                throwPoolInitializationException(getLastConnectionFailure().getCause());
            }

            quietlySleep(SECONDS.toMillis(1));
        } while (elapsedMillis(startTime) < initializationTimeout);

        if (initializationTimeout > 0) {
            throwPoolInitializationException(getLastConnectionFailure());
        }
    }

    /**
     * Log the Throwable that caused pool initialization to fail, and then throw a PoolInitializationException with
     * that cause attached.
     *
     * @param t the Throwable that caused the pool to fail to initialize (possibly null)
     */
    private void throwPoolInitializationException(Throwable t) {
        destroyHouseKeepingExecutorService();
        throw new PoolInitializationException(t);
    }

    /**
     * "Soft" evict a Connection (/PoolEntry) from the pool.  If this method is being called by the user directly
     * through {@link com.zaxxer.hikari.HikariDataSource#evictConnection(Connection)} then {@code owner} is {@code true}.
     * <p>
     * If the caller is the owner, or if the Connection is idle (i.e. can be "reserved" in the {@link ConcurrentBag}),
     * then we can close the connection immediately.  Otherwise, we leave it "marked" for eviction so that it is evicted
     * the next time someone tries to acquire it from the pool.
     *
     * @param poolEntry the PoolEntry (/Connection) to "soft" evict from the pool
     * @param reason    the reason that the connection is being evicted
     * @param owner     true if the caller is the owner of the connection, false otherwise 如果调用者是连接的所有者，则为True，否则为false
     * @return true if the connection was evicted (closed), false if it was merely marked for eviction 如果连接被驱逐，则为True，如果仅标记为驱逐，则为false
     */
    private boolean softEvictConnection(final PoolEntry poolEntry, final String reason, final boolean owner) {
        // 池对象标识为驱逐状态
        poolEntry.markEvicted();

        // 是否连接自己调用 或是 将池对象置为不可借
        if (owner || connectionBag.reserve(poolEntry)) {
            // 关闭连接
            closeConnection(poolEntry, reason);
            return true;
        }

        return false;
    }

    /**
     * Create/initialize the Housekeeping service {@link ScheduledExecutorService}.  If the user specified an Executor
     * to be used in the {@link HikariConfig}, then we use that.  If no Executor was specified (typical), then create
     * an Executor and configure it.
     *
     * @return either the user specified {@link ScheduledExecutorService}, or the one we created
     */
    private ScheduledExecutorService initializeHouseKeepingExecutorService() {
        if (config.getScheduledExecutor() == null) {
            final var threadFactory = Optional.ofNullable(config.getThreadFactory()).orElseGet(() -> new DefaultThreadFactory(poolName + " housekeeper"));
            final var executor = new ScheduledThreadPoolExecutor(1, threadFactory, new ThreadPoolExecutor.DiscardPolicy());
            executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            executor.setRemoveOnCancelPolicy(true);
            return executor;
        } else {
            return config.getScheduledExecutor();
        }
    }

    /**
     * Destroy (/shutdown) the Housekeeping service Executor, if it was the one that we created.
     */
    private void destroyHouseKeepingExecutorService() {
        if (config.getScheduledExecutor() == null) {
            houseKeepingExecutorService.shutdownNow();
        }
    }

    /**
     * Create a PoolStats instance that will be used by metrics tracking, with a pollable resolution of 1 second.
     *
     * @return a PoolStats instance
     */
    private PoolStats getPoolStats() {
        return new PoolStats(SECONDS.toMillis(1)) {
            @Override
            protected void update() {
                this.pendingThreads = HikariPool.this.getThreadsAwaitingConnection();
                this.idleConnections = HikariPool.this.getIdleConnections();
                this.totalConnections = HikariPool.this.getTotalConnections();
                this.activeConnections = HikariPool.this.getActiveConnections();
                this.maxConnections = config.getMaximumPoolSize();
                this.minConnections = config.getMinimumIdle();
            }
        };
    }

    /**
     * Create a timeout exception (specifically, {@link SQLTransientConnectionException}) to be thrown, because a
     * timeout occurred when trying to acquire a Connection from the pool.  If there was an underlying cause for the
     * timeout, e.g. a SQLException thrown by the driver while trying to create a new Connection, then use the
     * SQL State from that exception as our own and additionally set that exception as the "next" SQLException inside
     * our exception.
     * <p>
     * As a side effect, log the timeout failure at DEBUG, and record the timeout failure in the metrics tracker.
     *
     * @param startTime the start time (timestamp) of the acquisition attempt
     * @return a SQLException to be thrown from {@link #getConnection()}
     */
    private SQLException createTimeoutException(long startTime) {
        logPoolState("Timeout failure ");
        metricsTracker.recordConnectionTimeout();

        String sqlState = null;
        final var originalException = getLastConnectionFailure();
        if (originalException instanceof SQLException) {
            sqlState = ((SQLException) originalException).getSQLState();
        }
        final var connectionException = new SQLTransientConnectionException(
                poolName + " - Connection is not available, request timed out after " + elapsedMillis(startTime) + "ms " +
                        "(total=" + getTotalConnections() + ", active=" + getActiveConnections() + ", idle=" + getIdleConnections() + ", waiting=" + getThreadsAwaitingConnection() + ")",
                sqlState, originalException);
        if (originalException instanceof SQLException) {
            connectionException.setNextException((SQLException) originalException);
        }

        return connectionException;
    }


    // ***********************************************************************
    //                      Non-anonymous Inner-classes
    // ***********************************************************************

    /**
     * Creating and adding poolEntries (connections) to the pool.
     * 创建和添加连接到连接池中
     */
    private final class PoolEntryCreator implements Callable<Boolean> {
        // 日志前缀
        private final String loggingPrefix;

        PoolEntryCreator() {
            this(null);
        }

        PoolEntryCreator(String loggingPrefix) {
            this.loggingPrefix = loggingPrefix;
        }

        @Override
        public Boolean call() {
            var backoffMs = 10L;
            var added = false;
            try {
                while (shouldContinueCreating()) {
                    final var poolEntry = createPoolEntry();
                    if (poolEntry != null) {
                        added = true;
                        connectionBag.add(poolEntry);
                        logger.debug("{} - Added connection {}", poolName, poolEntry.connection);
                        quietlySleep(30L);
                        break;
                    } else {  // failed to get connection from db, sleep and retry
                        if (loggingPrefix != null && backoffMs % 50 == 0)
                            logger.debug("{} - Connection add failed, sleeping with backoff: {}ms", poolName, backoffMs);
                        quietlySleep(backoffMs);
                        backoffMs = Math.min(SECONDS.toMillis(5), backoffMs * 2);
                    }
                }
            } finally {
                if (added && loggingPrefix != null)
                    logPoolState(loggingPrefix);
                else
                    logPoolState("Connection not added, ");
            }

            // Pool is suspended, shutdown, or at max size
            return Boolean.FALSE;
        }

        /**
         * We only create connections if we need another idle connection or have threads still waiting
         * for a new connection.  Otherwise we bail out of the request to create.
         * 如果要添加空闲连接或是有等待新连接的线程，我们才创建连接；否则退出创建请求
         *
         * @return true if we should create a connection, false if the need has disappeared
         */
        private synchronized boolean shouldContinueCreating() {
            // 同时满足三个要求：1.连接池的状态是正常的；2.总连接数小于最大连接数；3.空闲连接数小于最先空闲连接数 或是 等待连接的线程数大于空闲连接数
            return poolState == POOL_NORMAL && getTotalConnections() < config.getMaximumPoolSize() &&
                    (getIdleConnections() < config.getMinimumIdle() || connectionBag.getWaitingThreadCount() > getIdleConnections());
        }
    }

    /**
     * housekeeping task是为了清理空闲连接和保持空闲连接的最小连接数，主要是通过连接的空闲时间、最小空闲连接数、最大空闲连接数
     * The housekeeping task to retire and maintain minimum idle connections.
     */
    private final class HouseKeeper implements Runnable {
        // housekeepingPeriodMs为30秒，用当前时间减去30秒为之前的时间
        private volatile long previous = plusMillis(currentTime(), -housekeepingPeriodMs);
        @SuppressWarnings("AtomicFieldUpdaterNotStaticFinal")
        private final AtomicReferenceFieldUpdater<PoolBase, String> catalogUpdater = AtomicReferenceFieldUpdater.newUpdater(PoolBase.class, String.class, "catalog");

        @Override
        public void run() {
            try {
                // refresh values in case they changed via MBean
                connectionTimeout = config.getConnectionTimeout();
                validationTimeout = config.getValidationTimeout();
                leakTaskFactory.updateLeakDetectionThreshold(config.getLeakDetectionThreshold());

                if (config.getCatalog() != null && !config.getCatalog().equals(catalog)) {
                    catalogUpdater.set(HikariPool.this, config.getCatalog());
                }

                final var idleTimeout = config.getIdleTimeout();
                final var now = currentTime();

                // Detect retrograde time, allowing +128ms as per NTP spec.
                // 检测逆行时间，允许按NTP规范加128ms
                // 用之前的时间加30s，比当前的时间还大128ms，说明时钟回退了
                if (plusMillis(now, 128) < plusMillis(previous, housekeepingPeriodMs)) {
                    // 如果最新的时间+128毫秒，比前面时间还要小，说明时钟超前了，服务器时钟中途被修改了
                    // 如果逆行时间大于128毫秒，则标识该连接为软驱逐
                    logger.warn("{} - Retrograde clock change detected (housekeeper delta={}), soft-evicting connections from pool.",
                            poolName, elapsedDisplayString(previous, now));
                    previous = now;
                    softEvictConnections();
                    return;
                    // 如果当前时间大于之前的时间加45ms，之前的时间其实就已经减过30ms了，也就是说现在的时间比之前获取的时间还要大15ms，也是时钟不对
                } else if (now > plusMillis(previous, (3 * housekeepingPeriodMs) / 2)) {
                    // No point evicting for forward clock motion, this merely accelerates connection retirement anyway
                    // 没有必要为前进时钟运动驱逐，这只会加速连接退役
                    logger.warn("{} - Thread starvation or clock leap detected (housekeeper delta={}).", poolName, elapsedDisplayString(previous, now));
                }

                previous = now;

                // 如果空闲连接的超时时间大于0，且最小空闲连接数小于最大连接数
                if (idleTimeout > 0L && config.getMinimumIdle() < config.getMaximumPoolSize()) {
                    logPoolState("Before cleanup ");
                    // 获取线程池中空闲连接数组
                    final var notInUse = connectionBag.values(STATE_NOT_IN_USE);
                    // 需要移除的空闲连接数
                    var maxToRemove = notInUse.size() - config.getMinimumIdle();
                    for (PoolEntry entry : notInUse) {
                        // 若需要移除的连接数大于0，且上次访问连接的时大于空闲超时时间，且已经标记了该连接为 保留 状态
                        if (maxToRemove > 0 && elapsedMillis(entry.lastAccessed, now) > idleTimeout && connectionBag.reserve(entry)) {
                            closeConnection(entry, "(connection has passed idleTimeout)");
                            maxToRemove--;
                        }
                    }
                    logPoolState("After cleanup  ");
                } else
                    logPoolState("Pool ");

                // 填充空闲连接数量到配置的最小连接数
                fillPool(true); // Try to maintain minimum connections
            } catch (Exception e) {
                logger.error("Unexpected exception in housekeeping task", e);
            }
        }
    }

    private final class MaxLifetimeTask implements Runnable {
        private final PoolEntry poolEntry;

        MaxLifetimeTask(final PoolEntry poolEntry) {
            this.poolEntry = poolEntry;
        }

        public void run() {
            // 驱逐连接
            if (softEvictConnection(poolEntry, "(connection has passed maxLifetime)", false /* not owner */)) {
                // 添加新的连接
                addBagItem(connectionBag.getWaitingThreadCount());
            }
        }
    }

    private final class KeepaliveTask implements Runnable {
        private final PoolEntry poolEntry;

        KeepaliveTask(final PoolEntry poolEntry) {
            this.poolEntry = poolEntry;
        }

        public void run() {
            // 设置池对象的状态为“不可借”
            if (connectionBag.reserve(poolEntry)) {
                // 判断连接是否已经无效，这里面分别使用了JDBC4的isValid()方法或者通过执行connectionTestQuery属性sql判断连接是否已经关闭
                if (isConnectionDead(poolEntry.connection)) {
                    // 如果检测连接已经无效，则关闭连接
                    // 值得注意的是在这里关闭连接之后，其实已经将连接池中的连接补充到最小空闲连接数的水平了
                    softEvictConnection(poolEntry, DEAD_CONNECTION_MESSAGE, true);
                    // 新增一个连接到连接池中
                    addBagItem(connectionBag.getWaitingThreadCount());
                } else {
                    // 设置连接可以被再次借用
                    connectionBag.unreserve(poolEntry);
                    logger.debug("{} - keepalive: connection {} is alive", poolName, poolEntry.connection);
                }
            }
        }
    }

    public static class PoolInitializationException extends RuntimeException {
        private static final long serialVersionUID = 929872118275916520L;

        /**
         * Construct an exception, possibly wrapping the provided Throwable as the cause.
         *
         * @param t the Throwable to wrap
         */
        public PoolInitializationException(Throwable t) {
            super("Failed to initialize pool: " + t.getMessage(), t);
        }
    }
}
