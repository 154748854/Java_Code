import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class RedisDemoString {

    public static void test1(Jedis jedis) {
        System.out.println("mget 和 mset");
        jedis.flushAll();

        jedis.mset("key","111","key2","222");

        List<String> mget = jedis.mget("key", "key2");
        System.out.println(mget);
    }

    public static void test2(Jedis jedis) {
        System.out.println("getrange 和 setrange");
        jedis.flushAll();

        jedis.set("key","abcdefghijklmn");
        System.out.println(jedis.getrange("key", 0, -1));

    }

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("tcp://127.0.0.1:8888");
        try (Jedis jedis = jedisPool.getResource()) {
            test2(jedis);
        }
    }
}
