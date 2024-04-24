package cn.bravedawn.encrypt.digest.encrypted;

public class HashExample {

    /**
     * Java字符串的hashCode()就是一个哈希算法，它的输入是任意字符串，输出是固定的4字节int整数
     */

    public static void main(String[] args) {

        System.out.println("hello".hashCode());
        System.out.println("hello".hashCode());
        System.out.println(Integer.toHexString("hello".hashCode()));

        System.out.println("hello world".hashCode());
        System.out.println(Integer.toHexString("hello world".hashCode()));
    }
}
