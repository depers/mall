package cn.bravedawn.collection.collections;


import java.util.List;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-02 14:58
 */
public class CollectionsOfExample {

    /**
     * 使用List.of(T...)更方便，因为它既可以创建空集合，也可以闯将单元素集合，还可以创建人任意个元素的集合
     * 值得注意的是这些集合都是不可变集合
     */

    public static void main(String[] args) {
        List<String> list1 = List.of(); // empty list
        List<String> list2 = List.of("apple"); // 1 element
        List<String> list3 = List.of("apple", "pear"); // 2 element
        List<String> list4 = List.of("apple", "pear", "orange"); // 3 element
    }
}
