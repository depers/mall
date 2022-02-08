package cn.bravedawn.exception.throwexception;

public class ThrowException2 {

    /**
     * 屏蔽异常
     * 在下面这段代码中catch中抛出的异常并没有被抛出来，原因是因为他被finally中的异常给吃了，这种被吃了的异常称为：被屏蔽的异常
     */

    public static void main(String[] args) {
        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println("catched");
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
            throw new IllegalArgumentException();
        }
    }
}
