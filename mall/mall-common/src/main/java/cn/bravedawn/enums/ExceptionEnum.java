package cn.bravedawn.enums;

/**
 * @author : depers
 * @program : mall
 * @description: 异常枚举
 * @date : Created in 2021/10/10 7:58
 */
public enum ExceptionEnum {

    /**
     * 错误码定义
     * 第一位：1-业务异常，0-程序异常
     * 第二至五位：为错误码
     */

    // 业务异常
    IDEMPOTENT_EXCEPTION("10001", "错误，触发幂等性校验", "服务正忙，请稍后"),
    ;

    // 程序异常


    private String code;

    private String message;

    private String userMessage;


    ExceptionEnum(String code, String message, String userMessage) {
        this.code = code;
        this.message = message;
        this.userMessage = userMessage;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
