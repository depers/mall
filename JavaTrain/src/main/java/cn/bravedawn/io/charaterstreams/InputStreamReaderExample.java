package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 15:31
 */
public class InputStreamReaderExample {


    /**
     * InputStreamReader 是从字节流到字符流的桥梁：它读取字节并使用指定的字符集将它们解码为字符。它使用的字符集可以按名称指定，也可以显式给出，或者可以接受平台的默认字符集。
     */

    public static void main(String[] args) {
        try  {
            String path = ResourceHelper.getAbsoluteFilePath("doc/testin.txt");
            InputStream stream = new FileInputStream(path);
            Reader reader = new InputStreamReader(stream, Charset.defaultCharset());
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
