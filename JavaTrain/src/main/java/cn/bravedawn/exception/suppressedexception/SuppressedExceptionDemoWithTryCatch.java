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
        try (DirtyResource resource= new DirtyResource()) {
            resource.accessResource();
        }
    }

    /**
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
                err.println("tThere are " + numSuppressed + " suppressed exceptions:");
                for (final Throwable exception : suppressedExceptions) {
                    err.println("tt" + exception.toString());
                }
            }
        }
    }


    /**
     * OUTPUT:
     * Exception encountered: java.lang.RuntimeException: I wanted to access this resource. Bad luck. Its dirty resource !!!
     * tThere are 1 suppressed exceptions:
     * ttjava.lang.NullPointerException: Remember me. I am your worst nightmare !! I am Null pointer exception !!
     */
}
