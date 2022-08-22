package cn.bravedawn.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/7/4 10:57
 */
public class ListExample4 {


    /**
     * 从下面的实验可以看出，使用Iterator.remove方法，可以同步移除list里面的元素
     * 这里还有一个要点：使用Iterator.remove的方法，在声明list的时候：
     *    不能这样写：List<String> list = Arrays.asList("1212", "apple", "1313");，这样声明在iterator.remove()时会报错，报UnsupportedOperationException
     *    需要这样写：List<String> list = new ArrayList<>(Arrays.asList("1212", "apple", "1313"));
     */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1212", "apple", "1313"));
        // System.out.println(list instanceof ArrayList<String>); //true

        List<String> list2 = Arrays.asList("1414", "apple", "1515");
        // System.out.println(list2 instanceof Arrays.ArrayList<String>); // true

        List<String> list3 = new ArrayList<>();
        // System.out.println(list3 instanceof ArrayList<String>); //true


        Iterator<String> iterator = list2.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals("apple")) {
                iterator.remove();
            }
        }

        System.out.println(list);

    }
}
