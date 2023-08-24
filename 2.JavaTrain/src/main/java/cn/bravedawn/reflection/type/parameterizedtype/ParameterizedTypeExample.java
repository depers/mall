package cn.bravedawn.reflection.type.parameterizedtype;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParameterizedTypeExample<K, V> {


    /**
     * ParameterizedType 参数化类型的关键方法
     * 1.getActualTypeArguments()：获取<>中的类型定义
     * 2.getRawType()：获取<>前面的类型
     * 3.getOwnerType()：获取当前类型的上一层类型，若当前类型为顶层类型，则返回null
     */


    private Map<K, V> map;

    private Map.Entry<String, String> entry;

    public Map<K, V> getMap(Map<K, V> map){
        return map;
    }


    /**
     * 实现了泛型类的子类
     */
    static class ParameterizedTypeExample2 extends ParameterizedTypeExample<String, Student> {

        @Override
        public Map<String, Student> getMap(Map<String, Student> map) {
            return super.getMap(map);
        }
    }




    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        testMethod(new ParameterizedTypeExample());
        System.out.println("-------------------------------");
        testMethod(new ParameterizedTypeExample2());
        System.out.println("-------------------------------");
        testField("entry");
        System.out.println("-------------------------------");
        testClass(new ParameterizedTypeExample());
        System.out.println("-------------------------------");
        testClass(new ParameterizedTypeExample2());
    }


    static void testClass(ParameterizedTypeExample parameterizedTypeExample) {
        // 获取该类父类的类型
        Type type = parameterizedTypeExample.getClass().getGenericSuperclass();
        System.out.println("父类的类型：" + type);

        // 获取父类类型参数的真实类型
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType)type).getActualTypeArguments();
            System.out.println("父类参数化类型的真实参数：" + Arrays.toString(types));
        }

    }


    /**
     * 测试方法
     * @param parameterizedTypeExample
     * @throws NoSuchMethodException
     */
    static void testMethod(ParameterizedTypeExample parameterizedTypeExample) throws NoSuchMethodException {
        // 从方法返回参数
        Type type = parameterizedTypeExample.getClass().getMethod("getMap").getGenericReturnType();
        // 从方法形参中
        Type[] parameterTypes = parameterizedTypeExample.getClass().getMethod("getMap").getGenericParameterTypes();

        System.out.println("从方法形参中获取参数类型：" + Arrays.toString(parameterTypes));


        System.out.println("是否为参数化类型：" + (type instanceof ParameterizedType));
        ParameterizedType parameterizedType = (ParameterizedType) type;

        // 获得参数化类型中<>里面的类型参数的类型
        System.out.print("实际类型是：");
        Arrays.stream(parameterizedType.getActualTypeArguments()).forEach(t -> {
            System.out.print(t + "; ");
        });
        System.out.println();
        // 返回最外层<>前面那个类型，例如Map<K ,V>，针对K或V来说，返回的就是Map类型
        System.out.println("外层类型：" + parameterizedType.getRawType());

        // 如果当前类型为顶层类型，则返回null（通常情况是这样），例如：Map.Entry中的Entry返回的就是Map，A.B.C中的C返回的就是A$B
        System.out.println("上层类型：" + parameterizedType.getOwnerType());
    }


    /**
     * 测试属性
     * @param fieldName
     * @throws NoSuchFieldException
     */
    private static void testField(String fieldName) throws NoSuchFieldException {
        Field f = ParameterizedTypeExample.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        // 获取属性的类型
        Type fieldType = f.getGenericType();
        System.out.println("属性的类型：" + fieldType);

        // 判断属性的类型是否为参数化类型
        boolean b = fieldType instanceof ParameterizedType;
        System.out.println("是否为参数化类型："+ b);

        // 如果是的话
        if(b){
            // 获取该字段的参数化类型
            ParameterizedType pType = (ParameterizedType) fieldType;

            // 获取参数化类型的实际类型
            System.out.print("实际类型是：");
            for (Type type : pType.getActualTypeArguments()) {
                System.out.print(type + "; ");
            }
            System.out.println();
            // 返回最外层<>前面那个类型
            System.out.println("外层类型：" + pType.getRawType());

            // 如果当前类型为顶层类型，则返回null（通常情况是这样），例如：Map.Entry中的Entry返回的就是Map，A.B.C中的C返回的就是A$B
            System.out.println("上层类型：" + pType.getOwnerType());
        }
    }


    static class Student{}


}
