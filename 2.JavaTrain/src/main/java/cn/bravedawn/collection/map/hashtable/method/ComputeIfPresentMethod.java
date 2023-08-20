package cn.bravedawn.collection.map.hashtable.method;

import cn.bravedawn.collection.map.hashtable.Word;

import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 22:33
 */
public class ComputeIfPresentMethod {

    /**
     * 若key对应的键值对存在，则将remappingFunction的运算结果作为value添加到map中
     */

    public static void main(String[] args) {
        testBeforeJava8();
        testAfterJava();
    }

    static void testBeforeJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");

        Word cat = new Word("cat");

        // old way
        if (table.containsKey(cat)) {
            String concatination = cat.getName() + " - " + table.get(cat);
            table.put(cat, concatination);
        }

        System.out.println(table);
    }

    static void testAfterJava() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");

        Word cat = new Word("cat");

        // new way
        table.computeIfPresent(cat, (key, value) -> key.getName() + " - " + value);
        System.out.println(table);
    }
}
