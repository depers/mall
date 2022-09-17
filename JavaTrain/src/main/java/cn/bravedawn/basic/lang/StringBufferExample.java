package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/1/12 15:23
 */
public class StringBufferExample {

    /**
     * StringBuffer的使用
     */

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.append("b");

        // 删除最后一个字符
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        System.out.println(stringBuffer);

    }
}
