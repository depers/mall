package cn.bravedawn.exception.fillinstacktrace;

public class FillInStackTraceExceptionExample {

    /**
     * 如果在构造函数的时候将第四个参数设置为true，在调用父类构造函数的时候调用fillInStackTrace()会主动打印出错的位置，
     * 所以构造函数中建议将writableStackTrace的值设置为true。
     */


    public static void main(String[] args) {
        FillInStackTraceException exception = new FillInStackTraceException("在这里出错了", null, true);
        exception.printStackTrace();

        System.err.println("----------------------");
        FillInStackTraceException exception2 = new FillInStackTraceException("在这里出错了", null, false);
        exception2.printStackTrace();
    }
}
