package cn.bravedawn.io.file.filepath;

import java.io.File;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 17:10
 */
public class FilePathExample2 {

    /**
     * 一些开发人员正在使用新的 File() API 来构造文件路径。
     */

    public static void main(String[] args) {
        try {

            String filename = "newFile.txt";
            String workingDirectory = System.getProperty("user.dir");

            //****************//

            File file = new File(workingDirectory, filename);

            //****************//

            System.out.println("Final filepath : " + file.getAbsolutePath());
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
