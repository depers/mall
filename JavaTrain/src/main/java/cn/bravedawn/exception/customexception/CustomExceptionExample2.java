package cn.bravedawn.exception.customexception;

public class CustomExceptionExample2 {

    /**
     * 自定义异常：测试构造函数中writableStackTrace值，建议设置为true。
     */


    public void run() {
        throw new IllegalArgumentException("参数错误");
    }


    public void method() {
        try {
            run();
        } catch (Throwable e) {
            CustomRuntimeException exception = new CustomRuntimeException("出错了", null, false, false);
            throw exception;
        }
    }

    public void method2() throws Exception {
        try {
            run();
        } catch (Throwable e) {
            CustomRuntimeException exception = new CustomRuntimeException("出错了", null, false, true);
            throw exception;
        }
    }

    public static void main(String[] args) {
        CustomExceptionExample2 example = new CustomExceptionExample2();
        try {
            example.method();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.err.println("---------------------------");
        try {
            example.method2();
        } catch (Throwable e) {
            e.printStackTrace();
        }



    }

}
