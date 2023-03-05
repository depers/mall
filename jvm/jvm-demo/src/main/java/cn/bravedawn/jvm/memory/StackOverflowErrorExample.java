package cn.bravedawn.jvm.memory;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/3/3 21:49
 */
public class StackOverflowErrorExample {

    /**
     * 虚拟机参数：-Xss208k
     * 这个演示和StackSizeTest的效果一样，都是为了演示递归循环调用方法，就有有很多的栈帧，从而增大了虚拟机栈的大小，从而触发栈溢出的异常
     * 这个演示是基于单线程的
     */


    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        StackOverflowErrorExample stackOverflowErrorExample = new StackOverflowErrorExample();
        try {
            stackOverflowErrorExample.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack Length = " + stackOverflowErrorExample.stackLength);
            throw e;
        }

    }
}
