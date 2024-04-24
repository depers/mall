package cn.bravedawn.collection.list.copyonwritearraylist;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/14 10:40
 */
public class CopyOnWriteArrayListExample2 {

    /**
     * 遍历时移除元素是不允许的
     */

    public static void main(String[] args) {

        // 不能再迭代遍历时移除元素，否则就会报错 UnsupportedOperationException
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            iterator.remove(); // java.lang.UnsupportedOperationException
        }
    }

}
