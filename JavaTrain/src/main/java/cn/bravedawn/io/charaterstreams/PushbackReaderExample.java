package cn.bravedawn.io.charaterstreams;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 15:43
 */
public class PushbackReaderExample {

    /**
     * PushbackReader 类是一个字符流读取器。它用于将字符推回流中并重写 FilterReader 类。
     */


    public static void main(String[] args) throws IOException {
        char ary[] = {'1', '-', '-', '2', '-', '3', '4', '-', '-', '-', '5', '6'};
        CharArrayReader reader = new CharArrayReader(ary);
        PushbackReader push = new PushbackReader(reader);
        int i;
        while ((i = push.read()) != -1) {
            if (i == '-') {
                int j;
                if ((j = push.read()) == '-') {
                    System.out.print("#*");
                } else {
                    push.unread(j); // push back single character
                    System.out.print((char) i);
                }
            } else {
                System.out.print((char) i);
            }
        }
    }
}
