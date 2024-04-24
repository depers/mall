package cn.bravedawn.collection.list.judgelistequals;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/27 21:53
 */
public class JudgeListEqualsExample {

    /**
     * 使用列表自身实现的equals方法就可以保证列表中按顺序每个元素是相同的
     */

    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(1, 3, 4, 6, 8);
        List<Integer> second = Arrays.asList(8, 1, 6, 3, 4);
        List<Integer> third = Arrays.asList(1, 3, 3, 6, 6);
        List<Integer> forth = Arrays.asList(1, 3, 4, 6, 8);

        System.out.println(first.equals(forth)); // true
        System.out.println(first.equals(second)); // false

    }


}
