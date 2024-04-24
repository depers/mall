package cn.bravedawn.io.bytestream;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-10 11:07
 *
 * 压缩文件
 */
public class ZipOutputStreamExample {


    public static void main(String[] args) throws Exception{
        List<File> files = new ArrayList<>();
        files.add(new File("E:\\test\\1"));
        files.add(new File("E:\\test\\2"));
        files.add(new File("E:\\test\\3"));
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("E:\\压缩文件.zip"))) {
            for (File file : files) {
                zip.putNextEntry(new ZipEntry(file.getName()));
                zip.write(Files.readAllBytes(file.toPath()));
                zip.closeEntry();
            }

        }
    }
}
