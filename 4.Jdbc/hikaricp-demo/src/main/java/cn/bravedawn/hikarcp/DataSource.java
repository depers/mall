package cn.bravedawn.hikarcp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author : fengx9
 * @Project : hikaricp-demo
 * @Date : Created in 2023-11-24 15:28
 */
public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:h2:tcp://127.0.0.1/~/test");
        config.setUsername( "sa" );
        config.setPassword( "" );
        config.setAutoCommit(true);                             // 此属性控制从池返回的连接的默认自动提交行为。它是一个布尔值。默认值：true

        config.setConnectionTimeout(30000);                     // 此属性控制客户端（即您）等待池连接的最大毫秒数。如果超过此时间而连接不可用，则将引发 SQLException。可接受的最低连接超时为 250 毫秒。默认值：30000（30 秒）
        config.setIdleTimeout(600000);                          // 此属性控制连接在池中允许闲置的最大时间。此设置仅在minimumIdle被定义为小于maximumPoolSize时适用。一旦池达到minimumIdle连接数，空闲连接将不会被退役。连接是否处于空闲状态，最大变化为+30秒，平均变化为+15秒。在此超时之前，连接永远不会作为空闲状态退役。值为0表示永远不会从池中删除空闲连接。最小允许值为10000ms(10秒)。默认值:600000(10分钟)
        config.setKeepaliveTime(0);                             // 此属性控制 HikariCP 尝试保持连接活动的频率，以防止它被数据库或网络基础结构超时。此值必须小于该 maxLifetime 值。“keepalive”只会在空闲连接上发生。当针对给定连接的“keepalive”时间到来时，该连接将从池中删除，“ping”，然后返回到池中。“ping”是以下任一之一：调用 JDBC4 isValid() 方法，或执行 connectionTestQuery .通常，池外的持续时间应以个位数毫秒甚至亚毫秒为单位进行度量，因此对性能的影响应该很小或没有明显影响。允许的最小值为 30000 毫秒（30 秒），但最需要分钟范围内的值。默认值：0（禁用）
        config.setMaxLifetime(1800000);                         // 此属性控制池中连接的最长生存期。正在使用的连接永远不会停用，只有在关闭时才会将其删除。在逐个连接的基础上，应用轻微的负衰减以避免池中的质量消光。强烈建议设置此值，并且它应该比任何数据库或基础结构施加的连接时间限制短几秒钟。值为 0 表示没有最大生存期（无限生存期），当然取决于 idleTimeout 设置。允许的最小值为 30000 毫秒（30 秒）。默认值：1800000（30 分钟）

        config.setConnectionTestQuery("select 1 from dual");    // 如果您的驱动程序支持JDBC4，我们强烈建议不要设置此属性。这适用于不支持JDBC4 Connection.isValid() API的“遗留”驱动程序。这个查询将在从池中向您提供连接之前执行，以验证到数据库的连接是否仍然是活动的。再次，尝试在没有此属性的情况下运行池，如果您的驱动程序不符合JDBC4, HikariCP将记录一个错误，以便让您知道。默认值:无
        config.setMinimumIdle(10);                              // 此属性控制 HikariCP 尝试在池中维护的最小空闲连接数。如果空闲连接数低于此值，并且池中的总连接数小于 maximumPoolSize ，HikariCP 将尽最大努力快速有效地添加其他连接。但是，为了获得最佳性能和对峰值需求的响应能力，我们建议不要设置此值，而是允许 HikariCP 充当固定大小的连接池。默认值：与 maximumPoolSize 相同
        config.setMaximumPoolSize(10);                          // 此属性控制允许池达到的最大大小，包括空闲和正在使用的连接。基本上，此值将确定与数据库后端的最大实际连接数。此值的合理值最好由执行环境确定。当池达到此大小，并且没有空闲连接可用时，对 getConnection（） 的调用将阻塞长达 connectionTimeout 几毫秒，然后超时。请阅读有关泳池大小的信息。默认值：10
        config.setPoolName("pool");                             // 此属性表示连接池的用户定义名称，主要显示在日志记录和 JMX 管理控制台中，以标识池和池配置。默认值：自动生成

        ds = new HikariDataSource(config);
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
