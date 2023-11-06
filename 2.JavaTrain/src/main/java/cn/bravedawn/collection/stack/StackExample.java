package cn.bravedawn.collection.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-03 11:48
 */
public class StackExample {

    /**
     * 栈的基本使用
     * 因为有个遗留类名字叫Stack，出于兼容性的考虑，所以没有办法创建Stack接口，只能使用Deque接口来“模拟”一个Stack了。
     * @param args
     */

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        // 将元素入栈
        deque.push(1);
        deque.push(2);
        deque.push(3);

        System.out.println("栈内元素：" + deque);

        // 把栈顶的元素出栈
        int popResult = deque.pop();
        System.out.println("出栈：" + popResult);

        // 输出栈内元素，但不出栈
        System.out.println("输出栈内元素：" + deque.peek());
        System.out.println("栈内元素：" + deque);
    }

}
