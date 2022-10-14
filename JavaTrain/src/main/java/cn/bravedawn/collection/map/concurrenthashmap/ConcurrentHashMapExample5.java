package cn.bravedawn.collection.map.concurrenthashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/14 21:09
 */
public class ConcurrentHashMapExample5 {

    /**
     * 在ConcurrentHashMap中，包括size(), isEmpty(), containsValue()等聚合方法的结果仅在map未在其他线程中更新时才有用。
     * 意思也就是说使用聚合函数的过程中，该map也同时被另一个线程修改，此时是不能保证结果的实时准确性，但它们可能足以用于监控或估计目的。
     * ConcurrentHashMap 的 size() 的用法应该由 mappingCount() 代替，因为后一种方法返回一个长计数(long)，尽管在深层它们是基于相同的估计。
     */


    public static void main(String[] args) throws InterruptedException {
        int MAX_SIZE = 100000;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        List<Integer> mapSizes = new ArrayList<>(MAX_SIZE);

        Runnable collectMapSizes = () -> {
            for (int i = 0; i < MAX_SIZE; i++) {
                mapSizes.add(concurrentMap.size());
            }
        };
        Runnable updateMapData = () -> {
            for (int i = 0; i < MAX_SIZE; i++) {
                concurrentMap.put(String.valueOf(i), i);
            }
        };
        executorService.execute(updateMapData);
        executorService.execute(collectMapSizes);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(mapSizes.get(MAX_SIZE - 1));         // 7865，这个值不固定
        System.out.println(concurrentMap.mappingCount());       // 100000
    }

}
