package cn.bravedawn.collection.map.hashtable.method;

import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 22:40
 */
public class ComputeMethod {


    /**
     * 将remappingFunction函数的运算结果作为map的value
     */


    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        String[] animals = { "cat", "dog", "dog", "cat", "bird", "mouse", "mouse" };
        for (String animal : animals) {
            table.compute(animal, (key, value) -> (value == null ? 1 : value + 1));
        }

        System.out.println(table);
    }



}
