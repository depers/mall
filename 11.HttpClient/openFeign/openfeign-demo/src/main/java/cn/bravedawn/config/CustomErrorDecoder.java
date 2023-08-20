package cn.bravedawn.config;

import cn.bravedawn.exception.BadRequestException;
import cn.bravedawn.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * @author : depers
 * @program : openfeign-demo
 * @description:
 * @date : Created in 2022/12/6 19:16
 */
public class CustomErrorDecoder implements ErrorDecoder {

    /**
     * 自定义解码器
     */
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 400:
                return new BadRequestException();
            case 404:
                return new NotFoundException();
            default:
                return new Exception("Generic error");
        }
    }
}
