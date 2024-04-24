package cn.bravedawn.io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-25 16:33
 */
public class Client {


    /**
     * 客户端
     */

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new MultiClient());
        }
        executorService.shutdown();
    }


    static class MultiClient implements Runnable {

        @Override
        public void run() {
            try {
                InetSocketAddress hA = new InetSocketAddress("localhost", 8080);
                SocketChannel client = SocketChannel.open(hA);
                System.out.println("The Client is sending messages to server...");
                // Sending messages to the server
                String[] msg = new String[]{"Time goes fast.", "What next?", "Bye Bye"};
                for (int j = 0; j < msg.length; j++) {
                    byte[] message = new String(msg[j]).getBytes();
                    ByteBuffer buffer = ByteBuffer.wrap(message);
                    client.write(buffer);
                    System.out.println(msg[j]);
                    buffer.clear();
                    Thread.sleep(3000);
                }
                client.close();
            } catch (Throwable e) {
                e.printStackTrace();
            }

        }
    }

}
