package cn.bravedawn.config;

import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.apache.http.entity.ContentType;
import org.springframework.context.annotation.Bean;

/**
 * @author : depers
 * @program : openfeign-demo
 * @description:
 * @date : Created in 2022/12/5 12:10
 */
public class ClientConfiguration {


    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }


    /**
     * 设置Http客户端
     */
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }


    /**
     * 添加拦截器
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user", "ajeje");
            requestTemplate.header("password", "brazof");
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }

    /**
     * 使用这个拦截器Bean配置，与 requestInterceptor Bean配置效果一致，都是在请求头中添加user和password配置
     * @return
     */
    // @Bean - uncomment to use this interceptor and remove @Bean from the requestInterceptor()
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("ajeje", "brazof");
    }

}
