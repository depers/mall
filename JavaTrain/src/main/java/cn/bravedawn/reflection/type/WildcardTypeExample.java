package cn.bravedawn.reflection.type;

import java.io.Closeable;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;

/**
 * @author : depers
 * @program : mybatis
 * @description: WildcardType类型测试
 * @date : Created in 2021/4/30 7:41
 */
public class WildcardTypeExample<T> {

    /**
     * 通配符类型WildcardType测试
     */

    // a没有下界
    private List<? extends Number> a;

    //	没有指定的话，上边界默认是 Object ,下边界是 String
    private List<? super String> b;

    private List<String> c;

    private Class<?> d;

    private List<? extends T> e;

    public static void main(String[] args) {
        Arrays.stream(WildcardTypeExample.class.getDeclaredFields()).forEach(field -> {
            Type type = field.getGenericType();
            Type actualTypeArgument = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (actualTypeArgument instanceof WildcardType) {
                System.out.println(field.getName()
                        + " 类型名称: "
                        + actualTypeArgument.getTypeName()
                        + " 上边界: "
                        + Arrays.toString(((WildcardType) actualTypeArgument).getUpperBounds())
                        + " 下边界: "
                        + Arrays.toString(((WildcardType) actualTypeArgument).getLowerBounds()));
            }
        });
    }
}
