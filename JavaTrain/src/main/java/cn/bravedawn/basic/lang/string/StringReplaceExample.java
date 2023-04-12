package cn.bravedawn.basic.lang.string;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/4/12 20:56
 */
public class StringReplaceExample {

    /**
     * String中 replace与replaceAll之间的区别
     *
     * 相同点：都是全部替换,即把源字符串中的某一字符或字符串全部换成指定的字符或字符串
     * 不同点：
     *      1.replace的参数是char和CharSequence,即可以支持字符的替换,也支持字符串的替换(CharSequence即字符串序列的意思,说白了也就是字符串);
     *      2.replaceAll的参数是regex或者char,即基于规则表达式的替换,比如,可以通过replaceAll("\\d", "*")把一个字符串所有的数字字符都换成星号;
     */

    public static void main(String[] args) {
        String s = "abababab";
        System.out.println(s.replace("b", "-"));

        String s2 = "a1a2a3a4";
        System.out.println(s2.replaceAll("\\d", "*"));
    }
}
