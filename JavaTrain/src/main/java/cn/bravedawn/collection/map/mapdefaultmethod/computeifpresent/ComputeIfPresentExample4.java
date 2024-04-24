package cn.bravedawn.collection.map.mapdefaultmethod.computeifpresent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/12 18:25
 */
public class ComputeIfPresentExample4 {

    public static void main(String[] args) {
        Map<String, Double> fruitMap = new HashMap<>();
        Double newValue = 2.11;
        fruitMap.put("apple", newValue);
        Double oldAppleValue = fruitMap.get("apple");
        BiFunction<Double, Integer, Double> powFunction = (x1, x2) -> {throw new RuntimeException();};

        fruitMap.computeIfPresent("apple", (k, v) -> powFunction.apply(v, 2));
    }
}
