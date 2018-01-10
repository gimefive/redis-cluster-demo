package com.gimefive.redisdemo.test;

import com.gimefive.redisdemo.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-cache.xml"}) //加载配置文件
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@Transactional
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//------------
public class RedisTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    JedisCluster jedisCluster;

    @Test
    public void get() throws IOException {
//        byte[] bytes = "name".getBytes();
//        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
//            @Override
//            public byte[] doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                return redisConnection.get(bytes);
//            }
//        });
//        System.out.println(new String(result));
//        System.out.println(redisTemplate.opsForValue().get("name"));
//        Object object = redisTemplate.opsForValue().get("name");
//        Object object1 = redisTemplate.opsForHash().get("myhash", "name");
//        System.out.println(object);
//        System.out.println(object1);
//        redisTemplate.opsForValue().set("stringRedis1", "hello");
//        System.out.println(redisTemplate.opsForValue().get("stringRedis1"));
//        redisTemplate.delete("stringRedis");
//        redisTemplate.delete("stringRedis1");
//        System.out.println(redisTemplate.opsForValue().get("stringRedis"));
//        System.out.println(redisTemplate.opsForValue().get("stringRedis1"));

//        System.out.println(redisUtil.get("name"));
//        Object object = redisUtil.get("name");
//        Object object1 = redisUtil.hget("myhash", "name");
//        System.out.println(object);
//        System.out.println(object1);
//        redisUtil.set("stringRedis1", "hello");
//        System.out.println(redisUtil.get("stringRedis1"));
//        redisUtil.delete("stringRedis");
//        redisUtil.delete("stringRedis1");
//        System.out.println(redisUtil.get("stringRedis"));
//        System.out.println(redisUtil.get("stringRedis1"));
        redisUtil.set("close", "hahaha");
        System.out.println(redisUtil.get("close"));
        redisUtil.hset("seri", "key", "value");
        System.out.println(redisUtil.hget("seri", "key"));

        Set<String> set = stringRedisTemplate.keys("*");
        Iterator<String> iterator = set.iterator();
        String key;

        while (iterator.hasNext()) {
            key = iterator.next();
            System.out.println("key:" + key + " ---value: " + redisUtil.get(""));
        }
        System.in.read();
    }

    @Test
    public void testJedisCluster() {
        System.out.println(jedisCluster.set("test", "test"));
        System.out.println(jedisCluster.get("test"));
        System.out.println(jedisCluster.get("name"));
        System.out.println(jedisCluster.get("age"));
        System.out.println(jedisCluster.get("haha"));
        System.out.println(jedisCluster.get("haha"));
    }
}
