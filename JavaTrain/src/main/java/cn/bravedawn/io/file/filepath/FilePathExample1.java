package cn.bravedawn.io.file.filepath;

import java.io.File;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 17:07
 */
public class FilePathExample1 {

    /**
     * 文件分隔符：
     *  Windows = \
     *  Linux or Mac = /
     * 使用 File.separator 或 System.getProperty("file.separator")
     * 构建文件路径的经典 Java 示例。 两者都会检查操作系统并正确返回文件分隔符
     */

    public static void main(String[] args) {
        try {

            String filename = "newFile.txt";
            String workingDirectory = System.getProperty("user.dir");

            //****************//

            String absoluteFilePath = "";

            //absoluteFilePath = workingDirectory + System.getProperty("file.separator") + filename;
            absoluteFilePath = workingDirectory + File.separator + filename;

            System.out.println("Final filepath : " + absoluteFilePath);

            //****************//

            File file = new File(absoluteFilePath);

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File is already existed!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
