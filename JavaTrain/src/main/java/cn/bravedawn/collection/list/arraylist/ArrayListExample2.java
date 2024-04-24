package cn.bravedawn.collection.list.arraylist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/13 13:17
 */
public class ArrayListExample2 {

    /**
     * 在无序和有序list中搜索元素
     */

    public static void main(String[] args) {
        // 在无序list中搜索元素
        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(Collectors.toCollection(ArrayList::new));
        List<String> stringToSearch = new ArrayList<>(list);
        stringToSearch.addAll(list);

        System.out.println(stringToSearch); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, e, f, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, e, f]
        // 从头部搜索元素并返回下标
        System.out.println(stringToSearch.indexOf("a")); // 10
        // 从尾部搜索元素并返回下标
        System.out.println(stringToSearch.lastIndexOf("a")); // 26

        // 使用Java8 Stream API
        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "c", "9"));
        List<String> result = stringToSearch
                .stream()
                .filter(matchingStrings::contains)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(result); // [9, a, c, 9, a, c]

        // -----------------------------------------------

        // 在有序list中搜索元素
        List<String> copy = new ArrayList<>(stringToSearch);
        Collections.sort(copy);
        System.out.println(copy);
        int index = Collections.binarySearch(copy, "f"); // [0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, a, a, b, b, c, c, d, d, e, e, f, f]
        System.out.println(index); // 30
    }
}
