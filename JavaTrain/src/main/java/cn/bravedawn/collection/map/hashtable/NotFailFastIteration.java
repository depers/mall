package cn.bravedawn.collection.map.hashtable;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 20:59
 */
public class NotFailFastIteration {

    /**
     * 迭代HashTable的枚举是不会Fail Fast的
     */

    public static void main(String[] args) {

        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("1"), "one");
        table.put(new Word("2"), "two");
        table.put(new Word("3"), "three");
        table.put(new Word("4"), "four");
        table.put(new Word("5"), "five");
        table.put(new Word("6"), "six");
        table.put(new Word("7"), "seven");
        table.put(new Word("8"), "eight");

        Enumeration<Word> enumKey = table.keys();
        System.out.println("Enumeration created");
        table.remove(new Word("1"));
        System.out.println("element removed");

        System.out.println("------------------------");

        while (enumKey.hasMoreElements()) {
            Word key = enumKey.nextElement();
            System.out.println(table.get(key));
        }

    }
}
