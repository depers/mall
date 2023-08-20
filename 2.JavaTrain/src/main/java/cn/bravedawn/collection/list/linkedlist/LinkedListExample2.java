package cn.bravedawn.collection.list.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/9 17:30
 */
public class LinkedListExample2 {

    /**
     * LinkedList的基本操作
     * 参考文章：https://www.baeldung.com/java-linkedlist
     */


    public static void main(String[] args) {

        // 创建
        LinkedList<Integer> list = new LinkedList<>();

        // 添加元素
        list.add(1);
        list.addAll(List.of(2, 3));

        // 添加为头节点
        list.addFirst(4);
        // 添加为尾节点
        list.addLast(5);
        System.out.println(list); // [4, 1, 2, 3, 5]

        // 移除列表的第一个元素
        list.removeFirst();
        // 移除列表的最后一个元素
        list.removeLast();
        System.out.println(list);

        // 移除列表中指定元素第一次出现的元素，若该元素存在则返回true。和上面的removeFirst意思不同
        boolean b = list.removeFirstOccurrence(1);
        System.out.println("移除1之后：" + list); // [2, 3]
        // 移除列表中指定元素最后一次出现的元素，若该元素存在则返回true。和上面的removeLast意思不同
        boolean b1 = list.removeLastOccurrence(3);
        System.out.println("移除3之后：" + list); // [2]
        System.out.println(b); // true
        System.out.println(b1); // true

        // 队列操作
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList.poll()); // null
        // System.out.println(linkedList.pop());  // java.util.NoSuchElementException
        linkedList.push(1);
        System.out.println(linkedList); // [1]
    }
}
