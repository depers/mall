package cn.bravedawn.requestparam.filter;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : depers
 * @program : spring-mvc-demo
 * @date : Created in 2024/8/2 09:38
 */

@Order
@Component
@WebFilter(filterName = "printRequestContentFilter", urlPatterns = "/*")
@Slf4j
public class ReplayProtectionFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String httpMethod = request.getMethod();

        Map<String, ?> requestParams = new HashMap<>();
        String url = request.getRequestURI();

        switch (httpMethod) {
            case "GET", "DELETE": {
                // get:请求地址：/queryInfo, 请求参数：{"username":["冯晓,张三"],"age":[""],"gender":["男"]}
                // delete:请求地址：/deleteUser/1, 请求参数：{}
                requestParams = request.getParameterMap();
                break;
            }
            case "POST", "PUT": {
                // post:请求地址：/addUser, 请求参数：{"username":"冯晓","age":18,"gender":"男"}
                // put:请求地址：/updateUser, 请求参数：{"username":"冯晓","age":18,"gender":"男"}
                if (request.getContentType().startsWith(MediaType.APPLICATION_JSON_VALUE)) {
                    String body = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
                    requestParams = JSONUtil.parseObj(body);
                } else if (request.getContentType().startsWith(MediaType.MULTIPART_FORM_DATA_VALUE)) {
                    String fileContent = Base64Encoder.encodeStr(request.getInputStream().readAllBytes(), false, true);
                    Map<String, String> map = new HashMap<>();
                    map.put("file", fileContent);
                    requestParams = JSONUtil.parseObj(map);
                } else {
                    log.error("无法识别的请求类型");
                }
                break;
            }
        }

        log.info("请求地址：{}, 请求参数：{}", url, JSONUtil.toJsonStr(requestParams));
        filterChain.doFilter(request, response);
    }
}
