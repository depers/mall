package cn.bravedawn.annotationexample;

import cn.bravedawn.annotationexample.Seller;
import cn.bravedawn.annotationexample.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 16:38
 */
public class DeclaredParentsTest {


    @Test
    public void config(){
        String configPath = "cn/bravedawn/annotationexample/introductioninterceptor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        waiter.greetTo("John");
        Seller seller = (Seller)waiter;
        seller.sell("Beer", "John");
    }

}
