package cn.bravedawn.collection.map.properties;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Description : Properties
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-25 17:05
 */
public class PropertiesExample3 {

    /**
     * Properties读取文件内容（包含中文），记得使用UTF-8编码
     */

    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        pros.load(new FileReader(PropertiesExample3.class.getClassLoader().getResource("setting.properties").getPath(), StandardCharsets.UTF_8));
        System.out.println(pros);
    }
}
