package cn.bravedawn.io.file.createfile;

import java.io.File;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/6/6 16:58
 */
public class CreateFileNotDirExample {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/depers/dir/test.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            if (newFile) {
                System.out.println("创建成功");
            }
        }
    }
}
