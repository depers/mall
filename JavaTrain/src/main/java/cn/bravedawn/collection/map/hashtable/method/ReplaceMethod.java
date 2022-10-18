package cn.bravedawn.collection.map.hashtable.method;

import cn.bravedawn.collection.map.hashtable.Word;

import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 21:43
 */
public class ReplaceMethod {

    /**
     * 替换一个条目，前提是他的value与预期的一致
     */

    public static void main(String[] args) {
        testBeforeJava8();
        testAfterJava8();
    }

    static void testBeforeJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");

        String definition = "an animal";

        // old way
        if (table.containsKey(new Word("cat")) && table.get(new Word("cat")).equals("a small domesticated carnivorous mammal")) {
            table.put(new Word("cat"), definition);
        }
    }

    static void testAfterJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");

        String definition = "an animal";

        // new way
        table.replace(new Word("cat"), "a small domesticated carnivorous mammal", definition);
    }
}
