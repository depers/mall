package cn.bravedawn.collection.map.hashtable;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 20:56
 */
public class FailFastIteration {

    /**
     * HashTable的迭代器是Fail Fast的
     */

    public static void main(String[] args) {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "an animal");
        table.put(new Word("dog"), "another animal");

        Iterator<Word> it = table.keySet().iterator();
        System.out.println("iterator created");

        table.remove(new Word("dog"));
        System.out.println("element removed");

        while (it.hasNext()) {
            Word key = it.next(); // java.util.ConcurrentModificationException
            System.out.println(table.get(key));
        }
    }
}
