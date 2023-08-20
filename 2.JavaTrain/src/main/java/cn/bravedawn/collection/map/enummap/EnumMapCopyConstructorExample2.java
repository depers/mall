package cn.bravedawn.collection.map.enummap;

import cn.bravedawn.basic.enum_.Weekday;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/2 13:21
 */
public class EnumMapCopyConstructorExample2 {

    /**
     * 如果有一个键是枚举的非空 Map，也可以作为EnumMap的构造函数的入参，从而构造他的副本。
     * 如果指定的映射包含多个枚举类型，则构造函数将抛出 ClassCastException。
     */

    public static void main(String[] args) {
        Map<DayOfWeek, String> ordinaryMap = new HashMap();
        ordinaryMap.put(DayOfWeek.MONDAY, "Soccer");

        EnumMap enumMap = new EnumMap(ordinaryMap);
        System.out.println(enumMap.size() == 1); // true
        System.out.println(enumMap.get(DayOfWeek.MONDAY).equals("Soccer")); // true


        Map ordinaryMap2 = new HashMap();
        ordinaryMap2.put(DayOfWeek.MONDAY, "Soccer");
        ordinaryMap2.put(Weekday.SUN, "Basketball");
        // 如果指定的映射包含多个枚举类型，则构造函数将抛出 ClassCastException。
        EnumMap enumMap2 = new EnumMap(ordinaryMap2); // java.lang.ClassCastException
    }
}
