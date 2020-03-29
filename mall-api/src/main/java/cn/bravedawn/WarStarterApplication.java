package cn.bravedawn;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author 冯晓
 * @Date 2020/3/29 22:25
 */
public class WarStarterApplication extends SpringBootServletInitializer {

    /**
     * 打包war[4] 设置war包的启动类
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 指向Application这个springboot启动类
        return builder.sources(Application.class);
    }
}
