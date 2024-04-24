package cn.bravedawn.exception;

import cn.bravedawn.enums.ExceptionEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : depers
 * @program : mall
 * @description: 基础异常
 * @date : Created in 2021/10/10 7:57
 */
public class BaseException extends Exception{


    private ExceptionEnum exceptionEnum;


    public BaseException(ExceptionEnum exceptionEnum) {
        this(StringUtils.join(exceptionEnum.getCode(), "-", exceptionEnum.getMessage()), false);
        this.exceptionEnum = exceptionEnum;
    }

    /**
     * 打印异常堆栈，禁用抑制异常
     * @param exceptionEnum
     * @param cause
     */
    public BaseException(ExceptionEnum exceptionEnum, Throwable cause) {
        super(StringUtils.join(exceptionEnum.getCode(), "-", exceptionEnum.getMessage()), cause, false, true);
        this.exceptionEnum = exceptionEnum;
    }

    /**
     * @param message
     * @param recordStackTrace 是否需要记录异常堆栈
     */
    public BaseException(String message, boolean recordStackTrace) {
        super(message, null, false, recordStackTrace);
    }
}
