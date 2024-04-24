package cn.bravedawn.collection.map.hashtable.method;

import cn.bravedawn.collection.map.hashtable.Word;

import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 21:06
 */
public class GetOrDefaultMethod {

    /**
     * 如果一个键在map中不存在，通过设置他的默认值来获取
     */

    public static void main(String[] args) {
        testBeforeJava8();
        testAfterJava8();
    }

    static void testBeforeJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");
        Word key = new Word("dog");
        String definition;

        // Before
         if (table.containsKey(key)) {
            definition = table.get(key);
        } else {
            definition = "not found";
        }

        System.out.println(definition); // not found
    }

    static void testAfterJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");
        Word key = new Word("dog");
        String definition;

        // After
        definition = table.getOrDefault(key, "not found");

        System.out.println(definition); // not found
    }

}
