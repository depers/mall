package cn.bravedawn.collection.map.mapdefaultmethod.computeifpresent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/12 11:59
 */
public class ComputeIfPresentExample2 {

    /**
     * 如果key对应的键值对不存在，则该键值对不会被添加到map中
     */

    public static void main(String[] args) {
        Map<String, Double> fruitMap = new HashMap<>();
        BiFunction<Double, Integer, Double> powFunction = (x1, x2) -> Math.pow(x1, x2);
        fruitMap.computeIfPresent("apple", (k, v) -> powFunction.apply(v, 2));

        System.out.println(fruitMap.get("apple")); // null
        System.out.println(fruitMap.size()); // 0


    }
}
