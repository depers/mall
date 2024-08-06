package cn.bravedawn.mdc2.interceptor;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.google.common.collect.Maps;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
import java.util.UUID;

/**
 * @author : depers
 * @program : log4j2-demo
 * @date : Created in 2024/8/6 20:05
 */

@Component
@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor {


    /**
     * 实现 TransmittableThreadLocal 的 initialValue,beforeExecute,afterExecute接口
     */
    static TransmittableThreadLocal<Map<String, String>> ttlMDC = new TransmittableThreadLocal<>() {
        /**
         * 在多线程数据传递的时候，将数据复制一份给MDC
         */
        @Override
        protected void beforeExecute() {
            final Map<String, String> mdc = get();
            mdc.forEach(MDC::put);
        }

        @Override
        protected void afterExecute() {
            MDC.clear();
            ttlMDC.get().clear();
        }

        @Override
        protected Map<String, String> initialValue() {
            return Maps.newHashMap();
        }
    };


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //MDC记录traceId
        String traceId = UUID.randomUUID().toString().replaceAll("-", "");
        MDC.put("traceId", traceId);

        //同时给TransmittableThreadLocal记录traceId
        ttlMDC.get().put("traceId", traceId);
        log.info("请求开始执行，traceId:{}, map={}", traceId, ttlMDC.get());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        log.info("请求结束执行，traceId:{}, map={}", MDC.get("traceId"), ttlMDC.get());
        //清除数据
        MDC.clear();
        ttlMDC.remove();
    }
}
