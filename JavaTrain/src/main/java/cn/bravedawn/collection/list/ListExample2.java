package cn.bravedawn.collection.list;

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

        func2();

        func3();
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
     * 通过for each循环来做
     */
    static void func3() {
        List<String> list = List.of("apple", "pear", "banana");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
