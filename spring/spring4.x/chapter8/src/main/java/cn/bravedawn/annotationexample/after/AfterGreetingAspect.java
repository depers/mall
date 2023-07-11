package cn.bravedawn.annotationexample.after;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 16:05
 */

@Aspect
public class AfterGreetingAspect {


    /**
     * 使用@AspectJ实现Final增强，不管抛出异常还是正常退出，该增强都会得到执行。
     */
    @After("execution(* greetThrowException(..))")
    public void afterGreeting(){
        System.out.println("报错了，招呼打完了");
    }
}
