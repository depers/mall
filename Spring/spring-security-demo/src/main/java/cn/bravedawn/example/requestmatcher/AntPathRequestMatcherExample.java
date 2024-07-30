package cn.bravedawn.example.requestmatcher;

import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @author : depers
 * @program : 3.spring-security
 * @date : Created in 2024/5/21 15:42
 */
public class AntPathRequestMatcherExample {

    public static void main(String[] args) {
        // 创建 AntPathRequestMatcher 实例
        RequestMatcher antMatcher = new AntPathRequestMatcher("/user/{id:[0-9]*}", HttpMethod.GET.name());

        MockHttpServletRequest request = new MockHttpServletRequest();
        // request.setServletPath("/user/11231212");
        request.setServletPath("/user/hello");
        request.setMethod("GET");

        // 使用 matcher 进行匹配
        boolean isMatch = antMatcher.matches(request);
        System.out.println(isMatch);

        RequestMatcher matcher = new AntPathRequestMatcher("/user/**", "POST");
        MockHttpServletRequest request2 = new MockHttpServletRequest();
        request2.setServletPath("/user/1212_3abc");
        request2.setMethod("POST");

        boolean isMatch2 = matcher.matches(request2);
        System.out.println(isMatch2);

        MockHttpServletRequest request3 = new MockHttpServletRequest();
        request3.setServletPath("/user");
        request3.setMethod("POST");
        boolean isMatch3 = matcher.matches(request3);
        System.out.println(isMatch3);
    }
}
