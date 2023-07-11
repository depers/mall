package cn.bravedawn.annotationexample.afterthrowing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/11 16:11
 */

@Aspect
public class AfterThrowingGreetingAspect {

    /**
     * 使用@AspectJ实现抛出增强，只有报错了才会打印这个
     */

    @AfterThrowing(pointcut = "execution(* greetThrowException(..))", throwing = "ex")
    public void afterThrowingGreeting(JoinPoint joinPoint, Throwable ex){
        System.out.println("执行方法抛出了异常");
        System.out.println("报错信息是：" + ex.getMessage());
        System.out.println(joinPoint.getSignature());
    }
}
