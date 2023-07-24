package cn.bravedawn.beanreplace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : depers
 * @program : chapter4
 * @description:
 * @date : Created in 2023/7/24 15:44
 */
public class BeanLifeCycle {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("product-beans.xml");
        ProductService productService = (ProductService) applicationContext.getBean("product");
        productService.getInfo();
    }
}
