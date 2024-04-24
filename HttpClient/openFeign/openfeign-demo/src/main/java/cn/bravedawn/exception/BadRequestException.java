package cn.bravedawn.exception;

/**
 * @author : depers
 * @program : openfeign-demo
 * @description:
 * @date : Created in 2022/12/15 17:32
 */
public class BadRequestException extends Exception{

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "BadRequestException: "+getMessage();
    }


}
