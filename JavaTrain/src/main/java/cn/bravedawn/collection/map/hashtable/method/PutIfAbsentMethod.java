package cn.bravedawn.collection.map.hashtable.method;

import cn.bravedawn.collection.map.hashtable.Word;

import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 21:50
 */
public class PutIfAbsentMethod {

    /**
     * 如果键不存在，就将他添加到map中
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
        if (!table.containsKey(new Word("cat"))) {
            table.put(new Word("cat"), definition);
        }

        System.out.println(table);
    }


    static void testAfterJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");

        String definition = "an animal";
        // new way
        table.putIfAbsent(new Word("cat"), definition);

        System.out.println(table);
    }
}
