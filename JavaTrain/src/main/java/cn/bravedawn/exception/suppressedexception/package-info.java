package cn.bravedawn.exception.suppressedexception;

/**
 * 这个包下面主要演示了 抑制异常
 * 定义：抑制的异常是被抛出但以某种方式被忽略的异常。Java 中的一个常见场景是finally块抛出异常。任何最初在try块中抛出的异常都会被抑制。
 *
 * 1.SuppressedExceptionDemoWithTryCatch：try-with-resource代码块可以直接捕获屏蔽异常。
 * 2.SuppressedExceptionDemoWithTryFinallyNew：手动调用addSuppressed()方法添加屏蔽异常到堆栈中。
 * 3.SuppressedExceptionDemoWithTryFinallyPrevious：finally会将try语句中的屏蔽异常吃掉
 * 4.SuppressedExceptionDemoWithTryWithResource：try-with-resources会将完整的异常堆栈打印出来，包含屏蔽异常
 */