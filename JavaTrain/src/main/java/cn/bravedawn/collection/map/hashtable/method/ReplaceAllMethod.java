package cn.bravedawn.collection.map.hashtable.method;

import cn.bravedawn.collection.map.hashtable.Word;

import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 22:55
 */
public class ReplaceAllMethod {

    /**
     * 无需遍历，替换所有的值
     */

    public static void main(String[] args) {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "a small domesticated carnivorous mammal");
        table.put(new Word("dog"), "another animal");
        table.replaceAll((k, v) -> k.getName() + " - " + v);

        System.out.println(table);
    }
}
