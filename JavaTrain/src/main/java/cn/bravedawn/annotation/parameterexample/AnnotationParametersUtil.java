package cn.bravedawn.annotation.parameterexample;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class AnnotationParametersUtil {


    public static void main(String[] args) throws NoSuchMethodException {

        // 获取Method实例:
        Method m = Controller.class.getMethod("queryOrder", String.class, long.class);


        Parameter[] parameters = m.getParameters();

        // 获取所有参数的Annotation:
        Annotation[][] annos = m.getParameterAnnotations();
        // 第一个参数（索引为0）的所有Annotation:
        Annotation[] annosOfName = annos[0];
        Parameter param = parameters[0];
        for (Annotation anno : annosOfName) {
            if (anno instanceof ParameterType) { // @ParameterType注解
                ParameterType p = (ParameterType) anno;
                System.out.println(param.getName() + ": " + p.type());
            }
            if (anno instanceof Operation) { // @Operation注解
                Operation o = (Operation) anno;
                System.out.println(param.getName() + ": " + o.value() + ", " + o.notes());
            }
        }


        // 第二个参数（索引为1）的所有Annotation:
        Annotation[] annosOfName2 = annos[1];
        Parameter param2 = parameters[1];
        for (Annotation anno : annosOfName2) {
            if (anno instanceof ParameterType) { // @ParameterType注解
                ParameterType p = (ParameterType) anno;
                System.out.println(param2.getName() + ": " + p.type());
            }
            if (anno instanceof Operation) { // @Operation注解
                Operation o = (Operation) anno;
                System.out.println(param2.getName() + ": " + o.value() + ", " + o.notes());
            }
        }

    }
}
