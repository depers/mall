package cn.bravedawn.collection.map.concurrenthashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/14 17:16
 */
public class ConcurrentHashMapExample4 {

    /**
     * 下面这段端代码是为了测试Hashtable, Collections.synchronizedMap和ConcurrentHashMap编写的代码
     * 使用四个线程，执行get和set操作50万次，统计上面三种数据结构的性能
     * 经过测试发现，在多线程环境下，ConcurrentHashMap的耗时是最短的
     */

    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> hashtable = new Hashtable<>();
        Map<String, Object> synchronizedHashMap =
                Collections.synchronizedMap(new HashMap<>());
        Map<String, Object> concurrentHashMap = new ConcurrentHashMap<>();

        long hashtableAvgRuntime = timeElapseForGetPut(hashtable);
        long syncHashMapAvgRuntime = timeElapseForGetPut(synchronizedHashMap);
        long concurrentHashMapAvgRuntime = timeElapseForGetPut(concurrentHashMap);

        System.out.println(hashtableAvgRuntime);
        System.out.println(syncHashMapAvgRuntime);
        System.out.println(concurrentHashMapAvgRuntime);
    }


    static long timeElapseForGetPut(Map<String, Object> map)
            throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        long startTime = System.nanoTime();
        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 500_000; j++) {
                    int value = ThreadLocalRandom
                            .current()
                            .nextInt(10000);
                    String key = String.valueOf(value);
                    map.put(key, value);
                    map.get(key);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        return (System.nanoTime() - startTime) / 500_000;
    }
}
