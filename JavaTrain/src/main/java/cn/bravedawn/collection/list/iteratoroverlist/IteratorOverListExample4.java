package cn.bravedawn.collection.list.iteratoroverlist;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/22 23:04
 */
public class IteratorOverListExample4 {

    /**
     * 方法四：使用ListIterator遍历
     * listIterator(index), 这里的index是很有讲究的，如果我们调用next方法，index会加一，如果调用previous的话，index会减一
     */

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");
        ListIterator<String> listIterator = countries.listIterator(countries.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " "); // Australia Panama Germany
        }
    }
}
