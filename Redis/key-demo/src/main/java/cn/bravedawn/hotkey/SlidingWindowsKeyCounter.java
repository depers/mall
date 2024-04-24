package cn.bravedawn.hotkey;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : depers
 * @program : key-demo
 * @date : Created in 2024/4/11 15:12
 *
 * 基于滑动窗口算法的热key统计算法
 */
public class SlidingWindowsKeyCounter {

    // 记录所有Key统计信息的Map
    private static final ConcurrentHashMap<String, Queue<Long>> HOT_KEY_MAP = new ConcurrentHashMap<String, Queue<Long>>();
    private long windowsDuration; // 统计的时间窗口，单位毫秒
    private long threshold; // 统计阈值

    public SlidingWindowsKeyCounter(long windowsDuration, long threshold) {
        this.windowsDuration = windowsDuration;
        this.threshold = threshold;
    }

    public void countKey(String key) {
        long currentTime = System.currentTimeMillis();
        Queue<Long> timeStamps = HOT_KEY_MAP.get(key);

        while (!timeStamps.isEmpty() && currentTime - timeStamps.peek() > windowsDuration) {
            timeStamps.poll();
        }

        if (timeStamps.size() > threshold) {
            // 记录到数据库或是发送交易到别的系统
        } else {
            timeStamps.offer(System.currentTimeMillis());
        }
    }
}
