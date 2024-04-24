package cn.bravedawn.exception.fillinstacktrace;

public class FillInStackTraceExample {

    /**
     * fillInStackTrace每次执行的时候，会清空原来的栈内的trace信息。然后在当前的调用位置处重新建立trace信息。
     * 如果Throwable的堆栈跟踪不可写，则调用该方法无效。
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
