package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: 包装类型默认值
 * @date : Created in 2022/1/11 8:04
 */
public class TypeDefaultValueExample2 {

    /**
     * 包装类型的默认值都为null
     */

    private Byte v1;
    private Short v2;
    private Integer v3;
    private Long v4;
    private Float v5;
    private Double v6;
    private Character v7;
    private Boolean v8;


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
        TypeDefaultValueExample2 defaultValueExample = new TypeDefaultValueExample2();
        System.out.println(defaultValueExample);
    }
}
