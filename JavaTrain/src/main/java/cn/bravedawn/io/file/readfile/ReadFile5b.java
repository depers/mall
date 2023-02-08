package cn.bravedawn.io.file.readfile;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/8 22:04
 */
public class ReadFile5b {

    /**
     * 指定缓存区的大小
     */

    public static void main(String[] args) throws IOException {
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

        int bufferSize = 10240; //10k
        try (BufferedReader br = new BufferedReader(
                new FileReader(fileName), bufferSize)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

    }
}
