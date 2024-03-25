package cn.bravedawn.jndi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

import javax.naming.*;
import javax.sql.DataSource;
import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author : depers
 * @program : mall
 * @description: JndiUnitTest
 * @date : Created in 2021/12/4 16:38
 */
public class JndiUnitTest {

    /**
     * 教程网站：https://www.baeldung.com/jndi
     */

    private static InitialContext ctx;
    private static DriverManagerDataSource ds;

    @BeforeAll
    static void setUp() throws NamingException {
        SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
        ds = new DriverManagerDataSource("jdbc:h2:mem:mydb");
        builder.activate();

        JndiTemplate jndiTemplate = new JndiTemplate();
        ctx = (InitialContext) jndiTemplate.getContext();
    }


    /**
     * Name Interface
     * @throws InvalidNameException
     */
    @Test
    void giveACompositeName_whenAddingAnElement_thenNameIncludeIt() throws InvalidNameException {
        Name objectName = new CompositeName("java:comp/env/jdbc");

        Enumeration<String> elements = objectName.getAll();
        while(elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }

        // /是名称子上下文的分隔符。现在，让我们添加一个子上下文：
        objectName.add("example");

        assertEquals("env", objectName.get(1));
        assertEquals("example", objectName.get(objectName.size() - 1));
    }

    @Test
    void givenADataSource_whenAddingDriver_thenBind() throws Exception {
        ds.setDriverClassName("org.h2.Driver");
        ctx.bind("java:comp/env/jdbc/datasource", ds);
    }

    /**
     * 查找JNDI对象
     */
    @Test
    void givenContext_whenLookupByName_thenValidDataSource() throws Exception {
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");

        assertNotNull(ds);
        assertNotNull(ds.getConnection());
    }

    @AfterAll
    static void tearDown() throws Exception {
        ctx.close();
    }


}
