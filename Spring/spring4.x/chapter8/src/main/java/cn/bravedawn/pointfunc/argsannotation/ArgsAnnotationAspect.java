package cn.bravedawn.pointfunc.argsannotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/13 17:37
 */

@Aspect
public class ArgsAnnotationAspect {


    @Before("@args(cn.bravedawn.pointfunc.argsannotation.Param)")
    public void handle() {
        System.out.println("测试切点函数@args()");
    }
}
