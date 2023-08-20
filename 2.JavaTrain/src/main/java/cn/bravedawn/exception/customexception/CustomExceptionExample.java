package cn.bravedawn.exception.customexception;

public class CustomExceptionExample {


    public static void run() {
        throw new IllegalArgumentException("参数错误");
    }

    public static void main(String[] args) {
        Throwable th = null;
        try {
            run();
        } catch (Throwable e) {
            th = e;
        } finally {

            CustomRuntimeException exception = new CustomRuntimeException("出错了", new NullPointerException());
            exception.addSuppressed(th);
            throw exception;
        }
    }
}
