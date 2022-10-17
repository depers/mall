package cn.bravedawn.collection.map.concurrentskiplistmap.example;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/17 20:48
 */
public class EventWindowSort {

    // Comparator.comparingLong()方法以map的key为入参，返回一个key的比较器
    // 这里将ZonedDateTime转为毫秒数进行排序
    private final ConcurrentSkipListMap<ZonedDateTime, String> events
            = new ConcurrentSkipListMap<>(Comparator.comparingLong(value -> value.toInstant().toEpochMilli()));

    // 添加事件
    void acceptEvent(Event event) {
        // 添加元素到ConcurrentSkipListMap中，无需显示的同步操作
        events.put(event.getEventTime(), event.getContent());
    }

    /**
     * 返回过去一分钟内的所有事件的不可变快照，以无锁的方式
     */
    ConcurrentNavigableMap<ZonedDateTime, String> getEventsFromLastMinute() {
        // tailMap()方法返回此映射中键大于或等于 FROM Key 的部分的视图
        return events.tailMap(ZonedDateTime.now().minusMinutes(1));
    }


    /**
     * 返回过去一分钟之前的所有事件的不可变快照，以无锁的方式
     */
    ConcurrentNavigableMap<ZonedDateTime, String> getEventsOlderThatOneMinute() {
        // headMap()方法返回此映射的键严格小于 toKey 的部分的视图
        return events.headMap(ZonedDateTime.now().minusMinutes(1));
    }
}
