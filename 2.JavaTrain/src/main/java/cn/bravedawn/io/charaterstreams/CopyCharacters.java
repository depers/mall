package cn.bravedawn.io.charaterstreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/15 17:18
 */
public class CopyCharacters {

    /**
     * 使用FileReader和FileWriter读取和写入文件
     */

    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("newFile.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            // int 变量c 在其最后 16 位中保存一个字符值
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
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
