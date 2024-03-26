package cn.bravedawn;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;

/**
 * @Author : fengx9
 * @Project : cuator-demo
 * @Date : Created in 2024-03-26 13:52
 */
public class FluentClient {


    /**
     * 使用Fluent API创建客户端
     * @param connectionString 服务器列表，格式host1:port1,host2:port2,...
     * @param retryPolicy 重试策略,内建有四种重试策略,也可以自行实现RetryPolicy接口
     * @param connectionTimeoutMs 连接创建超时时间，单位毫秒，默认60000ms
     * @param sessionTimeoutMs 会话超时时间，单位毫秒，默认60000ms
     * @return
     */
    public static CuratorFramework createWithOptions(String connectionString, RetryPolicy retryPolicy, int connectionTimeoutMs, int sessionTimeoutMs) {
        return CuratorFrameworkFactory.builder().connectString(connectionString)
                .retryPolicy(retryPolicy)
                .connectionTimeoutMs(connectionTimeoutMs)
                .sessionTimeoutMs(sessionTimeoutMs)
                .build();
    }
}
