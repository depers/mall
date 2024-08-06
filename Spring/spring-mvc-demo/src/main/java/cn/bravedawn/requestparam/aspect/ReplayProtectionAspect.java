package cn.bravedawn.requestparam.aspect;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author : depers
 * @program : spring-mvc-demo
 * @date : Created in 2024/7/31 17:18
 */

@Aspect
// @Component
@Slf4j
public class ReplayProtectionAspect {

    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
                        "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
                        "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
                        "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("请求的参数：{}", JSONUtil.toJsonStr(request.getParameterMap()));
        log.info("请求url的参数：{}", request.getQueryString());


        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.info("请求参数：{}", args[i]);
        }
    }
}
