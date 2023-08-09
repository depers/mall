package cn.bravedawn.exception.fillinstacktrace;

public class FillInStackTraceException extends RuntimeException{

    /**
     * 测试writableStackTrace参数
     */


    protected FillInStackTraceException(String message, Throwable cause, boolean writableStackTrace) {
        super(message, cause, true, writableStackTrace);
    }
}
