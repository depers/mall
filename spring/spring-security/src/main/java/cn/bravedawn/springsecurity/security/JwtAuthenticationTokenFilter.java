package cn.bravedawn.springsecurity.security;

import cn.bravedawn.springsecurity.constant.MyConstant;
import cn.hutool.jwt.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


/**
 * JwtAuthenticationTokenFilter继承 OncePerRequestFilter，其会拦截http请求，然后检查其header: Authorization携带的 jwt。
 * 如果通过了就从jwt中获取用户名，然后到数据库（或者redis）里查询用户信息，然后生成验证通过的UsernamePasswordAuthenticationToken 。
 * 一定要注意这次使用的是3个参数的构造函数，其将认证状态设置为了true。
 */

@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;


    private final static String AUTH_HEADER = "Authorization";
    private final static String AUTH_HEADER_TYPE = "Bearer";



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(AUTH_HEADER);
        if (Objects.isNull(authHeader) || !authHeader.startsWith(AUTH_HEADER_TYPE)) {
            filterChain.doFilter(request, response);
            return;
        }

        String authToken = authHeader.split(" ")[1];
        log.info("authToken={}.", authToken);

        // 校验jwt的token
        if (!JWTUtil.verify(authToken, MyConstant.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))) {
            log.error("invalid token");
            filterChain.doFilter(request, response);
            return;
        }

        final String username = (String) JWTUtil.parseToken(authToken).getPayload("username");
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // 注意，这里使用的是3个参数的构造方法，此构造方法将认证状态设置为true
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        // 将认证过了凭证保存到security的上下文中以便于在程序中使用
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
