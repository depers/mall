package cn.bravedawn.config;

import cn.bravedawn.controller.interceptor.UserTokenInterceptor;
import cn.bravedawn.resource.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 冯晓
 * @Date 2020/3/14 17:03
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private FileUpload fileUpload;

    //将RestTemplate添加到包扫描中
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public UserTokenInterceptor userTokenInterceptor(){
        return new UserTokenInterceptor();
    }

    // 实现静态资源的映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //表示映射所有的资源
        registry.addResourceHandler("/**")
                // 映射swagger2，切记配置路径最后的/
                .addResourceLocations("classpath:/META-INF/resources/")
                // 映射本地资源路径，该路径下方文件就都可以访问，切记配置路径最后的/
                .addResourceLocations("file:" + fileUpload.getResourceLocations());
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userTokenInterceptor())
                .addPathPatterns("/hello")
                .addPathPatterns("/shopcart/add")
                .addPathPatterns("/shopcart/del")
                .addPathPatterns("/address/list")
                .addPathPatterns("/address/add")
                .addPathPatterns("/address/update")
                .addPathPatterns("/address/setDefault")
                .addPathPatterns("/orders/*")
                .addPathPatterns("/center/*")
                .addPathPatterns("/userInfo/*")
                .addPathPatterns("/myorders/*")
                .addPathPatterns("/mycomments/*")
                .addPathPatterns("/**")
                .excludePathPatterns("/myorders/deliver")
                .excludePathPatterns("/orders/notifyMerchantOrderPaid");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
