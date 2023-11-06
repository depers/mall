package cn.bravedawn.collection.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-03 15:34
 */

@Slf4j
public class StackExample3 {


    /**
     * 使用场景：将十进制整数转换为十六进制的，对整数进行进制的转换就可以利用栈去做
     */

    public static void main(String[] args) {
        System.out.println(toHex(12500));
    }


    public static String toHex(int number) {
        Deque<String> stack = new LinkedList<>();
        while (number != 0) {
            int remainder = number % 16;
            number = number / 16;
            log.info("remainder={}, number={}", remainder, number);
            stack.push(Integer.toHexString(remainder));
        }

        log.info("栈的大小是：{}", stack.size());
        StringBuilder builder = new StringBuilder();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            log.info("此时的栈顶元素是：{}", stack.peek());
            builder.append(stack.pop());
        }
        return builder.toString();
    }

}
