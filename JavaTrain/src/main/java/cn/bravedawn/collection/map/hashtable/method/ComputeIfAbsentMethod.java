package cn.bravedawn.collection.map.hashtable.method;

import cn.bravedawn.collection.map.hashtable.Word;

import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 22:24
 */
public class ComputeIfAbsentMethod {

    /**
     * 类似于 putIfAbsent()。但是 putIfAbsent() 直接取值，computeIfAbsent() 取映射函数的运算值
     * 若key不存则则将其添加到map中
     * @param args
     */

    public static void main(String[] args) {
        testBeforeJava8();
        testAfterJava8();
    }

    static void testBeforeJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");
        // new way
        table.computeIfAbsent(new Word("cat"), key -> "an animal");
        table.computeIfAbsent(new Word("dog"), key -> "an animal too");

        System.out.println(table);
    }

    static void testAfterJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");

        // old way
        if (!table.containsKey(new Word("cat"))) {
            String definition = "an animal"; // calculate
            table.put(new Word("cat"), definition);
        }
        System.out.println(table);
    }

}
