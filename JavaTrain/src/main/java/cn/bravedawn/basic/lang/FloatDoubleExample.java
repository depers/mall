package cn.bravedawn.basic.lang;

import java.text.DecimalFormat;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/1/12 16:21
 */
public class FloatDoubleExample {


    public static void main(String[] args) {
        float f = 1.1f;
        // float f = 1.1;
        double d = 1.1;


        retain();
    }



    // 保留两位小数
    public static void retain() {
        double d = 123.546;
        float f = 123.546f;

        System.out.println(String.format("%.2f", d));
        System.out.println(String.format("%.2f", f));

        System.out.println("----------------------");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println(decimalFormat.format(d));
        System.out.println(decimalFormat.format(f));
    }
}
