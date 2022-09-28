package cn.bravedawn.collection.set.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/28 10:44
 */
public class HashSetExample {

    public static void main(String[] args) {
        // 创建HashSet实例
        Set<String> hashset = new HashSet<>();

        // 添加元素
        hashset.add("a");
        hashset.add("b");
        boolean addFlag = hashset.add("c");
        boolean addFlag2 = hashset.add("c");
        System.out.println(addFlag); // true
        System.out.println(addFlag2); // false

        // 检查一个元素是否存在
        boolean exist = hashset.contains("a");
        System.out.println(exist); // true

        // 移除元素
        boolean removeFlag = hashset.remove("c");
        boolean removeFlag2 = hashset.remove("c");
        System.out.println(removeFlag); // true
        System.out.println(removeFlag2); // false

        // 清空元素
        System.out.println(hashset); // [a, b]
        hashset.clear();
        System.out.println(hashset); // []

        // set的大小
        hashset.add("d");
        int size = hashset.size();
        System.out.println(size); // 1

        // 判断hashset是否为空
        boolean emptyFlag = hashset.isEmpty();
        System.out.println(emptyFlag); // false

        // Iterator遍历，遍历时不考虑顺序
        Set<String> set = new HashSet<>();
        set.add("fengxiao");
        set.add("xiaoming");
        set.add("xiaofang");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " "); // fengxiao xiaoming xiaofang
        }

        // Iterator遍历的过程中，使用hashset.remove()进行删除，会报ConcurrentModificationException异常
        Set<String> set2 = new HashSet<>();
        set2.add("fengxiao");
        set2.add("xiaoming");
        set2.add("xiaofang");
        Iterator<String> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            iterator2.next();
            set2.remove("xiaoming"); // java.util.ConcurrentModificationException
        }

        // Iterator遍历的过程中，使用Iterator.remove()进行删除，没有报错
        Set<String> set3 = new HashSet<>();
        set3.add("fengxiao");
        set3.add("xiaoming");
        set3.add("xiaofang");
        Iterator<String> iterator3 = set3.iterator();
        while (iterator3.hasNext()) {
            iterator3.next();
            iterator3.remove();
        }

    }
}
