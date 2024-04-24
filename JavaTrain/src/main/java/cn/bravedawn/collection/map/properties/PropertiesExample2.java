package cn.bravedawn.collection.map.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

/**
 * @Description : Properties
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-25 16:56
 */
public class PropertiesExample2 {

    /**
     * 对properties文件进行写入操作，但是值得注意的是该写入操作会直接对文件内容进行覆盖，原有的配置项将会被清除
     */


    public static void main(String[] args) throws IOException {
        String path = PropertiesExample2.class.getClassLoader().getResource("setting.properties").getPath();
        System.out.println("path=" + path);
        FileOutputStream outputStream = new FileOutputStream(path);
        Properties props = new Properties();
        props.setProperty("url", "http://www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        props.store(outputStream, "这是写入的properties注释");
    }
}
