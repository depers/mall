package cn.bravedawn.io.bytestreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/15 16:52
 */
public class CopyBytes {

    /**
     * 演示了FileInputStream和FileOutputStream的使用
     */

    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("newFile.txt");

            // 会自动创建文件
            out = new FileOutputStream("outagain.txt");
            int c;

            // int 变量在其最后 8 位中保存一个字节值
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            // 这里有两点需要注意的地方：
            // 1.需要在finally中添加关闭流的逻辑，避免资源泄露
            // 2.在关闭流时需要判断流是否为空
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
