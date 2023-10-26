package cn.bravedawn.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2022/04/25 3:22 PM
 */
public class ListExample2 {


    /**
     * list的遍历
     */

    public static void main(String[] args) {

        func1();
        System.out.println("---------------------");

        func2();
        System.out.println("---------------------");

        func3();
        System.out.println("---------------------");

        func4();
        System.out.println("---------------------");

        func5();
        System.out.println("---------------------");
    }



    /**
     * 通过for循环遍历
     */
    static void func1() {
        List<String> list = List.of("apple", "pear", "banana");
        for (int i=0; i<list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }


    /**
     * 通过Iterator遍历，他的核心方法hasNext()和next()
     */
    static void func2() {
        List<String> list = List.of("apple", "pear", "banana");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
    }

    /**
     * 通过for each循环来做，Java优化后还是使用iterator来做的
     */
    static void func3() {
        List<String> list = List.of("apple", "pear", "banana");
        for (String s : list) {
            System.out.println(s);
        }
    }


    /**
     * 当List的size为0时，遍历的时候就不会执行for里面的操作，也不会报错
     */
    static void func4() {
        List<String> list = new ArrayList();
        System.out.println("list的大小:" + list.size());
        for (String item : list) {
            System.out.println(item);
        }
    }


    /**
     * 使用Java8的stream流去测试数组的遍历，也不会去执行for里面的操作，不会报错
     */
    static void func5() {
        List<String> list = new ArrayList();
        System.out.println("list的大小:" + list.size());
        list.stream().forEach(System.out::println);
    }

}
