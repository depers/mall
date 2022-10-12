package cn.bravedawn.collection.map.mapdefaultmethod.computeifpresent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/12 11:40
 */
public class ComputeIfPresentExample {

    /**
     * computeIfPresent()方法，如果键存在，就更新键对应的值
     */

    public static void main(String[] args) {
        Map<String, Double> fruitMap = new HashMap<>();
        Double newValue = 2.11;
        fruitMap.put("apple", newValue);
        fruitMap.put("orange", newValue);
        Double oldAppleValue = fruitMap.get("apple");
        BiFunction<Double, Integer, Double> powFunction = (x1, x2) -> Math.pow(x1, x2);

        fruitMap.computeIfPresent("apple", (k, v) -> powFunction.apply(v, 2));

        System.out.println(Double.valueOf(Math.pow(oldAppleValue, 2)));
        System.out.println(fruitMap.get("apple"));

    }
}
