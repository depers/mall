package cn.bravedawn.basic.lang.string;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/5/17 11:54
 */
public class FormatExample {

    /**
     * 对字符串进行格式化输出，使用format方法
     */

    public static void main(String[] args) {
        String name = "sonoo";
        String sf1 = String.format("name is %s", name);
        String sf2 = String.format("value is %f", 32.33434);
        String sf3 = String.format("value is %32.12f", 32.33434); //returns 12 char fractional part filling with 0

        System.out.println(sf1);
        System.out.println(sf2);
        System.out.println(sf3);
    }
}
