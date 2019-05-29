package com.example.demo.daoImpl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ProgrammerDao;
import com.example.demo.model.Programmer;

@Repository
public class ProgrammerDaoImpl implements ProgrammerDao{

	public static final String REDIS_LIST_KEY = "ProgrammerList";
	public static final String REDIS_SET_KEY  = "ProgrammerSET";
	public static final String REDIS_HASH_KEY = "ProgrammerHash";
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	@Qualifier("listOperations")
	private ListOperations<String, Programmer> ListOps;
	
	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		redisTemplate.opsForValue().set(idKey, programmer);
		//redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);
	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return (String) redisTemplate.opsForValue().get(idKey);
	}

	@Override
	public void AddToProgrammersList(Programmer programmer) {
		ListOps.leftPush(REDIS_LIST_KEY, programmer);
	}

	@Override
	public List<Programmer> getProgrammersListMembers() {
 		return ListOps.range(REDIS_LIST_KEY, 0, -1);
	}

	@Override
	public Long getProgrammersListCount() {
 		return ListOps.size(REDIS_LIST_KEY);
	}

}
