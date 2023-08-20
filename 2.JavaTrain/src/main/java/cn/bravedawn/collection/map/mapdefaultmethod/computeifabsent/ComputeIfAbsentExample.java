package cn.bravedawn.collection.map.mapdefaultmethod.computeifabsent;

import java.util.HashMap;
import java.util.Map;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/12 10:41
 */
public class ComputeIfAbsentExample {

    /**
     * 与特定key关联的value若不为null，computeIfAbsent()方法会直接返回value值，不会执行mappingFunction
     */

    public static void main(String[] args) {
        Map<String, Integer> stringLength = new HashMap<>();
        stringLength.put("John", 5);
        int value = stringLength.computeIfAbsent("John", s -> s.length());
        System.out.println(value); // 5
    }
}
