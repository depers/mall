package cn.bravedawn.exception.fillinstacktrace;

public class FillInStackTraceExample3 {


    /**
     * fillInStackTrace的返回值是一个Throwable对象实例
     */



    public void method() {
        throw new RuntimeException("method()方法处错了");
    }

    public static void main(String[] args) {

        FillInStackTraceExample3 example = new FillInStackTraceExample3();
        try {
            example.method();
        } catch (Throwable e) {
            e.printStackTrace();
            System.err.println("------------------------------");
            Throwable t = e.fillInStackTrace();
            t.printStackTrace();
        }
    }
}
