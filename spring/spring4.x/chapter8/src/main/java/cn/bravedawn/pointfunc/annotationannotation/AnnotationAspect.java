package cn.bravedawn.pointfunc.annotationannotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/11 16:46
 */

@Aspect
public class AnnotationAspect {


    @Before("@annotation(cn.bravedawn.pointfunc.annotationannotation.Security)")
    public void before() {
        System.out.println("这里使用了@annotation切点函数编写了切面");
    }
}
