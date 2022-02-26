package com.kuang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kuang.pojo.User;
import com.kuang.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

	@Autowired
	@Qualifier("myredisTemplate")
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void test1(){
		redisUtil.set("name","kuangshen");
		System.out.println(redisUtil.get("name"));

	}

	@Test
	void contextLoads() {

		//redisTemplete 操作不同的数据类型，api和我们的指令是一样的
		//opsForValue 操作字符串，类似string
		//opsForList 操作List，类似list
		//opsForSet
		//opsForHash
		//opsForZset
		//opsForGeo
		//opsForHypeloglog

		//除了基本的操作，我们常用的方法都可以直接通过redisTemplete操作，比如事务和基本的CRUD

		//获取redis的连接对象
//		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//		connection.flushAll();
//		connection.flushDb();

		redisTemplate.opsForValue().set("mykey","狂神");
		System.out.println(redisTemplate.opsForValue().get("mykey"));

	}

	@Test
	public void test() throws JsonProcessingException {
		//真实开发中一般使用JSON传递数据
		User user = new User("狂神说", 3);
		//序列化
//		String jsonUser = new ObjectMapper().writeValueAsString(user);

		redisTemplate.opsForValue().set("User",user);
		System.out.println(redisTemplate.opsForValue().get("User"));

	}

}
