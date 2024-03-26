package cn.bravedawn.nodes;

import cn.bravedawn.FluentClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @Author : fengx9
 * @Project : cuator-demo
 * @Date : Created in 2024-03-26 14:00
 */

@Slf4j
public class NodeOperator {

    private static final String PATH_FOREVER = "/forever";//保存所有数据持久的节点
    private CuratorFramework client;


    public void init() {
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
        client = FluentClient.createWithOptions("localhost:2181", retry, 6000, 6000);
        client.start();
    }

    /**
     * 检查节点是否存在
     */
    public void checkExists(String path) {
        try {

            // 检查节点是否存在
            Stat stat = client.checkExists().forPath("/" + path);
            if (stat == null) {
                log.info("/{} 节点不存在", path);
            } else {
                log.info("/{} 节点存在", path);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 创建持久顺序节点 ,并把节点数据放入 value hello0000000001
     *
     * @return
     * @throws Exception
     */
    public String createNode(String path, String dataStr) throws Exception {
        try {
            /**
             * 使用creatingParentContainersIfNeeded()之后Curator能够自动递归创建所有所需的父节点。
             */
            return client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath(path, dataStr.getBytes());
        } catch (Exception e) {
            log.error("create node error msg {} ", e.getMessage());
            throw e;
        }
    }


    /**
     * 更新一个节点的数据内容
     * @param path
     * @param data
     */
    private void updateData(String path, String data) {

        try {
            client.setData().forPath("/" + path, data.getBytes());
        } catch (Exception e) {
            log.error("update node data error msg {} ", e.getMessage());
        }
    }

    /**
     * 获取某个节点的所有子节点路径
     * @return
     */
    private List<String> getChild() throws Exception {
        try {
            List<String> list = client.getChildren().forPath("/path");
            return list;
        } catch (Exception e) {
            log.error("update node data error msg {} ", e.getMessage());
            throw e;
        }
    }


    /**
     * 获取节点数据
     * @param path 路径
     * @return
     * @throws Exception
     */
    public byte[] getNodeData(String path) throws Exception{
        try {
            byte[] bytes = client.getData().forPath(path);
            return bytes;
        } catch (Exception e) {
            log.error("get node data error {}", e.getMessage());
            throw e;
        }

    }

}
