package cn.bravedawn.collection.list.removealloccurencevalue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 18:40
 */
public class RemoveAllOccurrenceValueExample {

    /**
     * 实验：使用while循环，移除一个列表中的所有特定元素
     * 总结：
     *      下面三种方法的性能表现都很差。
     *      List.remove() 必须找到特定值的第一次出现以将其删除。
     *      此外，当我们使用 ArrayList 时，元素移动会导致多次引用复制，甚至多次重新分配后备数组。
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        int valueToElement = 1;
        // removeAll(list, valueToElement);

        System.out.println("---------------------------------------");
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        Integer valueToElement2 = 1;
        removeAll(list2, valueToElement2);

        System.out.println("---------------------------------------");
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        Integer valueToElement3 = 1;
        removeAll3(list3, valueToElement3);
    }

    /**
     * 实验一：remove(int)
     * 实验过程：
     *      下面的实验中我们想移除元素1，但是由于我们适用的移除方法是remove(int)，这个方法其实是在移除下标为1的元素。
     *      也就是说他会先移除2，然后列表元素移位补齐后，接着移除3，然后列表元素移位补齐之后，最后列表只剩下标为0的元素1，列表长度为1，
     *      无法再移除下标为1的元素了，所以这里报错了。
     */
    static void removeAll(List<Integer> list, int element) {
        while (list.contains(element)) {
            list.remove(element); // java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            System.out.println(list);
        }
    }

    /**
     * 实验二：remove(Integer-Object)
     * 实验过程：
     *      这里我们将方法的第二个参数换成了Integer，这里会调用remove(Object)方法，我们就能实现删除值为1的元素
     */
    static void removeAll(List<Integer> list, Integer element) {
        while (list.contains(element)) {
            list.remove(element);
            System.out.println(list);
        }
    }

    // 或者写成这样
    static void removeAll4(List<Integer> list, Integer element) {
        while (list.remove(element));
    }


    /**
     * 实验三：使用indexOf()和remove()方法结合去移除元素
     * 实验过程：
     *      在实验二中使用contains()和remove()方法遍历去查找第一次匹配特定值的元素，在查找过程中会导致不必要的遍历。
     *      如果我们直接保存特定值第一次出现的索引，然后去删除它，这样就能避免不必要的遍历
     */
    static void removeAll3(List<Integer> list, Integer element) {
        int index;
        while ((index = list.indexOf(element)) >= 0) {
            list.remove(index);
        }
        System.out.println(list);
    }
}
