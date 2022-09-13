package cn.bravedawn.collection.list.copyonwritearraylist;

import org.apache.commons.collections4.ListUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/13 22:05
 */
public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 5, 7});
        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(10);
        List<Integer> result = new LinkedList<>();
        iterator.forEachRemaining(result::add);
        System.out.println(numbers);
        System.out.println(result.equals(Arrays.asList(1, 2, 5, 7))); // true
    }
}
