package cn.bravedawn.collection.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/23 16:24
 */
public class StackExample4 {

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("栈头元素：" + stack.peek());

        System.out.println("出栈：" + stack.pop());
        System.out.println("出栈：" + stack.pop());
        System.out.println("出栈：" + stack.pop());
    }
}
