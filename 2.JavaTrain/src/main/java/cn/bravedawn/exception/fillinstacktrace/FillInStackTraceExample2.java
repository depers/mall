package cn.bravedawn.exception.fillinstacktrace;

public class FillInStackTraceExample2 {

    // method calling exceptionThrownMethod()
    // and when method returns Exception
    // it is calling fillInStackTrace() method
    public void showResults() throws Throwable {
        try {
            exceptionThrownMethod();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e.fillInStackTrace(); // 清空原来的栈内的trace信息，在当前的调用位置处重新建立trace信息。
        }
    }

    // method throwing exception
    public void exceptionThrownMethod() throws Exception {
        throw new Exception("this is thrown from function1()");
    }


    public static void main(String[] args) {
        FillInStackTraceExample2 example2 = new FillInStackTraceExample2();
        try {
            example2.showResults();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
