package cn.bravedawn.collection.list.iteratoroverlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/22 23:02
 */
public class IteratorOverListExample3 {

    /**
     * 方法三：使用Iterator
     */

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");
        Iterator<String> countriesIterator = countries.iterator();
        while (countriesIterator.hasNext()) {
            System.out.println(countriesIterator.next());
        }
    }
}
