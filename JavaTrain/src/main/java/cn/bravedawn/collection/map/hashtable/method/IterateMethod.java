package cn.bravedawn.collection.map.hashtable.method;

import cn.bravedawn.collection.map.hashtable.Word;

import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 22:53
 */
public class IterateMethod {

    /**
     * 遍历map
     */

    public static void main(String[] args) {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");
        table.put(new Word("dog"), "another animal");
        table.forEach((k, v) -> System.out.println(k.getName() + " - " + v));

    }
}
