package cn.bravedawn.io.file.readfile;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/8 22:00
 */
public class ReadFile5 {

    /**
     * 一个经典的老朋友 BufferedReader 示例，在读取大小文件时效果很好，
     * 默认缓冲区大小 (8k) 足以满足大多数用途。
     */
    public static void main(String[] args) throws IOException {
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

        // defaultCharBufferSize = 8192; or 8k
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
