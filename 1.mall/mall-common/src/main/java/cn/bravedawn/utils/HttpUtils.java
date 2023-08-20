package cn.bravedawn.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : depers
 * @program : mall
 * @description: Http请求工具
 * @date : Created in 2021/10/10 11:04
 */
public class HttpUtils {

    /**
     * Get value of header from httpRequest.
     * @param headerName
     * @return
     */
    public static String getHttpHeaderValue(String headerName) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if (request == null) {
            throw new IllegalArgumentException("http request is null.");
        }
        return request.getHeader(headerName);
    }
}
