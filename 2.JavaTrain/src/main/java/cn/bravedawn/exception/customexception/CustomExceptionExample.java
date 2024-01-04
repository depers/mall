package cn.bravedawn.exception.customexception;

public class CustomExceptionExample {

    /**
     * 这里我们对Throwable的四个参数进行了探究
     * message – 错误信息
     * cause – 错误原因，可以为null，标识不存在原因或是未知
     * enableSuppression – 是否开启抑制异常
     * writableStackTrace – 表示当前异常的位置是否会被写入异常堆栈
     */


    public static void run() {
        throw new IllegalArgumentException("参数错误");
    }

    public static void main(String[] args) {
        test1(true, true);
        /**
         * cn.bravedawn.exception.customexception.CustomRuntimeException: 出错了
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.test1(CustomExceptionExample.java:65)
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.main(CustomExceptionExample.java:19)
         * 	Suppressed: java.lang.IllegalArgumentException: 参数错误
         * 		at cn.bravedawn.exception.customexception.CustomExceptionExample.run(CustomExceptionExample.java:15)
         * 		at cn.bravedawn.exception.customexception.CustomExceptionExample.test1(CustomExceptionExample.java:59)
         * 		... 1 more
         * Caused by: java.lang.IllegalStateException: 异常原因
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.test1(CustomExceptionExample.java:64)
         * 	... 1 more
         */


        test1(false, true);
        /**
         * cn.bravedawn.exception.customexception.CustomRuntimeException: 出错了
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.test1(CustomExceptionExample.java:65)
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.main(CustomExceptionExample.java:31)
         * Caused by: java.lang.IllegalStateException: 异常原因
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.test1(CustomExceptionExample.java:64)
         * 	... 1 more
         */


        test1(true, false);
        /**
         * cn.bravedawn.exception.customexception.CustomRuntimeException: 出错了
         * 	Suppressed: java.lang.IllegalArgumentException: 参数错误
         * 		at cn.bravedawn.exception.customexception.CustomExceptionExample.run(CustomExceptionExample.java:15)
         * 		at cn.bravedawn.exception.customexception.CustomExceptionExample.test1(CustomExceptionExample.java:59)
         * 		at cn.bravedawn.exception.customexception.CustomExceptionExample.main(CustomExceptionExample.java:39)
         * Caused by: java.lang.IllegalStateException: 异常原因
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.test1(CustomExceptionExample.java:64)
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.main(CustomExceptionExample.java:39)
         */


        test1(false, false);
        /**
         * cn.bravedawn.exception.customexception.CustomRuntimeException: 出错了
         * Caused by: java.lang.IllegalStateException: 异常原因
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.test1(CustomExceptionExample.java:64)
         * 	at cn.bravedawn.exception.customexception.CustomExceptionExample.main(CustomExceptionExample.java:49)
         */
    }


    private static void test1(boolean enableSuppression, boolean writableStackTrace) {
        Throwable th = null;
        try {
            run();
        } catch (Throwable e) {
            th = e;
        } finally {

            IllegalStateException stateException = new IllegalStateException("异常原因");
            CustomRuntimeException exception = new CustomRuntimeException("出错了", stateException, enableSuppression, writableStackTrace);
            exception.addSuppressed(th);
            exception.printStackTrace();
        }
    }



}
