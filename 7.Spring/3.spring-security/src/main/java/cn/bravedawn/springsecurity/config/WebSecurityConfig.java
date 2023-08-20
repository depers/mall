package cn.bravedawn.springsecurity.config;

import cn.bravedawn.springsecurity.security.JwtAuthenticationProvider;
import cn.bravedawn.springsecurity.security.JwtAuthenticationTokenFilter;
import cn.bravedawn.springsecurity.security.MyAccessDeniedHandler;
import cn.bravedawn.springsecurity.security.MyUnauthorizedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
// 支持方法级别的授权
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Autowired
    private MyUnauthorizedHandler myUnauthorizedHandler;


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // 基于token验证，不做CSRF防护
        httpSecurity.csrf().disable()
                // 基于token验证，不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 允许对网站静态资源的访问
                .antMatchers(HttpMethod.GET, "/", "/*.html").permitAll()
                // 对登录允许匿名访问
                .antMatchers("/user/login").permitAll()
                // 跨域请求会先进行一次options请求
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                // 除上面配置的地址外，其余所有请求全部需要鉴权认证
                .anyRequest()
                .authenticated();

        // 禁用缓存
        httpSecurity.headers().cacheControl();

        // 使用自定义的provider
        httpSecurity.authenticationProvider(jwtAuthenticationProvider);

        // 添加Jwt filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler)
                .authenticationEntryPoint(myUnauthorizedHandler);

        return httpSecurity.build();
    }

}
