package cn.bravedawn.basic.exception;

import static java.lang.System.err;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: After suppressed exceptions support in Java 7
 * @date : Created in 2021/10/10 9:44
 */
public class SuppressedExceptionDemoWithTryFinallyNew {


    /**
     * Executable member function demonstrating suppressed exceptions
     * Suppressed expression is added back in primary exception
     */
    public static void memberFunction() throws Exception {
        Throwable th = null;
        DirtyResource resource = new DirtyResource();

        try {
            resource.accessResource();
        } catch (Exception e) {
            th = e;
        } finally {
            try {
                resource.close();
            } catch (Exception e) {
                if (th != null) {
                    e.addSuppressed(th);
                    throw e;
                }
            }
        }
    }

    public static void main(String[] arguments) throws Exception
    {
        try {
            memberFunction();
        }
        catch(Exception ex)
        {
            err.println("Exception encountered: " + ex.toString());
            final Throwable[] suppressedExceptions = ex.getSuppressed();
            final int numSuppressed = suppressedExceptions.length;
            if (numSuppressed > 0)
            {
                err.println("tThere are " + numSuppressed + " suppressed exceptions:");
                for (final Throwable exception : suppressedExceptions)
                {
                    err.println("tt" + exception.toString());
                }
            }
        }
    }

    /**
     * OUTPUT:
     * Exception encountered: java.lang.NullPointerException: Remember me. I am your worst nightmare !! I am Null pointer exception !!
     * tThere are 1 suppressed exceptions:
     * ttjava.lang.RuntimeException: I wanted to access this resource. Bad luck. Its dirty resource !!!
     */
}
