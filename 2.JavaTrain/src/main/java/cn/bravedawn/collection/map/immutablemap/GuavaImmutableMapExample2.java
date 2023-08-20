package cn.bravedawn.collection.map.immutablemap;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/19 21:59
 */
public class GuavaImmutableMapExample2 {

    /**
     * 通过Builder构建的ImmutableMap也是一样的，修改原有的map并不影响现有的
     */

    public static void main(String[] args) {
        Map<String, String> mutableMap = new HashMap<>();
        mutableMap.put("USA", "North America");
        ImmutableMap<String, String> immutableMap = ImmutableMap.<String, String>builder()
                .putAll(mutableMap)
                .put("Costa Rica", "North America")
                .build();

        mutableMap.remove("USA"); // java.lang.UnsupportedOperationException
        System.out.println(mutableMap); // {}
        System.out.println(immutableMap); // {USA=North America, Costa Rica=North America}
        immutableMap.put("Canada", "North America"); //java.lang.UnsupportedOperationException


    }
}
