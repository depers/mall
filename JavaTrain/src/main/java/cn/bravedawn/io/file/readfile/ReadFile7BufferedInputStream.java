package cn.bravedawn.io.file.readfile;

import java.io.*;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 17:42
 */
public class ReadFile7BufferedInputStream {

    /**
     * Java BufferedInputStream 类用于从流中读取信息。 它内部使用缓冲机制来提高性能。
     * DataInputStream 类型的 readLine() 已弃用。 Sun 正式宣布此方法无法将属性从字节转换为字符。 建议使用 BufferedReader。
     */

    public static void main(String[] args) {
        File file = new File("C:\\testing.txt");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(file);

            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            while (dis.available() != 0) {
                System.out.println(dis.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                bis.close();
                dis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
