package cn.bravedawn.springsecurity.requestmatcher;

import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author : depers
 * @program : 3.spring-security
 * @date : Created in 2024/5/21 15:42
 */
public class AntPathRequestMatcherExample {

    public static void main(String[] args) {
        // 创建 AntPathRequestMatcher 实例
        RequestMatcher antMatcher = new AntPathRequestMatcher("/user/**");

        MockHttpServletRequest request = new MockHttpServletRequest();
        // request.setServletPath("/user/1");
        request.setServletPath("/user/{id}");
        request.setMethod("GET");

        // 使用 matcher 进行匹配
        boolean isMatch = antMatcher.matches(request);
        System.out.println(isMatch);
    }
}
