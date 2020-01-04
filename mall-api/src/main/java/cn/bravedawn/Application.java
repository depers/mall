package cn.bravedawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author 冯晓
 * @Date 2019/12/26 20:12
 */
@SpringBootApplication
// 扫描mybatis通用mapper所在的包
@MapperScan("cn.bravedawn.mapper")
// 扫描所有包以及相关组件包
@ComponentScan(basePackages = {"cn.bravedawn", "org.n3r.idworker"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}