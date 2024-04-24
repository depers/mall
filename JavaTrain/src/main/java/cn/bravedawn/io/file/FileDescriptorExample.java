package cn.bravedawn.io.file;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 16:22
 */
public class FileDescriptorExample {

    /**
     * FileDescriptor 类用作基础计算机特定结构的句柄，该结构表示打开的文件、打开的套接字或其他字节源或接收器。句柄可以是错误的，输入或输出。
     * FileDescriptor 类用于创建 FileInputStream 或 FileOutputStream 以包含它。
     */

    public static void main(String[] args) {
        FileDescriptor fd = null;
        byte[] b = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58};
        try {
            String path = ResourceHelper.getAbsoluteFilePath("doc/input.txt");
            FileOutputStream fos = new FileOutputStream(path);
            FileInputStream fis = new FileInputStream(path);
            fd = fos.getFD();
            fos.write(b);
            fos.flush();
            fd.sync();// confirms data to be written to the disk
            int value = 0;
            // for every available bytes
            while ((value = fis.read()) != -1) {
                char c = (char) value;// converts bytes to char
                System.out.print(c);
            }
            System.out.println("\nSync() successfully executed!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
