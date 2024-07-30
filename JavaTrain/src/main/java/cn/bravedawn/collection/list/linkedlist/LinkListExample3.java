package cn.bravedawn.collection.list.linkedlist;

import java.util.LinkedList;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/24 20:51
 */
public class LinkListExample3 {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);

        linkedList.set(0, 3);
        System.out.println("set之后的list: " + linkedList);

        linkedList.add(0, 4);
        System.out.println("add之后的list: " + linkedList);
    }
}
