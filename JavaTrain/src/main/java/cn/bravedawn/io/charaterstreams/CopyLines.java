package cn.bravedawn.io.charaterstreams;

import java.io.*;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/15 17:29
 */
public class CopyLines {

    /**
     * 使用BufferedReader读取一行数据，PrintWriter写入一行数据
     */

    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("newFile.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutputline.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
