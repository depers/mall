package cn.bravedawn.orm;

import cn.bravedawn.DBConnectionManager;
import cn.bravedawn.entity.Member;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : new-platform
 * @date : Created in 2023/2/10 21:02
 */
public class JpaDemo {


    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("emf", getProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Member user = new Member();
        user.setUsername("小马哥");
        user.setPassword("******");
        user.setEmail("mercyblitz@gmail.com");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();

        System.out.println(entityManager.find(Member.class, 1L));
    }

    private static Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.id.new_generator_mappings", false);
        properties.put("hibernate.connection.datasource", getDataSource());
        return properties;
    }

    private static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/jasper?user=root&password=fx1212&serverTimezone=Asia/Shanghai");
        return dataSource;
    }
}
