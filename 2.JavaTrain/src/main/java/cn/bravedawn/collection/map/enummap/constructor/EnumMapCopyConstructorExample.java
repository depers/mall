package cn.bravedawn.collection.map.enummap.constructor;

import cn.bravedawn.collection.map.enummap.DayOfWeek;

import java.util.EnumMap;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/2 13:13
 */
public class EnumMapCopyConstructorExample {

    /**
     * 可以将原有的EnumMap作为构造函数的参数，构造其副本
     * 值得注意的是：修改新的副本map不会影响原来的map
     */

    public static void main(String[] args) {
        EnumMap<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);
        activityMap.put(DayOfWeek.MONDAY, "Soccer");
        activityMap.put(DayOfWeek.TUESDAY, "Basketball");

        EnumMap<DayOfWeek, String> activityMapCopy = new EnumMap<>(activityMap);

        System.out.println(activityMapCopy.size() == 2);
        System.out.println(activityMapCopy.get(DayOfWeek.MONDAY).equals("Soccer"));
        System.out.println(activityMapCopy.get(DayOfWeek.TUESDAY).equals("Basketball"));


        activityMapCopy.put(DayOfWeek.MONDAY, "ping pong");
        System.out.println(activityMap);
        System.out.println(activityMapCopy);
    }
}
