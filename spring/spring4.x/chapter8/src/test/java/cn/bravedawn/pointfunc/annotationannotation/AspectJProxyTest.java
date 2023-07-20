package cn.bravedawn.pointfunc.annotationannotation;

import cn.bravedawn.pointfunc.args.*;
import cn.bravedawn.pointfunc.argsannotation.ArgsAnnotationAspect;
import cn.bravedawn.pointfunc.argsannotation.ArgsAnnotationController;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.Test;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/11 16:49
 */
public class AspectJProxyTest {

    @Test
    public void beforeProxy(){
        Controller target = new Controller();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 设置目标类
        factory.setTarget(target);
        // 设置切面类
        factory.addAspect(AnnotationAspect.class);
        // 生成织入切面的代理对象
        Controller proxy = factory.getProxy();
        proxy.handle(1, 2);
    }


    @Test
    public void beforeProxyForArgs(){
        CarGame target = new CarGame();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 设置目标类
        factory.setTarget(target);
        // 设置切面类
        factory.addAspect(ArgsAspect.class);
        // 生成织入切面的代理对象
        CarGame proxy = factory.getProxy();
        Car car = new Car();
        proxy.run(car);

        Car car2 = new Bus();
        proxy.run(car2);

        Car car3 = new Train();
        proxy.run(car3);
    }

    @Test
    public void beforeProxyForArgsAnnotation() {
        ArgsAnnotationController target = new ArgsAnnotationController();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 设置目标类
        factory.setTarget(target);
        // 设置切面类
        factory.addAspect(ArgsAnnotationAspect.class);
        // 生成织入切面的代理对象
        ArgsAnnotationController proxy = factory.getProxy();
        proxy.getStr(1);
    }
}
