package cn.bravedawn.generic.border;

import cn.bravedawn.generic.genericclass.Generic;

public class TopBorderExample<T extends Number> {


    /**
     * 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
     */

    public static void showKeyValue(Generic<? extends Number> obj){
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }


    public static void main(String[] args) {
        Generic<String> generic1 = new Generic<>("11");
        Generic<Integer> generic2 = new Generic<>(123);
        Generic<Float> generic3 = new Generic<>(2.4f);
        Generic<Double> generic4 = new Generic<>(2.56);

        //showKeyValue(generic1);
        showKeyValue(generic2);
        showKeyValue(generic3);
        showKeyValue(generic4);
    }
}
