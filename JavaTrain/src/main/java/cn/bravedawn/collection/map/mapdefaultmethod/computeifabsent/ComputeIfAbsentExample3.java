package cn.bravedawn.collection.map.mapdefaultmethod.computeifabsent;

import java.util.HashMap;
import java.util.Map;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/12 10:49
 */
public class ComputeIfAbsentExample3 {

    /**
     * mappingFunction的执行结果可能为null，此时该key对应的映射将不会添加到map中
     */

    public static void main(String[] args) {
        Map<String, Integer> stringLength = new HashMap<>();
        Integer value = stringLength.computeIfAbsent("John", s -> null);
        System.out.println(value); // null
        System.out.println(stringLength.size()); // 0
    }
}
