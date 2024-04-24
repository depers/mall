package cn.bravedawn.obj.object;

import java.util.Objects;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/5/12 7:46
 */
public class ObjectEqualsExample2 {

    /**
     * 两个空字符串是相等的
     */


    public static void main(String[] args) {
        String a = new String();
        String b = new String();

        System.out.println(Objects.equals(a, b)); // true

    }
}
