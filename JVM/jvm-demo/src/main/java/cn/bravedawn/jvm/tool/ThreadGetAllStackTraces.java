package cn.bravedawn.jvm.tool;

import java.util.Map;

/**
 * @author : depers
 * @program : jasper
 * @description:
 * @date : Created in 2023/4/18 20:48
 */
public class ThreadGetAllStackTraces {

    /**
     * 查看当前虚拟机的线程情况
     */

    public static void main(String[] args) {

        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stack = stackTrace.getValue();
            if (thread.equals(Thread.currentThread())) {
                continue;
            }

            System.out.print("\n线程：" + thread.getName() + "\n");
            for (StackTraceElement element : stack) {
                System.out.print("\t" + element + "\n");
            }
        }
    }
}
