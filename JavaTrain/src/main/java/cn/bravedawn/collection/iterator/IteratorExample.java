package cn.bravedawn.collection.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/7/4 11:13
 */
public class IteratorExample {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1", "2", "abc");
        Iterator<String> iterator = stringList.iterator();

        while (iterator.hasNext()) {
            System.out.println("元素 = " + iterator.next());

            if (iterator.next().equals("2")) {
                iterator.remove();
            }

        }
    }
}
