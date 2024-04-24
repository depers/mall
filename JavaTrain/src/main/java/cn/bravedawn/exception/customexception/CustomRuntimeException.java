package cn.bravedawn.exception.customexception;

public class CustomRuntimeException extends RuntimeException{

    public CustomRuntimeException(String msg) {
        this(msg, false);
    }

    public CustomRuntimeException(String msg, boolean recordStackTrace) {
        super(msg, null, false, recordStackTrace);
    }


    public CustomRuntimeException(String msg, Throwable cause) {
        super(msg, cause, false, true);
    }


    public CustomRuntimeException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(msg, cause, enableSuppression, writableStackTrace);
    }
}
