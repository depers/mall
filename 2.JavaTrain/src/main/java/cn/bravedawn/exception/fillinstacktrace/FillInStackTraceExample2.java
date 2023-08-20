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
            throw e.fillInStackTrace();
        }
    }

    // method throwing exception
    public void exceptionThrownMethod() throws Exception {
        throw new Exception("this is thrown from function1()");
    }
}
