package cn.bravedawn.collection.list.copyonwritearraylist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/14 10:22
 */
public class CopyOnWriteArrayListExample {

    /**
     * 在遍历CopyOnWriteArrayList时插入元素，不影响之前创建的迭代器
     */

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 5, 8});
        // 调用iterator()获得列表中数据的不可变快照
        Iterator<Integer> iterator = numbers.iterator();
        // 添加新元素10
        numbers.add(10);
        List<Integer> result = new LinkedList<>();
        iterator.forEachRemaining(result::add);
        // 所以我们在这里是看不到数据10的
        System.out.println(result); // [1, 2, 5, 8]

        // 下面的遍历我们就能看到10了
        Iterator<Integer> iterator2 = numbers.iterator();
        List<Integer> result2 = new LinkedList<>();
        iterator2.forEachRemaining(result2::add);
        System.out.println(result2); // [1, 2, 5, 8, 10]
    }
}
