package cn.bravedawn.reflection.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

/**
 * @author : depers
 * @program : mybatis
 * @description: ParameterizedType示例
 * @date : Created in 2021/3/30 8:58
 */
public class ParameterizedTypeExample <K, V>{


    private Map<K, V> map;

    private Map.Entry<String, String> entry;

    public Map<K, V> getMap(){
        return map;
    }


    /**
     * 实现了泛型类的子类
     */
    static class ParameterizedTypeExample2 extends ParameterizedTypeExample<String, Student> {

        @Override
        public Map<String, Student> getMap() {
            return super.getMap();
        }
    }




    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        testMethod(new ParameterizedTypeExample());
        System.out.println("-------------------------------");
        testMethod(new ParameterizedTypeExample2());
        System.out.println("-------------------------------");
        testField("entry");
    }


    static void testMethod(ParameterizedTypeExample parameterizedTypeExample) throws NoSuchMethodException {
        Type type = parameterizedTypeExample.getClass().getMethod("getMap").getGenericReturnType();

        System.out.println(type instanceof ParameterizedType);
        ParameterizedType parameterizedType = (ParameterizedType) type;

        // 获得参数化类型中<>里面的类型参数的类型
        Arrays.stream(parameterizedType.getActualTypeArguments()).forEach(t -> {
            System.out.print(t + "; ");
        });
        System.out.println();
        // 返回最外层<>前面那个类型，例如Map<K ,V>，针对K或V来说，返回的就是Map类型
        System.out.println(parameterizedType.getRawType());

        // 如果当前类型为顶层类型，则返回null（通常情况是这样），例如：Map.Entry中的Entry返回的就是Map，A.B.C中的C返回的就是A$B
        System.out.println(parameterizedType.getOwnerType());
    }

    private static void testField(String fieldName) throws NoSuchFieldException {
        Field f = ParameterizedTypeExample.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        System.out.println(f.getGenericType());
        boolean b = f.getGenericType() instanceof ParameterizedType;
        System.out.println(b);
        if(b){
            ParameterizedType pType = (ParameterizedType) f.getGenericType();
            System.out.println(pType.getRawType());
            for (Type type : pType.getActualTypeArguments()) {
                System.out.print(type + "; ");
            }
            System.out.println();
            System.out.println(pType.getOwnerType());
        }
    }


    static class Student{}

}
