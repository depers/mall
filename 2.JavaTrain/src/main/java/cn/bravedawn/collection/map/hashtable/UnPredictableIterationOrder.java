package cn.bravedawn.collection.map.hashtable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 21:01
 */
public class UnPredictableIterationOrder {

    /**
     * Hashtable 中的迭代顺序是不可预测的
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

        Iterator<Map.Entry<Word, String>> it = table.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Word, String> entry = it.next();
            System.out.println(entry.getValue());
        }
    }
}
