package cn.bravedawn.springhikaricp;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * @Author : fengx9
 * @Project : hikaricp-demo
 * @Date : Created in 2023-12-04 10:21
 */


@Configuration
public class DatasourceConfig {

    /**
     * 这里主要对 HikariCP MetricRegistry属性的配置做了说明和演示
     */


    private static final Logger log = LoggerFactory.getLogger(DatasourceConfig.class);


    @Bean
    public DataSource getDatasource() {
        String poolName = "spring-pool";
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:tcp://127.0.0.1/~/test");
        hikariConfig.setUsername("sa");
        hikariConfig.setPassword("");
        hikariConfig.setPoolName(poolName);
        hikariConfig.setMetricRegistry(initMetricRegistry(poolName));
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }


    /**
     * 配置指标监控
     * @param poolName 数据库连接池的名称
     * @return
     */
    public MetricRegistry initMetricRegistry(String poolName) {
        MetricRegistry metricRegistry = new MetricRegistry();
        Slf4jReporter reporter = Slf4jReporter.forRegistry(metricRegistry)
                .filter((name, metric) -> name.startsWith(poolName + ".pool"))
                .outputTo(log)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(30, TimeUnit.SECONDS);
        return metricRegistry;
    }
}
