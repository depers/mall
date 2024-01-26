package cn.bravedawn.demo3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author : depers
 * @program : rabbitmq-demo
 * @date : Created in 2024/1/26 16:52
 */
public class EmitLog {

    // 交换机的名称
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // 声明交换机的类型为：扇出
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            String message = argv.length < 1 ? "info: Hello World!" :
                    String.join(" ", argv);

            // 发送消息，值得注意的是第二个参数队列名称是空的
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

}
