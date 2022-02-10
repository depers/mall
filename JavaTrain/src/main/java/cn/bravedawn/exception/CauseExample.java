package cn.bravedawn.exception;

import java.util.Arrays;

public class CauseExample {

    /**
     * 在这个类中我们探究了 getCause和printStackTrace的功能
     * getCause: 返回抛出改异常的原因
     * printStackTrace：打印异常堆栈，报错异常原因堆栈和抑制异常
     */


    public static void main(String[] args) {
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("数组越界了");
        RuntimeException runtimeException = new RuntimeException("运行时异常", indexOutOfBoundsException);
        Exception e = new Exception(runtimeException);

        System.out.println(indexOutOfBoundsException.getCause());
        System.out.println(runtimeException.getCause());
        System.out.println(e.getCause());


        System.out.println("--------------------------------");
        Arrays.stream(indexOutOfBoundsException.getStackTrace()).forEach(st -> System.out.println(st));
        Arrays.stream(runtimeException.getStackTrace()).forEach(st -> System.out.println(st));
        Arrays.stream(e.getStackTrace()).forEach(st -> System.out.println(st));

        System.out.println("--------------------------------");
        indexOutOfBoundsException.printStackTrace();
        /**
         * java.lang.IndexOutOfBoundsException: 数组越界了
         * 	at cn.bravedawn.exception.CauseExample.main(CauseExample.java:9)
         */

        runtimeException.printStackTrace();
        /**
         * java.lang.RuntimeException: 运行时异常
         * 	at cn.bravedawn.exception.CauseExample.main(CauseExample.java:10)
         * Caused by: java.lang.IndexOutOfBoundsException: 数组越界了
         * 	at cn.bravedawn.exception.CauseExample.main(CauseExample.java:9)
         */

        e.printStackTrace();
        /**
         * java.lang.Exception: java.lang.RuntimeException: 运行时异常
         * 	at cn.bravedawn.exception.CauseExample.main(CauseExample.java:11)
         * Caused by: java.lang.RuntimeException: 运行时异常
         * 	at cn.bravedawn.exception.CauseExample.main(CauseExample.java:10)
         * Caused by: java.lang.IndexOutOfBoundsException: 数组越界了
         * 	at cn.bravedawn.exception.CauseExample.main(CauseExample.java:9)
         */
    }
}
