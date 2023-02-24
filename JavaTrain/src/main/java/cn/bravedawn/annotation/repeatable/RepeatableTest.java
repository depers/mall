package cn.bravedawn.annotation.repeatable;

import java.lang.reflect.Method;

public class RepeatableTest {


    @RepeatAnnotation
    @RepeatAnnotation
    public void method(String s) {

    }

    public static void main(String[] args) throws Exception{
        Method method = RepeatableTest.class.getDeclaredMethod("method", String.class);
        RepeatAnnotation an = method.getAnnotation(RepeatAnnotation.class);
        System.out.println(an);
        System.out.println("****************************************");
        RepeatAnnotations ans = method.getAnnotation(RepeatAnnotations.class);
        System.out.println(ans);
        System.out.println("****************************************");
        RepeatAnnotation[] anArr = method.getAnnotationsByType(RepeatAnnotation.class);
        System.out.println(anArr);

    }
}
