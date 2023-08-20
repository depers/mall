package cn.bravedawn.collection.list.linkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/8 13:33
 */
public class LinkedListExample {

    public static void main(String[] args) {
        List list = Collections.synchronizedList(new LinkedList<>());
    }
}
