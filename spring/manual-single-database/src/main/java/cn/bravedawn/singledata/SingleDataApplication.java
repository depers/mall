package cn.bravedawn.singledata;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author : depers
 * @program : manual-single-database
 * @description: app
 * @date : Created in 2021/11/11 15:04
 */

@SpringBootApplication
public class SingleDataApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(SingleDataApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
