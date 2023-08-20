package cn.bravedawn.io.file.fileappend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 19:51
 */
public class FileAppend4b {

    /**
     * 使用PrintWriter追加多行字符串到文件中
     */

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/depers/newFile2.txt");
        List<String> list = List.of("你好", "hello", "hi");
        appendToFileFileWriter(file, list);
        System.out.println("Done");

    }


    private static void appendToFileFileWriter(
            File file, List<String> content) throws IOException {

        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (String s : content) {
                bw.write(s);
                bw.newLine();
            }
        }

    }

}
