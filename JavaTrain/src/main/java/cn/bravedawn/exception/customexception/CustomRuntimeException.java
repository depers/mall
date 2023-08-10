package cn.bravedawn.exception.customexception;

public class CustomRuntimeException extends RuntimeException{

    public CustomRuntimeException(String msg) {
        super(msg);
    }


    public CustomRuntimeException(String msg, Throwable cause) {
        super(msg, cause, false, false);
    }
}
