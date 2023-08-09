package cn.bravedawn.exception.fillinstacktrace;

public class FillInStackTraceExample {


    /**
     * fillInStackTrace()方法是用来填充当前线程栈帧（当前方法的）的异常信息的，
     * 也就是说他只包含错误信息和调用该方法位置处的堆栈信息
     *
     * fillInStackTrace()方法只包含错误信息和调用该方法位置处的堆栈信息
     */


    public void divide() {
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            throw e;
        }
    }


    public void method() {
        divide();
    }


    public static void main(String[] args) {
        FillInStackTraceExample example = new FillInStackTraceExample();

        try {
            example.method();
        } catch (Exception e) {

            System.err.println("Exception details without fillInStackTrace()\n");
            System.err.println("Caught Inside Main");
            e.printStackTrace();


            System.err.println("Exception details with fillInStackTrace()\n");
            System.err.println("Caught Inside Main");
            e.fillInStackTrace();
            e.printStackTrace();
        }
    }
}
