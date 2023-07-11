package cn.bravedawn.annotationexample;

import cn.bravedawn.annotationexample.NaiveWaiter;
import cn.bravedawn.annotationexample.after.AfterGreetingAspect;
import cn.bravedawn.annotationexample.afterreturning.AfterReturningGreetingAspect;
import cn.bravedawn.annotationexample.afterthrowing.AfterThrowingGreetingAspect;
import cn.bravedawn.annotationexample.around.AroundGreetingAspect;
import cn.bravedawn.annotationexample.before.BeforeGreetingAspect;
import cn.bravedawn.annotationexample.Waiter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.Test;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 15:37
 */
public class AspectJProxyTest {

    @Test
    public void beforeProxy(){
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 设置目标类
        factory.setTarget(target);
        // 设置切面类
        factory.addAspect(BeforeGreetingAspect.class);
        // 生成织入切面的代理对象
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
    }

    @Test
    public void afterProxy(){
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 设置目标类
        factory.setTarget(target);
        // 设置切面类
        factory.addAspect(AfterGreetingAspect.class);
        // 生成织入切面的代理对象
        Waiter proxy = factory.getProxy();
        proxy.greetThrowException("John");
        proxy.serveTo("John");
    }


    @Test
    public void aroundProxy() {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 设置目标类
        factory.setTarget(target);
        // 设置切面类
        factory.addAspect(AroundGreetingAspect.class);
        // 生成织入切面的代理对象
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
    }


    @Test
    public void afterReturningProxy() {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 设置目标类
        factory.setTarget(target);
        // 设置切面类
        factory.addAspect(AfterReturningGreetingAspect.class);
        // 生成织入切面的代理对象
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
    }


    @Test
    public void afterThrowingProxy() {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 设置目标类
        factory.setTarget(target);
        // 设置切面类
        factory.addAspect(AfterThrowingGreetingAspect.class);
        // 生成织入切面的代理对象
        Waiter proxy = factory.getProxy();
        proxy.greetThrowException("John");
    }
}
