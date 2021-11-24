package cn.bravedawn.singledata.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author : depers
 * @program : manual-single-database
 * @description: 数据库配置
 * @date : Created in 2021/11/11 15:44
 */

@Configuration
@MapperScan(value = "cn.bravedawn.singledata.dao", sqlSessionFactoryRef = "customFactory")
public class CustomDBConfig {


    @Autowired
    private Environment env;

    // 声明数据源
    @Bean
    public DataSource singleDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(env.getProperty("spring.datasource.single.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.single.password"));
        dataSource.setUrl(env.getProperty("spring.datasource.single.url"));
        return dataSource;
    }

    @Bean
    public SqlSessionFactory customFactory(@Qualifier("singleDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mybatis/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("singleDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
