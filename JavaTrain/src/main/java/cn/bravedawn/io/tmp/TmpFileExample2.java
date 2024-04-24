package cn.bravedawn.io.tmp;

import java.io.File;
import java.io.IOException;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/3/26 21:09
 *
 * 使用Java IO创建临时目录
 */
public class TmpFileExample2 {


    public static void main(String[] args) {
        // Java IO
        try {
            File temp = File.createTempFile("log_", ".tmp");
            System.out.println("Temp file : " + temp.getAbsolutePath());

            String absolutePath = temp.getAbsolutePath();
            String tempFilePath = absolutePath
                    .substring(0, absolutePath.lastIndexOf(File.separator));

            System.out.println("Temp file path : " + tempFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
