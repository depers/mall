package cn.bravedawn.io.bytestream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 15:37
 */
public class PushbackInputStreamExample {


    /**
     * PushbackInputStream 类覆盖 InputStream，并为另一个输入流提供额外的功能。它可以取消读取已读取的字节并推回一个字节。
     *
     * 下面的这个程序，如果遇到连续的两个##就输出**，否则回退一个字符
     */


    public static void main(String[] args) throws IOException {
        String srg = "1##2#34###12";
        byte ary[] = srg.getBytes();
        ByteArrayInputStream array = new ByteArrayInputStream(ary);
        PushbackInputStream push = new PushbackInputStream(array);
        int i;
        while( (i = push.read())!= -1) {
            if(i == '#') {
                int j;
                if( (j = push.read()) == '#'){
                    System.out.print("**");
                }else {
                    push.unread(j);
                    System.out.print((char)i);
                }
            }else {
                System.out.print((char)i);
            }
        }
    }
}
