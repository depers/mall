package cn.bravedawn.collection.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-26 17:10
 */
public class QueueExample {

    /**
     * Queue的实现类 LinkedList的简单使用
     */


    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // 添加元素
        queue.add("a");
        queue.offer("b");
        queue.add("c");

        // 遍历队列中的元素
        System.out.println("遍历队列中的元素");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------------");

        // 检索但不删除此队列的头部
        System.out.println("检索但不删除此队列的头部");
        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println("-------------------------------");

        // 检索并删除队列的头部
        System.out.println("检索并删除队列的头部");
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println("-------------------------------");

        // 删除两个头信息之后
        System.out.println("删除两个头信息之后，遍历队列");
        Iterator<String> itr2 = queue.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }

    }
}
