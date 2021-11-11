package cn.bravedawn.testdemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @author : depers
 * @program : manual-single-database
 * @description:
 * @date : Created in 2021/11/11 17:49
 */

@SpringBootTest
public class ValueBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    private Logger log = LoggerFactory.getLogger(ValueBeanTest.class);


    @Test
    public void testBeanValue() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ValueBean bean = (ValueBean) applicationContext.getBean("valueBean");
                log.info("bean=" + bean.getDbName());
            }
        });

        t.start();
    }

}
