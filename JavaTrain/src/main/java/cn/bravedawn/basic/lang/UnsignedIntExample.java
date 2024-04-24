package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: 无符号整型计算
 * @date : Created in 2022/1/11 8:41
 */
public class UnsignedIntExample {

    /**
     * byte是有符号整型，范围是-128~127
     * 如果将其看作无符号整型，范围则是0~255
     */

    public static void main(String[] args) {
        byte x = -1;
        byte y = 127;
        byte z = -128;
        byte a = -127;

        System.out.println(Byte.toUnsignedInt(x)); // 255
        System.out.println(Byte.toUnsignedInt(y)); // 127
        System.out.println(Byte.toUnsignedInt(z)); // 128
        System.out.println(Byte.toUnsignedInt(a)); // 129
    }
}
