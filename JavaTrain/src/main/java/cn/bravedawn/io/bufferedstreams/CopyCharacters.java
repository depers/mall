package cn.bravedawn.io.bufferedstreams;

import java.io.*;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/15 17:18
 */
public class CopyCharacters {

    /**
     * 使用BufferedReader和BufferedWriter缓冲流 读取和写入文件
     */

    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("newFile.txt"));
            outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));

            int c;
            // int 变量c 在其最后 16 位中保存一个字符值
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
            outputStream.flush();
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
