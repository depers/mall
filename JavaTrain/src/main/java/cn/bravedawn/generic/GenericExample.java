package cn.bravedawn.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

    /**
     * 使用泛型之后编译器就不会报警告，而且不需要类型强转
     * @param args
     */

    public static void main(String[] args) {
        // 没有使用泛型，编译器警告
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        String first = (String) list.get(0);
        String second = (String) list.get(1);

        // 无编译器警告
        List<String> list2 = new ArrayList<>(); // 写成这样也可以 List<String> list2 = new ArrayList<String>()
        list2.add("hello");
        list2.add("world");
        // 无强制转型
        String first2 = list2.get(0);
        String second2 = list2.get(0);

    }
}
