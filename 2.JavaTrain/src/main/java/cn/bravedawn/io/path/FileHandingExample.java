package cn.bravedawn.io.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-08 15:07
 */
public class FileHandingExample {

    /**
     * File类的缺点：对于常见的异常，处理不当。而Path则要求我们进行IOException的处理
     */


    public static void main(String[] args) {
        deleteOfFile("baeldung/tutorial.txt");

        deleteOfPath("baeldung/tutorial.txt");
    }


    static void deleteOfFile(String filePath) {
        File file = new File(filePath);
        boolean result = file.delete();
    }


    static void deleteOfPath(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
