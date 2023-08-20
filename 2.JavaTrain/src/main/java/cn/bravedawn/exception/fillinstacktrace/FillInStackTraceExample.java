package cn.bravedawn.exception.fillinstacktrace;

public class FillInStackTraceExample {


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
