package cn.bravedawn.collection.map.immutablemap;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/19 21:49
 */
public class GuavaImmutableMapExample {

    /**
     * 使用Guava提供的ImmutableMap，即不能直接修改，也不能间接修改
     */

    public static void main(String[] args) {
        Map<String, String> mutableMap = new HashMap<>();
        mutableMap.put("USA", "North America");
        ImmutableMap<String, String> immutableMap = ImmutableMap.copyOf(mutableMap);

        // 原map的修改并不影响现在的不可变map
        mutableMap.remove("USA");
        System.out.println(mutableMap); // {}
        System.out.println(immutableMap); // {USA=North America}
        immutableMap.put("Canada", "North America"); //java.lang.UnsupportedOperationException

    }
}
