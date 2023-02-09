package cn.bravedawn.io.file.createfile;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/7 17:26
 */
public class CreateFile3WithPrintWriter {


    /**
     * 方式三：使用PrintWriter创建和写入文件
     */

    public static void main(String[] args) {
        String fileName = "/Users/depers/newFile.txt";

        // Java 10, new constructor, support Charsets
        try (PrintWriter writer = new PrintWriter(fileName, StandardCharsets.UTF_8)) {

            writer.println("first line!");
            writer.println("second line!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Java 1.5
        /*try (PrintWriter writer = new PrintWriter(fileName, "UTF-8")) {

            writer.println("first line!");
            writer.println("second line!");

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
