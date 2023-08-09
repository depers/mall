package cn.bravedawn.exception.customexception;

public class CustomExceptionExample {


    /**
     * 自定义异常，抑制异常开关的实验
     */


    public void run() {
        throw new IllegalArgumentException("参数错误");
    }


    public void method() {
        Throwable th = null;
        try {
            run();
        } catch (Throwable e) {
            th = e;
        } finally {
            CustomRuntimeException exception = new CustomRuntimeException("出错了", new NullPointerException(), false, false);
            exception.addSuppressed(th);
            throw exception;
        }
    }

    public void method2() {
        Throwable th = null;
        try {
            run();
        } catch (Throwable e) {
            th = e;
        } finally {
            CustomRuntimeException exception = new CustomRuntimeException("出错了", new NullPointerException(), true, false);
            exception.addSuppressed(th);
            throw exception;
        }
    }

    public static void main(String[] args) {
        // 关闭了抑制异常开关
        CustomExceptionExample example = new CustomExceptionExample();
        try {
            example.method();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.err.println("---------------------------------------");
        // 开启了抑制异常开关
        CustomExceptionExample example2 = new CustomExceptionExample();
        try {
            example2.method2();
        } catch (Throwable e) {
            e.printStackTrace();
        }


    }
}
