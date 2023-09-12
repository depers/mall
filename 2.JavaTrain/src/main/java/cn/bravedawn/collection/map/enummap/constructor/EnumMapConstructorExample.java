package cn.bravedawn.collection.map.enummap.constructor;

import cn.bravedawn.collection.map.enummap.DayOfWeek;

import java.util.EnumMap;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/2 13:11
 */
public class EnumMapConstructorExample {


    /**
     * EnumMap的构造函数的参数为 键的类型
     */

    public static void main(String[] args) {
        EnumMap<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);
        activityMap.put(DayOfWeek.MONDAY, "Soccer");
    }
}
