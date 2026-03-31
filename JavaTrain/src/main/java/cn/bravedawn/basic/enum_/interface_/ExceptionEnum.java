package cn.bravedawn.basic.enum_.interface_;

public enum ExceptionEnum implements BaseEnum{


    PARAMS_ERROR("0001", "请求参数错误"),
    NETWORK_TIMEOUT_ERROR("0002", "网络超时"),
    ;

    private String code;
    private String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
