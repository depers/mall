package cn.bravedawn.collection.map.enummap;

import cn.bravedawn.basic.enum_.Weekday;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapExample {


    public static void main(String[] args) {
        Map<Weekday, String> map = new EnumMap<Weekday, String>(Weekday.class);
        map.put(Weekday.MON, "星期一");
        map.put(Weekday.TUE, "星期二");
        map.put(Weekday.WED, "星期三");
        map.put(Weekday.THU, "星期四");
        map.put(Weekday.FRI, "星期五");
        map.put(Weekday.SAT, "星期六");
        map.put(Weekday.SUN, "星期天");

        System.out.println(map);
        System.out.println(map.get(Weekday.SUN));

    }
}
