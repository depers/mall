package cn.bravedawn.collection.map.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description : Properties
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-25 16:37
 */
public class PropertiesExample {


    /**
     * properties读取配置文件
     */

    public static void main(String[] args) throws IOException {
        String fileName = "setting.properties";

        Properties properties = new Properties();
        properties.load(PropertiesExample.class.getClassLoader().getResourceAsStream(fileName));

        String filePath = properties.getProperty("last_open_file");
        String interVal = properties.getProperty("auto_save_interval");
        System.out.println(filePath);
        System.out.println(interVal);
    }

}
