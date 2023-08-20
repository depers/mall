package cn.bravedawn.collection.map.concurrentskiplistmap.example;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/17 21:14
 */
public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        EventWindowSort eventWindowSort = new EventWindowSort();
        int numberOfThreads = 2;

        Runnable producer = () -> IntStream
                .rangeClosed(0, 100)
                .forEach(index -> eventWindowSort.acceptEvent(
                        new Event(ZonedDateTime.now().minusSeconds(index), UUID.randomUUID().toString()))
                );

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(producer);
        }

        // --------------------------------------下面是主线程的代码

        Thread.sleep(500);

        // 获取返回过去一分钟之前的所有事件
        ConcurrentNavigableMap<ZonedDateTime, String> eventsFromLastMinute = eventWindowSort.getEventsOlderThatOneMinute();
        // 这些事件是否是一分钟前的事件，并计算数量
        long eventsOlderThanOneMinute = eventsFromLastMinute
                .entrySet()
                .stream()
                .filter(e -> e.getKey().isBefore(ZonedDateTime.now().minusMinutes(1)))
                .count();
        System.out.println(eventsOlderThanOneMinute); // 这个数据量不一定，取决于生产者线程将事件发送到 EventWindowSort 的速度

        // 这些事件是否是一分钟后的事件，并计算数量
        long eventYoungerThanOneMinute = eventsFromLastMinute
                .entrySet()
                .stream()
                .filter(e -> e.getKey().isAfter(ZonedDateTime.now().minusMinutes(1)))
                .count();
        System.out.println(eventYoungerThanOneMinute); // 这个肯定为0
    }
}
