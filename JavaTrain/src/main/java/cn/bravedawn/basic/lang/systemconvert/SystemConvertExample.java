package cn.bravedawn.basic.lang.systemconvert;

import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/6/17 18:53
 */
public class SystemConvertExample {

    /**
     * 如何在字符串后面补充字节0
     * @param value
     * @param len
     * @param padChar
     * @return
     */
    public static String padRight(String value, int len, char padChar) {
        if (StringUtils.isBlank(value)) {
            value = "";
        }

        int length = value.getBytes().length;
        if (length >= len) {
            return value;
        }

        StringBuilder sb = new StringBuilder(value);
        for (int i = 0; i < len - length; i++) {
            sb.append(padChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String value = "17393164120";
        byte[] array = padRight(value, 10, (char) 0).getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(array));
        System.out.println(bytestoBinaryString(array));
        System.out.println(bytesToHexString(array));

    }

    /**
     * 字节数组转十六进制字符串
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }

        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv).append(" ");
        }
        return stringBuilder.toString();
    }

    /**
     * 字节数组转二级制字符串
     * @param src
     * @return
     */
    public static String bytestoBinaryString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }

        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String value = Integer.toBinaryString(v);
            stringBuilder.append(value).append(" ");
        }
        return stringBuilder.toString();
    }
}
