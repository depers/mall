package cn.bravedawn.collection.map.mapdefaultmethod.computeifpresent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/12 18:20
 */
public class ComputeIfPresentExample3 {

    /**
     * 如果remappingFunction计算出来的值为null，该键对应的键值对将会被移除
     */

    public static void main(String[] args) {
        Map<String, Double> fruitMap = new HashMap<>();
        Double newValue = 2.11;
        fruitMap.put("apple", newValue);
        Double oldAppleValue = fruitMap.get("apple");
        BiFunction<Double, Integer, Double> powFunction = (x1, x2) -> null;

        fruitMap.computeIfPresent("apple", (k, v) -> powFunction.apply(v, 2));

        System.out.println(Double.valueOf(Math.pow(oldAppleValue, 2))); // 4.4521
        System.out.println(fruitMap.get("apple")); // null
        System.out.println(fruitMap.size()); // 0
    }
}
