package cn.bravedawn.io.bytestream;

import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-10 11:04
 *
 * 读取压缩文件
 */
public class ZipInputStreamExample {


    public static void main(String[] args) throws Exception{
        // 读取zip压缩文件
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(""))) {
            // 一个ZipEntry表示一个压缩文件或目录
            ZipEntry entry = null;
            while ((entry = zip.getNextEntry()) != null) {
                String name = entry.getName();
                if (!entry.isDirectory()) {
                    int n;
                    while ((n = zip.read()) != -1) {

                    }
                }
            }
        }
    }
}
