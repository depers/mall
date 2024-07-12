package cn.bravedawn.util;

import org.springframework.util.AntPathMatcher;

/**
 * @author : depers
 * @program : spring-mvc-demo
 * @date : Created in 2024/7/12 15:16
 *
 * URL匹配
 */
public class AntPathMatcherExample {


    public static void main(String[] args) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        final String pattern = "/core/**/list*";

        boolean flag = antPathMatcher.match(pattern, "/core/a/b/list");
        boolean flag2 = antPathMatcher.match(pattern, "/core/a/list?page=1");
        boolean flag3 = antPathMatcher.match(pattern, "/core/list");
        boolean flag4 = antPathMatcher.match(pattern, "core/list");
        boolean flag5 = antPathMatcher.match(pattern, "/mvc/a/list");

        System.out.println(flag);
        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag4);
        System.out.println(flag5);
    }
}
