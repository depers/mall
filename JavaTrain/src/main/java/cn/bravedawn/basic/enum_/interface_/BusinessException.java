package cn.bravedawn.basic.enum_.interface_;

public class BusinessException extends RuntimeException{


    public BusinessException(BaseEnum baseEnum) {
        super(baseEnum.getCode() + ":" + baseEnum.getMsg());
    }
}
