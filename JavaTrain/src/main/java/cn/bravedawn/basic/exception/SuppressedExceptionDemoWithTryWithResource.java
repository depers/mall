package cn.bravedawn.basic.exception;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: Default try-with-resource block
 * @date : Created in 2021/10/10 9:54
 */
public class SuppressedExceptionDemoWithTryWithResource {

    /**
     * Demonstrating suppressed exceptions using try-with-resources
     */
    public static void main(String[] arguments) throws Exception {
        try (DirtyResource resource= new DirtyResource()) {
            resource.accessResource();
        }
    }

    /**
     * OUTPUT:
     * Exception in thread "main" java.lang.RuntimeException: I wanted to access this resource. Bad luck. Its dirty resource !!!
     * 	at cn.bravedawn.basic.exception.DirtyResource.accessResource(DirtyResource.java:15)
     * 	at cn.bravedawn.basic.exception.SuppressedExceptionDemoWithTryWithResource.main(SuppressedExceptionDemoWithTryWithResource.java:16)
     * 	Suppressed: java.lang.NullPointerException: Remember me. I am your worst nightmare !! I am Null pointer exception !!
     * 		at cn.bravedawn.basic.exception.DirtyResource.close(DirtyResource.java:24)
     * 		at cn.bravedawn.basic.exception.SuppressedExceptionDemoWithTryWithResource.main(SuppressedExceptionDemoWithTryWithResource.java:15)
     */
}
