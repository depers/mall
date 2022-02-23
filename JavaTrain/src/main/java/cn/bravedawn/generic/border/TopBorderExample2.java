package cn.bravedawn.generic.border;

import cn.bravedawn.generic.genericclass.Generic;

public class TopBorderExample2 {

    /**
     * 在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
     */


    public static <T extends Number> T showKeyName(Generic<T> container) {
        System.out.println("container key: " + container.getKey());
        T test = container.getKey();
        return test;
    }


    public static void main(String[] args) {
        Generic<String> generic1 = new Generic<>("11");
        Generic<Integer> generic2 = new Generic<>(123);
        Generic<Float> generic3 = new Generic<>(2.4f);
        Generic<Double> generic4 = new Generic<>(2.56);

        //showKeyName(generic1);
        Integer integer = showKeyName(generic2);
        Float aFloat = showKeyName(generic3);
        Double aDouble = showKeyName(generic4);

    }
}
