package cn.bravedawn.io.file.fileappend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 19:51
 */
public class FileAppend4 {

    /**
     * 使用PrintWriter追加文件内容
     */

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/depers/newFile2.txt");
        appendToFileFileWriter(file, "hello world2");
        System.out.println("Done");

    }

    private static void appendToFileFileWriter(File file, String content)
            throws IOException {

        // default - create and write
        // 若文件不存在，则创建文件并写入
        // 若文件存在, 则清空文件内容并写入
        /*try (FileWriter fw = new FileWriter(file);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(content);
                bw.newLine();
        }*/

        // append mode
        // if file not exists, create and write
        // if file exists, append to the end of the file
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(content);
            bw.newLine();   // add new line, System.lineSeparator()

        }

    }

}
