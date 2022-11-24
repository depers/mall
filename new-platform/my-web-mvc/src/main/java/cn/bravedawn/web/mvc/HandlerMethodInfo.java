package cn.bravedawn.web.mvc;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/11/23 11:36
 */
public class HandlerMethodInfo {

    /**
     * 处理方法信息类
     */

    private final String requestPath;

    private final Method handlerMethod;

    private final Set<String> supportedHttpMethods;

    public HandlerMethodInfo(String requestPath, Method handlerMethod, Set<String> supportedHttpMethods) {
        this.requestPath = requestPath;
        this.handlerMethod = handlerMethod;
        this.supportedHttpMethods = supportedHttpMethods;
    }


    public String getRequestPath() {
        return requestPath;
    }

    public Method getHandlerMethod() {
        return handlerMethod;
    }

    public Set<String> getSupportedHttpMethods() {
        return supportedHttpMethods;
    }
}
