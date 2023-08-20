package cn.bravedawn.io.file.readfiletostring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/3 14:05
 */
public class BufferedReaderExample {

    /**
     * 使用BufferedReader readLine方法逐行读取文件
     */

    public static void main(String[] args) throws IOException, URISyntaxException {
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("doc/test.txt").getPath());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        // delete the last new line separator
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        String content = stringBuilder.toString();
        System.out.println(content);
    }
}
