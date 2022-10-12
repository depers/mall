package cn.bravedawn.collection.map.mapdefaultmethod.computeifabsent;

import java.util.HashMap;
import java.util.Map;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/12 10:43
 */
public class ComputeIfAbsentExample2 {

    /**
     * 若key对应的value为null或是键不存在的情况，computeIfAbsent()方法会将mappingFunction的执行结果（这个结果可能为null）赋值给value
     */


    public static void main(String[] args) {
        Map<String, Integer> stringLength = new HashMap<>();
        int value = stringLength.computeIfAbsent("John", s -> s.length());
        System.out.println(value);
    }
}
