package com.kuang;

import redis.clients.jedis.Jedis;

public class TestPing {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //测试连接
        System.out.println(jedis.ping());
        //常用的API, 和linux下一致
        //String, List, Set, Hash, Zset
        jedis.flushAll();
        jedis.set("name","wangli");
        System.out.println(jedis.get("name"));
    }

}
