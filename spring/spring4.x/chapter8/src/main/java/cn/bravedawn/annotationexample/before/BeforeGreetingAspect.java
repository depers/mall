package cn.bravedawn.annotationexample.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 15:29
 */

@Aspect
public class BeforeGreetingAspect {

    /**
     * 使用@AspectJ实现前置增强
     */
    @Before("execution(* greetTo(..))")
    public void beforeGreeting(){
        System.out.println("How are you");
    }
}
