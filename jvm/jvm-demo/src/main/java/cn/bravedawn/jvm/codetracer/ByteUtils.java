package cn.bravedawn.jvm.codetracer;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/21 15:30
 */
public class ByteUtils {


    /**
     * Bytes数组处理工具
     */

    /**
     * 将byte转换为整数
     * @param b byte数组
     * @param start 起点
     * @param len 长度
     * @return
     */
    public static int byte2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }

        return sum;
    }

    /**
     * 将byte转换为字符串
     * @param b byte数组
     * @param start 起点
     * @param len 长度
     * @return
     */
    public static String bytes2String(byte[] b, int start, int len) {
        return new String(b, start, len);
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }

    /**
     * 将整数转换为固定长度的byte数组
     * @param value 整数
     * @param len 装换后byte数组的长度
     * @return
     */
    public static byte[] int2Bytes(int value, int len) {
        byte[] b = new byte[len];
        for(int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return b;
    }
}
