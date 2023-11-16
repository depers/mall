package cn.bravedawn.io.path;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-08 15:30
 */
public class FileAndPathInstanceExample {


    /**
     * 映射功能：File和Path实例的创建
     */

    public static void main(String[] args) {
        // 构建实例
        java.io.File file = new java.io.File("baeldung/tutorial.txt");
        java.nio.file.Path path = java.nio.file.Paths.get("baeldung/tutorial.txt");

        File file2 = new File("baeldung", "tutorial.txt");
        Path path2 = Paths.get("baeldung", "tutorial.txt");

        Path path3 = Paths.get("baeldung").resolve("tutorial.txt");

        // 在File和Path之间转换
        Path pathFromFile = file.toPath();
        File fileFromPath = path.toFile();


    }

}
