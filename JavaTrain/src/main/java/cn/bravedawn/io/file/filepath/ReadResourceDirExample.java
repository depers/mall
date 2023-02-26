package cn.bravedawn.io.file.filepath;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/26 17:28
 */
public class ReadResourceDirExample {

    /**
     * 获取编译后的文件地址
     */


    public static void main(String[] args) throws IOException {
        String packageName = "cn.bravedawn.io.file";
        String path = packageName.replace(".", "/");
        System.out.println(path);
        ArrayList<URL> list = Collections.list(Thread.currentThread().getContextClassLoader().getResources(path));
        System.out.println(list);
    }
}
