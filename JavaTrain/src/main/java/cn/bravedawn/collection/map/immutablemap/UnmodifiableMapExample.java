package cn.bravedawn.collection.map.immutablemap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/19 21:41
 */
public class UnmodifiableMapExample {


    /**
     * 使用 Collections.unmodifiableMap将一个可变map变为不可修改的map
     * 但是底层map是可以修改的，修改的内容也会同步体现在不可修改map中
     * 综上所述，不能直接修unmodifiableMap，但是可以间接进行修改
     */


    public static void main(String[] args) {
        Map<String, String> mutableMap = new HashMap<>();
        mutableMap.put("USA", "North America");

        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(mutableMap);
        // unmodifiableMap.put("Canada", "North America"); // java.lang.UnsupportedOperationException

        // 但是底层map是可以修改的，修改的内容也会同步体现在不可修改mao中
        mutableMap.put("Canada", "North America");
        mutableMap.remove("USA");
        System.out.println(mutableMap);
        System.out.println(unmodifiableMap);
    }
}
