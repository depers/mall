package cn.bravedawn.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @author : depers
 * @program : guava-demo
 * @date : Created in 2024/8/1 14:19
 */
public class CacheExample {

    @Data
    static class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    private static Cache<String, Object> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .weakKeys()
            .build();


    public static void main(String[] args) throws InterruptedException {
        User user = new User("fengxiao", 12);
        User user2 = new User("liming", 18);

        Thread a = new Thread(() -> cache.put("a", user));

        Thread b = new Thread(() -> {
            System.out.println(cache.getIfPresent("a"));
            cache.put("a", user2);
        });

        a.start();
        System.out.println("a线程执行完成");
        Thread.sleep(40000);
        System.gc();
        System.out.println(cache.asMap());

        b.start();
        System.out.println("b线程执行完成");
        Thread.sleep(20000);
        System.gc();
        System.out.println(cache.asMap());

        cache.put("a", user2);
        System.out.println("主线程执行完成");
        Thread.sleep(20000);
        System.gc();
        System.out.println(cache.asMap());

    }
}
