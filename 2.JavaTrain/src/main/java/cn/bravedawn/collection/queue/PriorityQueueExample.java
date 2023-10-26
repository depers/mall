package cn.bravedawn.collection.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-26 17:37
 */
public class PriorityQueueExample {


    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();

        // 添加元素
        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");

        // 检索但不删除此队列的头部
        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println("-------------------------------");

        // 遍历队列的元素
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 检索和删除队列的头部

    }
}
