package cn.bravedawn.io.nio.buffer;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author : depers
 * @description :
 * @program : 2.JavaTrain
 * @date : Created in 2024/1/7 21:26
 *
 * 下面的这段代码中演示了 如何将写入buff中字符串，再重新读取出来
 */
public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException{
        fun1();

        System.out.println("-------------------");
        // 最佳实践
        fun2();
    }

    private static void fun2() throws IOException {
        String encoding = System.getProperty("file.encoding");
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes(encoding)));
        fc.close();
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        System.out.println(Charset.forName(encoding).decode(buff));
    }


    /**
     *
     */
    public static void fun1() throws IOException {
        // 将字符串写入文件
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        // 方式一：直接读取缓冲区的内容，实验失败
        // 将文件中的内容读取到缓冲区
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        // 输出的内容是乱码的
        System.out.println(buff.asCharBuffer());

        // 方式二：使用Charset对缓冲区的内容进行解码，实验成功
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("use encoding " + encoding + " decode :" + Charset.forName(encoding).decode(buff));

        // 方式三：在写入的时候就制定编码，读取的时候就不需要解码了。这种和书上写的不一样，实验失败了
        fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes(encoding)));
        fc.close();
        fc = new FileInputStream("data.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        // 方式四：使用CharBuffer去做写操作，实验失败
        fc = new FileOutputStream("data.txt").getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
        fc = new FileInputStream("data.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }


}
