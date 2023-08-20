package cn.bravedawn.exception.suppressedexception;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: Default try-with-resource block
 * @date : Created in 2021/10/10 9:54
 */
public class SuppressedExceptionDemoWithTryWithResource {

    /**
     * try-with-resources会将完整的异常堆栈打印出来，包含屏蔽异常
     */

    public static void main(String[] arguments) throws Exception {
        try (DirtyResource resource = new DirtyResource()) {
            resource.accessResource();
        }
    }


    /**
     * OUTPUT:
     *
     * Exception in thread "main" java.lang.RuntimeException: 我想访问这个资源，不幸的是他是脏数据！！！
     * 	at cn.bravedawn.exception.suppressedexception.DirtyResource.accessResource(DirtyResource.java:16)
     * 	at cn.bravedawn.exception.suppressedexception.SuppressedExceptionDemoWithTryWithResource.main(SuppressedExceptionDemoWithTryWithResource.java:16)
     * 	Suppressed: java.lang.NullPointerException: 关闭资源的时候，会抛出空指针!!
     * 		at cn.bravedawn.exception.suppressedexception.DirtyResource.close(DirtyResource.java:26)
     * 		at cn.bravedawn.exception.suppressedexception.SuppressedExceptionDemoWithTryWithResource.main(SuppressedExceptionDemoWithTryWithResource.java:15)
     */
}
