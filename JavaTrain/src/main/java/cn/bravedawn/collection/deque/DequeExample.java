package cn.bravedawn.collection.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description : Deque
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-30 14:09
 */
public class DequeExample {

    /**
     * 双端队列Deque的使用
     */


    public static void main(String[] args) {

        Deque<String> deque = new LinkedList<>();
        // 添加元素到队尾
        deque.offerLast("A"); // A
        // 添加元素到队尾
        deque.offerLast("B"); // A <- B
        // 添加元素到队首
        deque.offerFirst("C"); // C <- A <- B
        // 取队首元素并删除
        System.out.println(deque.pollFirst()); // C, 剩下A <- B
        // 取队尾并删除
        System.out.println(deque.pollLast()); // B, 剩下A
        // 取队首并删除
        System.out.println(deque.pollFirst()); // A
        // 取队首并删除
        System.out.println(deque.pollFirst()); // null
    }


}
