package com.example.demo.daoImpl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ProgrammerDao;

@Repository
public class ProgrammerDaoImpl implements ProgrammerDao{

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
 
		redisTemplate.opsForValue().set(idKey, programmer);
		//redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);
	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return (String) redisTemplate.opsForValue().get(idKey);
	}

}
