package cn.bravedawn;

import redis.clients.jedis.Jedis;

/**
 * @author : depers
 * @program : jedis-demo
 * @date : Created in 2024/3/23 22:37
 */
public class JedisExample {


    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set()
    }
}
