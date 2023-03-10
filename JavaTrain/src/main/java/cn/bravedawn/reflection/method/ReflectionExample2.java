package cn.bravedawn.reflection.method;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ReflectionExample2 {

    /**
     * Method类的常用操作
     */

    public static void main(String[] args) throws NoSuchMethodException {
        Class stdClass = Student.class;

        Method m = stdClass.getMethod("getScore", String.class);

        String name = m.getName();
        System.out.println(name);

        Class returnType = m.getReturnType();
        System.out.println(returnType);

        Type genericReturnType = m.getGenericReturnType();
        System.out.println(genericReturnType);

        Class[] parameterTypes = m.getParameterTypes();
        System.out.println(Arrays.toString(parameterTypes));

        Type[] genericParameterTypes = m.getGenericParameterTypes();
        System.out.println(Arrays.toString(genericParameterTypes));

        int modifiers = m.getModifiers();
        System.out.println(Modifier.isPublic(modifiers));

    }
}
