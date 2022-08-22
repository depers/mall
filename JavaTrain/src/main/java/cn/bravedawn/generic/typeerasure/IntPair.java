package cn.bravedawn.generic.typeerasure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class IntPair extends Pair<Integer>{


    /**
     * 在继承泛型类型的情况下，子类可以获取父类的泛型类型
     */

    public IntPair(Integer first, Integer last) {
        super(first, last);
    }


    public static void main(String[] args) {
        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();

        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments();
            Type firstType = types[0];
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // class java.lang.Integer
        }
    }
}
