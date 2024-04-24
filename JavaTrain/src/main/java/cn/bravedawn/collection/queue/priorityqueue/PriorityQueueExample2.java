package cn.bravedawn.collection.queue.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description : 可以设置优先级的队列
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-27 10:26
 */
public class PriorityQueueExample2 {

    /**
     * PriorityQueue实现了一个优先队列：从队首获取元素时，总是获取优先级最高的元素。
     * PriorityQueue默认按元素比较的顺序排序（必须实现Comparable接口），也可以通过Comparator自定义排序算法（元素就不必实现Comparable接口）。
     */

    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}
