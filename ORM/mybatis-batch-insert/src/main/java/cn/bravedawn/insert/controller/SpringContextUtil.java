package cn.bravedawn.insert.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : jasper
 * @description:
 * @date : Created in 2023/4/5 22:15
 */

@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    private static void assertContextInjected() {
        if (applicationContext == null) {
            throw new IllegalStateException("SpringContext未注入");
        }
    }


    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象
     *
     * @param name
     * @return Object
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        assertContextInjected();
        return applicationContext.getBean(name);
    }

    /**
     * 通过class对象获取Bean
     *
     * @param cls
     * @return
     * @throws BeansException
     */
    public static Object getBean(Class cls) throws BeansException {
        assertContextInjected();
        return applicationContext.getBean(cls);
    }
}
