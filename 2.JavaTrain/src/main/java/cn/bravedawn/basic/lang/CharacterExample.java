package cn.bravedawn.basic.lang;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2022/04/19 8:26 PM
 */
public class CharacterExample {

    /**
     * isJavaIdentifierStart()方法：确定是否允许该字符(Unicode代码点)作为Java标识符中的第一个字符。也就是判断这个字符是否符合Java命名开头字母的要求
     * charCount()方法：确定表示指定字符(Unicode码位)所需的字符值的数量。如果指定的字符等于或大于0x10000，则该方法返回2。否则，该方法返回1。也就是是否超出char类型的范围
     *
     * Java变量命名只能以$、下划线(_)或字母开头，其他字符及数字都不可以
     *
     */

    public static void main(String[] args) {

        char cp = '!';
        char cp2 = '2';
        char cp3 = '$';
        char cp4 = '_';
        char cp5 = 'c';

        System.out.println(Character.isJavaIdentifierStart(cp));
        System.out.println(Character.isJavaIdentifierStart(cp2));
        System.out.println(Character.isJavaIdentifierStart(cp3));
        System.out.println(Character.isJavaIdentifierStart(cp4));
        System.out.println(Character.isJavaIdentifierStart(cp5));

        System.out.println(Character.charCount(cp));

    }
}
