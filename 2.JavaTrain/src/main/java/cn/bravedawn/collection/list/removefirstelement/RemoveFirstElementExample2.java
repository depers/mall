package cn.bravedawn.collection.list.removefirstelement;

import java.util.LinkedList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/22 17:28
 */
public class RemoveFirstElementExample2 {

    /**
     * 使用LinkedList的实现移除第一个元素
     * LinkedList移除一个元素的时间复杂度是O(1)
     */

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("cat");
        linkedList.add("dog");
        linkedList.add("pig");
        linkedList.add("cow");
        linkedList.add("goat");
        linkedList.removeFirst();

        System.out.println(linkedList);
    }
}
