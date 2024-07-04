package cn.bravedawn.basic.lang.string;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/6/19 14:27
 */
public class StringWriterExample {

    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (Throwable e) {
            String s = getStackTraceAsString(e);
            System.out.println(s);
        }
    }

    protected static String getStackTraceAsString(Throwable cause) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        cause.printStackTrace(printWriter);
        return stringWriter.getBuffer().toString();
    }
}
