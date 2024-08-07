package cn.bravedawn.network.socket.bio.v1;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Description : 服务端处理类
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-08 11:14
 */
public class Handler extends Thread{


    private Socket socket;


    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream()) {
            try (OutputStream output = socket.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                socket.close();
            } catch (IOException ex) {
            }
            System.out.println("client disconnected");
        }
    }


    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        writer.write("hello");
        writer.newLine(); // 调用此方法来终止输出行
        writer.flush();

        while (true) {
            String s = reader.readLine();
            if (s.equals("bye")) {
                writer.write("byte");
                writer.newLine();
                writer.flush();
                break;
            }
            writer.write("ok: " + s);
            writer.newLine();
            writer.flush();
        }

    }
}
