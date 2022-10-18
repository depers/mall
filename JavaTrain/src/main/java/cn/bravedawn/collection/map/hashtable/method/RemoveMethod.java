package cn.bravedawn.collection.map.hashtable.method;

import cn.bravedawn.collection.map.hashtable.Word;

import java.lang.invoke.VarHandle;
import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 21:14
 */
public class RemoveMethod {

    /**
     * 移除一个条目，前提是他的value与预期的一致
     */

    public static void main(String[] args) {
        testBeforeJava8();
        testAfterJava8();
    }

    static void testBeforeJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");

        // old way
        if (table.get(new Word("cat")).equals("an animal")) {
            String catValue = table.remove(new Word("cat"));
            System.out.println(catValue);
        }
    }

    static void testAfterJava8() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");

        // new way
        boolean result = table.remove(new Word("cat"), "an animal");
        System.out.println(result);
    }
}
