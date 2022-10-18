package cn.bravedawn.collection.map.hashtable.method;

import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 22:46
 */
public class MergeMethod {


    /**
     * 这个方法感觉和Compute的运算结果一致
     * 如果键尚未在表上，第二个参数1就是映射到该键的值；如果键已经在表中，那么我们将其计算为 oldValue+1。
     */

    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        String[] animals = { "cat", "dog", "dog", "cat", "bird", "mouse", "mouse" };
        for (String animal : animals) {
            table.merge(animal, 1, (oldValue, value) -> (oldValue + value));
        }

        System.out.println(table);
    }
}
