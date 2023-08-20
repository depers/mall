package cn.bravedawn.io.file.filepath;

import java.io.File;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 17:14
 */
public class FilePathExample3 {

    /**
     * 检查系统操作系统并手动创建文件路径，只是为了好玩，不推荐。
     */

    public static void main(String[] args) {
        try {

            String filename = "testing.txt";
            String workingDir = System.getProperty("user.dir");

            String absoluteFilePath = "";

            //****************//

            String your_os = System.getProperty("os.name").toLowerCase();

            if (your_os.indexOf("win") >= 0) {

                // if windows
                absoluteFilePath = workingDir + "\\" + filename;

            } else if (your_os.indexOf("nix") >= 0 ||
                    your_os.indexOf("nux") >= 0 ||
                    your_os.indexOf("mac") >= 0) {

                // if unix or mac
                absoluteFilePath = workingDir + "/" + filename;

            } else {

                // unknow os?
                absoluteFilePath = workingDir + "/" + filename;

            }

            System.out.println("Final filepath : " + absoluteFilePath);

            //****************//

            File file = new File(absoluteFilePath);

            if (file.createNewFile()) {
                System.out.println("Done");
            } else {
                System.out.println("File already exists!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
