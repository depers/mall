package cn.bravedawn.singledata.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author : depers
 * @program : manual-single-database
 * @description: 数据库配置
 * @date : Created in 2021/11/11 15:44
 */

@Configuration
@MapperScan(value = "cn.bravedawn.singledata.dao", sqlSessionFactoryRef = "customFactory")
public class CustomDBConfig {


    // 声明数据源
    @Bean
    @ConfigurationProperties("spring.datasource.single")
    public DataSource singleDataSource() {
        return new MysqlDataSource();
    }

    @Bean
    public SqlSessionFactoryBean customFactory(@Qualifier("singleDataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mybatis/mapper/*.xml"));
        return bean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("singleDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
