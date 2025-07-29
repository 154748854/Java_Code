import javafx.beans.property.SetProperty;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.security.Key;
import java.util.Set;

public class RedisDemo {

    public static void test1(Jedis jedis) {
        System.out.println("get 和 set的使用");
        // 先清空数据库
        jedis.flushAll();

//        jedis.set("key", "111");
        jedis.set("key2", "222");
        SetParams params = new SetParams();
        params.ex(10);
        params.xx();
        jedis.set("key","333",params);

        String value = jedis.get("key");
        System.out.println("value: "+value);
    }

    public static void test2(Jedis jedis) {
        System.out.println("exists 和 del");
        jedis.flushAll();

        jedis.set("key", "111");
        jedis.set("key2", "222");

        boolean value = jedis.exists("key");
        System.out.println(value);

        System.out.println(jedis.del("key2"));

        System.out.println(jedis.exists("key2"));
    }

    public static void test3(Jedis jedis) {
        System.out.println("keys");
        jedis.flushAll();

        jedis.set("key", "111");
        jedis.set("key2", "222");
        jedis.set("key3", "333");
        jedis.set("key4", "444");

        Set<String> result = jedis.keys("*");
        System.out.println(result);
    }

    public static void test4(Jedis jedis) {
        System.out.println("expire  ttl");
        jedis.flushAll();

        jedis.set("key", "111");
        jedis.expire("key",10);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long key = jedis.ttl("key");

        System.out.println(key);
    }


    public static void test5(Jedis jedis) {
        System.out.println("type");
        jedis.flushAll();

        jedis.set("key","111");
        String type = jedis.type("key");
        System.out.println(type);

        jedis.rpush("key2","111","222","333");
        type = jedis.type("key2");
        System.out.println(type);

        jedis.hset("key3","f1","111");
        type = jedis.type("key3");
        System.out.println(type);

        jedis.sadd("key4","111","222");
        type = jedis.type("key4");
        System.out.println(type);

    }


    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("tcp://127.0.0.1:8888");

        try (Jedis jedis = jedisPool.getResource()) {
            // redis 的各种命令就对应到jedis当中的各种方法
//            String pong = jedis.ping();
//            System.out.println(pong);

            test5(jedis);
        }


    }
}
