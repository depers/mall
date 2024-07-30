package cn.bravedawn.annotationexample.afterreturning;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 17:28
 */

@Aspect
public class AfterReturningGreetingAspect {


    @AfterReturning("execution(* greetTo(..))")
    public void afterReturning() {
        System.out.println("招呼打完了");
    }
}
