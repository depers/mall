package cn.bravedawn.collection.list.removefirstelement;

import java.util.ArrayList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/21 17:30
 */
public class RemoveFirstElementExample {

    /**
     * 在ArrayList实现中移除第一个元素
     * 缺点：ArrayList移除一个元素的时间复杂度是O(n)，因为他涉及到数组其余元素的位置移动
     */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("pig");
        list.add("cow");
        list.add("goat");
        list.remove(0);

        System.out.println(list);

    }


}
