package cn.bravedawn.io.file.createfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/7 17:30
 */
public class CreateFile4 {

    /**
     * 方式四：使用File.createNewFile()创建空文件，然后使用PrinterWriter写入内容
     */

    public static void main(String[] args) {
        String fileName = "/Users/depers/newFile.txt";

        try {

            File file = new File(fileName);

            // true if file does no exist and was created successfully.
            // false if file is already exists
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            // Write to file
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Hello World!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
