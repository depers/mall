package cn.bravedawn.resource;

import org.springframework.core.io.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author : depers
 * @program : 1.spring4.x
 * @description:
 * @date : Created in 2023/9/7 21:34
 */
public class ResourceExample {


    public static void main(String[] args) throws IOException {
        String filePath = "/Users/depers/Desktop/code/mall/7.Spring/1.spring4.x/chapter4/src/main/resources/file.txt";

        // 使用系统文件路径的方式加载文件
        WritableResource resource1 = new PathResource(filePath);

        // 使用类路径方式加载文件
        Resource resource2 = new ClassPathResource("file.txt");

        // 使用WritableResource接口写资源文件
        OutputStream stream1 = resource1.getOutputStream();
        stream1.write("中国欢迎你\n欢迎光临".getBytes(StandardCharsets.UTF_8));
        stream1.close();

        // 使用Resource读取资源文件
        InputStream ins1 = resource1.getInputStream();
        InputStream ins2 = resource2.getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = ins1.read()) != -1) {
            baos.write(i);
        }
        System.out.println(baos.toString());


        System.out.println("resource1:" + resource1.getFilename());
        System.out.println("resource2:" + resource2.getFilename());

    }
}
