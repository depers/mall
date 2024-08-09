package cn.bravedawn.timeout.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

/**
 * @author : depers
 * @program : spring-tx-demo
 * @date : Created in 2024/8/8 16:40
 */

@Configuration
@MapperScan(basePackages = "cn.bravedawn.timeout.dao")
public class DatasourceConfig {


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addInterceptor(new SqlCostInterceptor());
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DefaultTransactionDefinition datasourceTransactionDefinition() {
        DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
        dtd.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        dtd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        dtd.setTimeout(10000);
        return dtd;
    }
}
