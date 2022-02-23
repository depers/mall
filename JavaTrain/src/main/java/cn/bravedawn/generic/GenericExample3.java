package cn.bravedawn.generic;

import cn.bravedawn.generic.genericclass.Generic;

public class GenericExample3 {


    /**
     * 类型不匹配
     */
    public static void showKeyValue(Generic<Number> obj){
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }


    /**
     * 如果不确定具体的类型，可以将类型写成?
     */

    public static void showKeyValue1(Generic<?> obj){
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> gNumber = new Generic<>(456);

        showKeyValue(gNumber);
        // showKeyValue(gInteger); 这里会报错的

        showKeyValue1(gNumber);
        showKeyValue1(gInteger);

    }
}
