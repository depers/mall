package cn.bravedawn.io.file.readfiletostring;

import java.io.*;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/3 14:11
 */
public class BufferedReaderExample2 {

    /**
     * 使用BufferedReader和char数组将文件读取到String
     */
    public static void main(String[] args) throws IOException {
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("doc/test.txt").getPath());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
            stringBuilder.append(new String(buffer));
            buffer = new char[10];
        }
        reader.close();

        String content = stringBuilder.toString();
        System.out.println(content);
    }
}
