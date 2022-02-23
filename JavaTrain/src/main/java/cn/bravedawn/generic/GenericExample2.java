package cn.bravedawn.generic;

import java.util.ArrayList;

public class GenericExample2 {


    /**
     * 泛型的继承关系：可以把ArrayList<Integer>向上转型为List<Integer>（T不能变，这里的T指的是Integer），
     * 但不能把ArrayList<Integer>向上转型为ArrayList<Number>或List<Number>（T不能变成父类）
     */

    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();

        integerList.add(new Integer(12));

        //ArrayList<Number> numberList = integerList;


    }

}
