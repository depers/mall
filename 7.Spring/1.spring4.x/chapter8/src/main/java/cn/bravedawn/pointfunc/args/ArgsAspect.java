package cn.bravedawn.pointfunc.args;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/11 17:27
 */

@Aspect
public class ArgsAspect {


    @Before("args(cn.bravedawn.pointfunc.args.Car)")
    public void handle() {
        System.out.println("这里使用了args()切点函数编写了切面");
    }
}
