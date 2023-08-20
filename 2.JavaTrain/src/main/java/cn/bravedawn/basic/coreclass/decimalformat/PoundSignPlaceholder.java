package cn.bravedawn.basic.coreclass.decimalformat;

import java.text.DecimalFormat;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/4/26 17:24
 */
public class PoundSignPlaceholder {

    /**
     * 使用#占位符的时候：
     * 1、 比实际数字的位数多，不变。
     * 2、 比实际数字的位数少：整数部分不改动，小数部分，四舍五入（其实并不是四舍五入，而是默认的RoundingMode.HALF_EVEN方式）。
     */

    public static void main(String[] args) {
        // 占位符比实际数字多
        String a = new DecimalFormat("##.##").format(3.14567);//结果：3.15
        System.out.println(a);
        String b = new DecimalFormat("#.###").format(3.14);//结果：3.14
        System.out.println(b);
        String c = new DecimalFormat("##.###").format(3.14);//结果：3.14
        System.out.println(c);

        // 占位符比实际数字少
        String d = new DecimalFormat("#.###").format(13.145678);//结果：13.146
        System.out.println(d);
        String e = new DecimalFormat("##.##").format(13.14567);//结果：13.15
        System.out.println(e);
        String f = new DecimalFormat("#.##").format(13.14567);//结果：13.15
        System.out.println(f);
    }
}
