package cn.bravedawn.collection.map.enummap;

import java.util.*;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/2 21:29
 */
public class CollectionViews {

    /**
     * 集合视图
     * 1.键视图
     * 2.值视图
     * 3.元素视图
     */


    public static void main(String[] args) {
        EnumMap<DayOfWeek, String> dayMap = new EnumMap(DayOfWeek.class);
        dayMap.put(DayOfWeek.THURSDAY, "Karate");
        dayMap.put(DayOfWeek.WEDNESDAY, "Hiking");
        dayMap.put(DayOfWeek.MONDAY, "Soccer");

        // values
        Collection values = dayMap.values();
        System.out.println(values);


        // keySet
        Set keys = dayMap.keySet();
        System.out.println(keys);

        // entrySet
        Set<Map.Entry<DayOfWeek, String>> entries = dayMap.entrySet();
        System.out.println(entries);
        System.out.println(entries.contains(new AbstractMap.SimpleEntry<>(DayOfWeek.MONDAY, "Soccer")));

        // mutability
        // 在原始map的修改会提现在子视图上面
        dayMap.put(DayOfWeek.TUESDAY, "Basketball");
        System.out.println(values);

        // 对子视图的修改也会体现在原始map上面
        values.remove("Hiking");
        System.out.println(dayMap);

    }
}
