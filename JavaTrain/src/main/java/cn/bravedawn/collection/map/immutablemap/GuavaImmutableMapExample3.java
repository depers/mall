package cn.bravedawn.collection.map.immutablemap;

import com.google.common.collect.ImmutableMap;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/19 22:15
 */
public class GuavaImmutableMapExample3 {

    /**
     * of()方法支持传入多对键值参数
     */

    public static void main(String[] args) {
        ImmutableMap<String, String> immutableMap = ImmutableMap
                .of("USA", "North America", "Costa Rica", "North America");

        System.out.println(immutableMap.containsKey("USA"));
    }
}
