package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/29 14:03
 */
public class StringBuilderExample {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("1");
        if (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) == '_') {
            System.out.println("结尾存在_字符");
        }

        System.out.println(buffer.length());
    }
}
