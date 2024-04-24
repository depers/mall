package cn.bravedawn.io.file.readfile;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/8 22:13
 */
public class ReadFile6 {

    /**
     * 在Scanner类中，分隔符特性对于小文件的读取和过滤还是很有用的。
     * Java 9 和 Java 10 添加了 findAll 和构造函数等新方法来改进 Scanner 类。
     * 但是，对于读取大文件，此 Scanner 类与 BufferedReader 相比速度较慢。
     */

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");
        System.out.println(fileName);

        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
            }
        }

    }
}
