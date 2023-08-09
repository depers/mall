package cn.bravedawn.exception.customexception;

public class CustomRuntimeException extends RuntimeException{

    public CustomRuntimeException(String msg) {
        super(msg);
    }


    public CustomRuntimeException(String msg, Throwable cause, boolean suppressed, boolean writable) {
        // 第三个参数enableSuppression设置为false，表示关闭抑制异常。建议设置为true。
        // 第四个参数writableStackTrace设置为false，表示在调用异常的构造函数时会主动打印出错的位置。建议设置为true。
        super(msg, cause, suppressed, writable);
    }
}
