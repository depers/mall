package cn.bravedawn.exception.fillinstacktrace;

public class FillInStackTraceExample2 {


    /**
     * fillInStackTrace()方法只包含错误信息和调用该方法位置处的堆栈信息
     */

    // method calling exceptionThrownMethod()
    // and when method returns Exception
    // it is calling fillInStackTrace() method
    public void showResults() throws Throwable {
        try {
            exceptionThrownMethod();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e.fillInStackTrace();
        }
    }

    // method throwing exception
    public void exceptionThrownMethod() throws Exception {
        throw new Exception("this is thrown from function1()");
    }


    public static void main(String[] args) {
        FillInStackTraceExample2 example = new FillInStackTraceExample2();
        try {
            example.showResults();
        } catch (Throwable e) {
            System.err.println("-----------------------------------------");
            e.printStackTrace();
        }
    }
}
