package cn.bravedawn.io.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description : 在IDEA和Jar两个环境下运行能可以顺利的读取resources目录下的文件内容
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-19 17:30
 *
 * Class对象的getResourceAsStream()可以从classpath中读取指定资源
 */
public class ReadResourcesFileExample {


    public static void main(String[] args) throws IOException {
        InputStream inputStream = ReadResourcesFileExample.class.getClassLoader().getResourceAsStream("/doc/test.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
    }

}
