import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class RedisDemoList {


    public static void test(Jedis jedis) {
        System.out.println("blpop");
        jedis.flushAll();

        List<String> results = jedis.blpop(100, "key");
        System.out.println(results.get(0));
        System.out.println(results.get(1));
    }
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("tcp://127.0.0.1:8888");

        try (Jedis jedis = jedisPool.getResource()) {
            // redis 的各种命令就对应到jedis当中的各种方法
//            String pong = jedis.ping();
//            System.out.println(pong);

            test(jedis);
        }

    }
}
