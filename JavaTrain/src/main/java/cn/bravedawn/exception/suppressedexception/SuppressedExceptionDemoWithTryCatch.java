package cn.bravedawn.exception.suppressedexception;

import static java.lang.System.err;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: try-with-resource block in a member function and catching the exception
 * @date : Created in 2021/10/10 9:48
 */
public class SuppressedExceptionDemoWithTryCatch {

    public static void memberFunction() throws Exception {
        try (DirtyResource resource = new DirtyResource()) {
            resource.accessResource();
        }
    }

    /**
     * 调用成员方法演示使用try-with-resources捕获抑制异常：
     * Executable member function demonstrating suppressed exceptions using try-with-resources
     */
    public static void main(String[] arguments) throws Exception {
        try {
            memberFunction();
        } catch(Exception ex) {
            err.println("Exception encountered: " + ex.toString());
            final Throwable[] suppressedExceptions = ex.getSuppressed();
            final int numSuppressed = suppressedExceptions.length;
            if (numSuppressed > 0) {
                err.println("There are " + numSuppressed + " suppressed exceptions:");
                for (final Throwable exception : suppressedExceptions) {
                    err.println("t" + exception.toString());
                }
            }
        }
    }


    /**
     * OUTPUT:
     * Exception encountered: java.lang.RuntimeException: 我想访问这个资源，不幸的是他是脏数据！！！
     * There are 1 suppressed exceptions:
     * tjava.lang.NullPointerException: 关闭资源的时候，会抛出空指针!!
     */
}
