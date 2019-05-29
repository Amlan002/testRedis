package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProgrammerDao;
import com.example.demo.service.ProgrammerService;

@Service
public class ProgrammerServiceImpl implements ProgrammerService{

	@Autowired
	ProgrammerDao programmerDao;
	
	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		programmerDao.setProgrammerAsString(idKey,programmer);		
	}

	@Override
	public String getProgrammerAsString(String key) {
		return 	programmerDao.getProgrammerAsString(key);

	}

}
