package cn.bravedawn.collection.list.judgelistequals;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/28 7:57
 */
public class JudgeListEqualsExample2 {

    /**
     * 判断两个集合是否相同，忽略顺序
     * @param args
     */


    public static void main(String[] args) {
        List<Integer> first = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> second = Lists.newArrayList(1, 4, 3, 2);

        List<String> third = Lists.newArrayList("a", "fengxiao", "ming", "li");
        List<String> fourth = Lists.newArrayList("fengxiao", "li", "ming", "a");


        System.out.println(judgeEquals(first, second));
        System.out.println(judgeEquals(third, fourth));

    }


    private static <T> boolean judgeEquals(List<T> firstList, List<T> secondList){
        if (firstList.size() != secondList.size()) {
            return false;
        }

        return firstList.stream().filter(secondList::contains).count() == firstList.size();
    }
}
