package cn.bravedawn.basic.coreclass.decimalformat;

import cn.bravedawn.basic.coreclass.bigdecimal.BigDecimalExample;

import java.text.DecimalFormat;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/4/26 17:03
 */
public class ZeroPlaceholder {

    /**
     * 0占位符的使用
     * 使用0占位符的时候：
     * 1、 比实际数字的位数多，不足的地方用0补上。
     * 2、 比实际数字的位数少：整数部分不改动，小数部分，四舍五入（其实并不是四舍五入，而是默认的RoundingMode.HALF_EVEN方式）
     *
     */


    public static void main(String[] args) {
        // 占位符0的个数多于数字的个数
        String a = new DecimalFormat("00.00").format(3.14567);//结果：03.15
        System.out.println(a);
        String b = new DecimalFormat("0.000").format(3.14);//结果：3.140
        System.out.println(b);
        String c = new DecimalFormat("00.000").format(3.14);//结果：03.140
        System.out.println(c);
        String g = new DecimalFormat("0.00").format(21);
        System.out.println(g);

        // 占位符0的个数少于数字的个数
        String d = new DecimalFormat("00.00").format(13.14567);//结果：13.15
        System.out.println(d);
        String e = new DecimalFormat("0.000").format(13.14567);//结果：13.146
        System.out.println(e);
        String f = new DecimalFormat("0.00").format(13.14567);//结果：13.15
        System.out.println(f);
    }
}
