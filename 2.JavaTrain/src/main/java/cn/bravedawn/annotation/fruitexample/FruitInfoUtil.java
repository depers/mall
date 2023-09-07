package cn.bravedawn.annotation.fruitexample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/3/10 21:37
 */
public class FruitInfoUtil {

    /**
     * 获取修饰字段的注解属性
     */


    public static void getFruitInfo(Class<?> clazz) throws NoSuchMethodException {
        String strFruitName = "水果名称：";
        String strFruitColor = "水果颜色：";
        String strFruitProvider = "供应商信息：";


        // 判断Class上是否包含注解
        if (Apple.class.isAnnotationPresent(Fruit.class)) {
            System.out.println("Apple类包含Fruit注解");
            Fruit annotation = Apple.class.getAnnotation(Fruit.class);
            System.out.println("Fruit注解的信息：" + annotation);
            System.out.println("------------------------");
        }

        // 判断Method上面是否包含注解
        Method getName = Apple.class.getDeclaredMethod("getName");
        if (getName.isAnnotationPresent(cn.bravedawn.annotation.fruitexample.Method.class)) {
            System.out.println("Apple类的getName()方法包含Method注解");
            cn.bravedawn.annotation.fruitexample.Method method = getName.getAnnotation(cn.bravedawn.annotation.fruitexample.Method.class);
            System.out.println("Method注解的信息：" + method);
            System.out.println("------------------------");
        }

        // 判断Constructor上是否包含注解
        Constructor<Apple> declaredConstructor = Apple.class.getDeclaredConstructor(String.class, String.class, String.class);
        if (declaredConstructor.isAnnotationPresent(cn.bravedawn.annotation.fruitexample.Constructor.class)) {
            System.out.println("Apple类的全参构造函数包含Constructor注解");
            cn.bravedawn.annotation.fruitexample.Constructor constructor = declaredConstructor.getAnnotation(cn.bravedawn.annotation.fruitexample.Constructor.class);
            System.out.println("Constructor注解的信息：" + constructor);
            System.out.println("------------------------");
        }


        // 判断注解是否存在于Field中
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = "供应商编号：" + fruitProvider.id() + ", 供应商名称：" + fruitProvider.name()
                        + ", 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}
