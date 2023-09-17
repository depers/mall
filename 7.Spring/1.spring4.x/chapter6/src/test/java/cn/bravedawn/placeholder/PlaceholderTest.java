package cn.bravedawn.placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.testng.Assert.assertNotNull;

/**
 * @author : depers
 * @description :
 * @program : 1.spring4.x
 * @date : Created in 2023/9/17 17:46
 */
public class PlaceholderTest {


    @Test
    public void testPropertyPlaceholderConfigurer() throws SQLException {
        String resourceFile = "classpath:cn/bravedawn/placeholder/bean1.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        DataSource ds = ctx.getBean(DataSource.class);
        Connection conn = ds.getConnection();
        assertNotNull(conn);
        System.out.println(ctx.getBean(MyDataSource1.class));
    }
}
