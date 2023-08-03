package cn.bravedawn.exception.throwexception;

public class ThrowException3 {

    /**
     * 为了避免finally吃掉屏蔽异常，需要手动调用addSuppressed()方法添加屏蔽异常到堆栈中
     */

    public static void main(String[] args) throws Exception {
        Exception origin = null;

        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println("catched");
            origin = e;
        } finally {
            System.out.println("finally");
            Exception e = new IllegalArgumentException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }
    }

    /**
     * 打印输出：
     *
     * catched
     * finally
     * Exception in thread "main" java.lang.IllegalArgumentException
     * 	at cn.bravedawn.exception.throwexception.ThrowException3.main(ThrowException3.java:21)
     * 	Suppressed: java.lang.NumberFormatException: For input string: "abc"
     * 		at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
     * 		at java.base/java.lang.Integer.parseInt(Integer.java:668)
     * 		at java.base/java.lang.Integer.parseInt(Integer.java:786)
     * 		at cn.bravedawn.exception.throwexception.ThrowException3.main(ThrowException3.java:15)
     */
}
