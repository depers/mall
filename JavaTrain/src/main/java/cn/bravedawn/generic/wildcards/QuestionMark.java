package cn.bravedawn.generic.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuestionMark {

    // 无限定通配符<?>很少使用，可以用<T>替换，同时它是所有<T>类型的超类


    public static void main(String[] args) {

        Collection<?> coll = new ArrayList<String>();
        //OR
        List<? extends Number> list = new ArrayList<Long>();
        //OR
        Pair2<String,?> pair = new Pair2<String,Integer>();
    }



}
