package cn.bravedawn.collection.list.arraylist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/13 13:24
 */
public class ArrayListExample3 {

    /**
     * 移除列表中的元素
     */


    public static void main(String[] args) {

        // 从list中移除元素
        List<Integer> list = new ArrayList<>(
                IntStream.range(0, 10).boxed().collect(Collectors.toCollection(ArrayList::new))
        );
        Collections.reverse(list);
        System.out.println(list); // [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]

        list.remove(0);
        System.out.println(list); // [8, 7, 6, 5, 4, 3, 2, 1, 0]

        // 这里要注意，参数是包装类型
        list.remove(Integer.valueOf("0"));
        System.out.println(list); // [8, 7, 6, 5, 4, 3, 2, 1]


        // 通过迭代器去移除元素
        List<String> list2 = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(Collectors.toCollection(ArrayList::new));
        List<String> stringToSearch = new ArrayList<>(list2);
        stringToSearch.addAll(list2);
        System.out.println(stringToSearch); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, e, f, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, e, f]

        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        Iterator<String> it = stringToSearch.iterator();
        while (it.hasNext()) {
            if (matchingStrings.contains(it.next())) {
                it.remove();
            }
        }
        System.out.println(stringToSearch); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]


        // 通过使用Java8 Stream API
        Set<String> matchingStrings2 = new HashSet<>(Arrays.asList("0", "1"));
        stringToSearch.removeAll(stringToSearch.stream().filter(matchingStrings2::contains).collect(Collectors.toList()));
        System.out.println(stringToSearch); // [2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
