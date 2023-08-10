package cn.bravedawn.io.bytearraystreams;

import cn.bravedawn.io.utils.ResourceHelper;
import org.springframework.util.FastByteArrayOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class FastByteArrayOutputStreamExample {

    /**
     * FastByteArrayOutputStream的演示：读取数据，处理数据，并将其输出到文件中
     *
     * FastByteArrayOutputStream是Spring框架中的一个字节数组输出流，它是对Java标准库中ByteArrayOutputStream的一个改进，
     * 提供了更高的性能和更低的内存占用。与Java标准库中的ByteArrayOutputStream相比，FastByteArrayOutputStream更适合处理大量数据的情况。
     */


    public static void main(String[] args) {
        String inputFilePath = ResourceHelper.getAbsoluteFilePath("doc/test.txt");
        URL resource = ByteArrayOutputStreamExample.class.getResource("/");
        String outputFilePath = resource.getPath() + "/doc/FastByteArrayOutputStreamExample.txt";

        try (
                FileInputStream fis = new FileInputStream(inputFilePath);
                FastByteArrayOutputStream faos = new FastByteArrayOutputStream();
                FileOutputStream fos = new FileOutputStream(outputFilePath)
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                faos.write(buffer, 0, len);
            }

            // 对数据进行处理
            byte[] data = faos.toByteArray();
            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) (data[i] + 1);
            }

            fos.write(data);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
