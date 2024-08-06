package cn.bravedawn.requestparam.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author : depers
 * @program : spring-mvc-demo
 * @date : Created in 2024/8/2 09:47
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "ContentCachingFilter", urlPatterns = "/*")
@Slf4j
public class ContentCachingFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("IN  ContentCachingFilter ");
        CachedBodyHttpServletRequest cachedBodyHttpServletRequest = null;
        try {
            cachedBodyHttpServletRequest = new CachedBodyHttpServletRequest(request);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(cachedBodyHttpServletRequest, response);
    }
}
