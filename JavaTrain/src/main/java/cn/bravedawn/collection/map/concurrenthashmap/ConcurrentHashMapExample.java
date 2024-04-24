package cn.bravedawn.collection.map.concurrenthashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/12 9:52
 */
public class ConcurrentHashMapExample {

    /**
     * 验证HashMap的线程不安全
     * 下面这段代码的逻辑是：
     * 对map中test键值对的value进行加一操作，每次新建4个线程去执行10次加一操作。前面这段代码执行10次。这样的话正常情况下，test对于的value值会计数到100.
     * 但是由于HashMap不是线程安全的，并发条件下对同一个键值对进行更新操作会出现不一致的情况。
     */


    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> sumList = parallelSum100(map, 100);
        long count = sumList.stream().distinct().count();
        long wrongResultCount = sumList.stream().filter(num -> num != 100).count();

        System.out.println(sumList.size()); // 100
        System.out.println(count); // 7，不一定
        System.out.println(wrongResultCount); // 12，不一定
    }

    private static List<Integer> parallelSum100(Map<String, Integer> map, int executionTimes) throws InterruptedException {
        List<Integer> sumList = new ArrayList<>(1000);
        for (int i = 0; i < executionTimes; i++) {
            map.put("test", 0);
            ExecutorService executorService =
                    Executors.newFixedThreadPool(4);
            for (int j = 0; j < 10; j++) {
                executorService.execute(() -> {
                    for (int k = 0; k < 10; k++)
                        map.computeIfPresent(
                                "test",
                                (key, value) -> value + 1
                        );
                });
            }
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS); // 进行阻塞，等待线程池执行结束或超时
            sumList.add(map.get("test"));
        }
        return sumList;
    }
}
