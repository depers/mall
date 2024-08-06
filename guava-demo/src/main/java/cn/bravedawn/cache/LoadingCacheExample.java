package cn.bravedawn.cache;

import cn.hutool.json.JSONUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : depers
 * @program : guava-demo
 * @date : Created in 2024/8/1 10:40
 */

@Slf4j
public class LoadingCacheExample {

    private static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                //最大容量为100（基于容量进行回收）
                .maximumSize(100)
                //配置写入后多久使缓存过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                //配置写入后多久刷新缓存
                .refreshAfterWrite(30, TimeUnit.SECONDS)
                //key使用弱引用-WeakReference
                .weakKeys()
                //当Entry被移除时的监听器
                .removalListener(notification -> log.info("notification={}", JSONUtil.toJsonStr(notification)))
                //创建一个CacheLoader，重写load方法，以实现"当get时缓存不存在，则load，放到缓存，并返回"的效果
                .build(CacheLoader.asyncReloading(new CacheLoader<String, String>() {
                    //重点，自动写缓存数据的方法，必须要实现
                    @Override
                    public String load(String key) throws Exception {
                        log.info("从数据库中获取数据");
                        return "value_" + key + integer.incrementAndGet();
                    }
                    //异步刷新缓存-下文会讲述
                    @Override
                    public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                        log.info("异步查询数据");
                        return super.reload(key, oldValue);
                    }
                }, new ThreadPoolExecutor(5, Integer.MAX_VALUE,
                        60L, TimeUnit.SECONDS,
                        new SynchronousQueue<>())));



        loadingCache.put("hello", "world");

        for (int i = 0; i < 100; i++) {

            log.info("从缓存中读取信息：{}", loadingCache.get("hello"));
            Thread.sleep(10000);

        }
    }
}
