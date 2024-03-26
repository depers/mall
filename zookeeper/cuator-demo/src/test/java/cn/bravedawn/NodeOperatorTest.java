package cn.bravedawn;

import cn.bravedawn.nodes.NodeOperator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @Author : fengx9
 * @Project : cuator-demo
 * @Date : Created in 2024-03-26 15:12
 */


@Slf4j
public class NodeOperatorTest {


    private static NodeOperator nodeOperator;

    @BeforeAll
    public static void beforeAll() {
        nodeOperator = new NodeOperator();
        nodeOperator.init();
    }

    @Test
    public void checkExists() {
        nodeOperator.checkExists("order");
    }

    @Test
    public void createNode() throws Exception {
        log.info("创建节点：{}", nodeOperator.createNode("/hello", "hello world"));
    }

    @Test
    public void getNodeData() throws Exception {
        byte[] data = nodeOperator.getNodeData("/hello0000000001");
        log.info("获取节点的数据: {}", new String(data));
    }

}
