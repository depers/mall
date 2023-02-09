package cn.bravedawn.io.file.createfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 17:02
 */
public class CreateFile6 {

    /**
     * 在 Java 中，我们使用 FileOutputStream 将原始字节写入文件，如图像。
     */


    private static void writeFile(File file, byte[] bytes) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(bytes);
        }

        // append mode
        /*try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        }*/

    }
}
