package cn.bravedawn;

import cn.bravedawn.spring.MyDatasource;
import cn.bravedawn.spring.NumberGuess;
import cn.bravedawn.spring.SystemPropertyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PropertyTest {

    public ApplicationContext ctx = null;

    private static String[] CONFIG_FILES = { "beans.xml" };

    @BeforeClass
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext(CONFIG_FILES);

    }

    @Test
    public void testCustomerCarEditor(){
        SystemPropertyBean systemPropertyBean = (SystemPropertyBean) ctx.getBean("systemPropertyBean");
        System.out.println(systemPropertyBean);
    }

    @Test
    public void testNumberGuess() {
        NumberGuess numberGuess = (NumberGuess) ctx.getBean("numberGuess");
        System.out.println(numberGuess.getRandomNumber());
    }

    @Test
    public void testJdbcProperties() {
        MyDatasource myDatasource = (MyDatasource) ctx.getBean("myDatasource");
        System.out.println(myDatasource);
    }
}
