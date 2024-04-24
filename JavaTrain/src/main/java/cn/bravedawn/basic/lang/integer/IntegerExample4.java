package cn.bravedawn.basic.lang.integer;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-02 17:02
 */
public class IntegerExample4 {

    /**
     * Java中整数转16进制
     */


    public static void main(String[] args) {
        convert2Hex();
    }


    public static void convert2Hex() {
        for (int i = 10; i < 20; i++) {
            System.out.println(i + "系统方法：" + Integer.toHexString(i));
            System.out.println(i + "自定义方法：" + byteToHex(i));
        }
    }


    private final static String[] hexArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String byteToHex(int n) {
        if (n < 0) {
            n = n + 256;
        }

        int d1 = n / 16;
        int d2 = n %16;
        return hexArray[d1] + hexArray[d2];
    }

}
