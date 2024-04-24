package cn.bravedawn.collection.map.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description : Properties
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-25 17:22
 */
public class PropertiesExample4 {


    /**
     * Properties继承自Hashtable，可以使用继承下来的get()和put()方法，但是他们的参数是Object类型，不建议使用
     */

    public static void main(String[] args) throws IOException {

        String fileName = "setting.properties";

        Properties properties = new Properties();
        properties.load(PropertiesExample.class.getClassLoader().getResourceAsStream(fileName));

        String filePath = (String) properties.get("last_open_file");
        System.out.println(filePath);
    }
}
