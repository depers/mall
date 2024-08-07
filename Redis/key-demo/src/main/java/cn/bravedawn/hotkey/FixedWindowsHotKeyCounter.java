package cn.bravedawn.hotkey;

import com.google.common.util.concurrent.AtomicLongMap;

/**
 * @author : depers
 * @program : key-demo
 * @date : Created in 2024/4/11 07:32
 *
 * 基于固定时间窗口的热key统计算法
 */
public class FixedWindowsHotKeyCounter {

    private static final AtomicLongMap<String> HOT_KEY_COUNT_MAP = AtomicLongMap.create(); // 记录统计数据的map
    private long fixedTime; // 固定的时间段，单位毫秒
    private long threshold; // 统计阈值
    private long lastTime;  // 某个key上一次的操作时间


    public FixedWindowsHotKeyCounter(long fixedTime, long threshold) {
        this.fixedTime = fixedTime;
        this.threshold = threshold;
    }

    public void countKey(String key) {
        if (System.currentTimeMillis() - lastTime > fixedTime) {
            HOT_KEY_COUNT_MAP.clear();
            lastTime = System.currentTimeMillis();
        }

        if (HOT_KEY_COUNT_MAP.get(key) > threshold) {
            // 记录到数据库或是发送请求到别的系统
        } else {
            HOT_KEY_COUNT_MAP.incrementAndGet(key);
        }
    }
}
