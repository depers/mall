package cn.bravedawn.exception.suppressedexception;

import static java.lang.System.err;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: Before suppressed exceptions feature
 * @date : Created in 2021/10/10 9:33
 */
public class SuppressedExceptionDemoWithTryFinallyPrevious {

    /**
     * finally会将try语句中的屏蔽异常吃掉
     */

    public static void memberFunction() throws Exception {
        DirtyResource resource = new DirtyResource();
        try {
            resource.accessResource();
        } finally {
            resource.close();
        }
    }

    public static void main(String[] args) {
        try {
            memberFunction();
        } catch (Exception e) {
            err.println("Exception encountered: " + e.toString());
            Throwable[] suppressedExceptions = e.getSuppressed();
            int numSuppressed = suppressedExceptions.length;

            if (numSuppressed > 0) {
                err.println("There are " + numSuppressed + "suppressed exception");
                for (Throwable throwable : suppressedExceptions) {
                    err.println("tt " + throwable.toString());
                }
            }
        }
    }

    // Exception encountered: java.lang.NullPointerException: 关闭资源的时候，会抛出空指针!!
}
