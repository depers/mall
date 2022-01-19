package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: 类型默认值
 * @date : Created in 2022/1/11 8:04
 */
public class TypeDefaultValueExample {

    private byte v1;        // 0
    private short v2;       // 0
    private int v3;         // 0
    private long v4;        // 0L
    private float v5;       // 0.0f
    private double v6;      // 0.0d
    private char v7;        // '\u0000'
    private boolean v8;     // false


    @Override
    public String toString() {
        return "TypeDefaultValueExample{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                ", v4=" + v4 +
                ", v5=" + v5 +
                ", v6=" + v6 +
                ", v7=" + v7 +
                ", v8=" + v8 +
                '}';
    }

    public static void main(String[] args) {
        TypeDefaultValueExample defaultValueExample = new TypeDefaultValueExample();
        System.out.println(defaultValueExample);

        // 比较下默认的char值是否是'/u0000'
        System.out.println(defaultValueExample.v7 == '\u0000');
    }
}
