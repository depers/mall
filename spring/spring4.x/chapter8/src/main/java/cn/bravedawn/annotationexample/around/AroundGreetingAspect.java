package cn.bravedawn.annotationexample.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 17:08
 */

@Aspect
public class AroundGreetingAspect {


    @Around("execution(* greetTo(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取方法参数数组
        Object[] args = joinPoint.getArgs();
        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取方法参数类型数组
        Class[] parameterTypes = signature.getParameterTypes();
        // 这里可以写一些前置的操作....
        System.out.println("我做了一些前置的操作。。。");

        // 执行该方法
        Object result = joinPoint.proceed(args);

        // 这里可以写一些后置的操作...
        System.out.println("我做了一些后置的操作。。。");

        // 返回方法结果
        return result;
    }
}
