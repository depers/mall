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
     * Executable member function demonstrating suppressed exceptions
     * One exception is lost if not added in suppressed exceptions list
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

    // Output: Exception encountered: java.lang.NullPointerException: Remember me. I am your worst nightmare !! I am Null pointer exception !!
}
