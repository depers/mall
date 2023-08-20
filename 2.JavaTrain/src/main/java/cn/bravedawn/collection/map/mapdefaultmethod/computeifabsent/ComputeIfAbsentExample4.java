package cn.bravedawn.collection.map.mapdefaultmethod.computeifabsent;

import java.util.HashMap;
import java.util.Map;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/12 10:54
 */
public class ComputeIfAbsentExample4 {

    /**
     * mappingFunction的异常会传播出来到computeIfAbsent()方法
     */

    public static void main(String[] args) {
        Map<String, Integer> stringLength = new HashMap<>();
        stringLength.computeIfAbsent("John", s -> { throw new RuntimeException(); }); // java.lang.RuntimeException
    }
}
