package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProgrammerDao;
import com.example.demo.model.Programmer;
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

	@Override
	public void AddToProgrammersList(Programmer programmer) {
		programmerDao.AddToProgrammersList(programmer);
	}

	@Override
	public List<Programmer> getProgrammersListMembers() {
 		return programmerDao.getProgrammersListMembers();
	}

	@Override
	public Long getProgrammersListCount() {
 		return programmerDao.getProgrammersListCount();
	}

	@Override
	public void AddToProgrammersSet(Programmer... programmers) {
		programmerDao.AddToProgrammersSet(programmers);
	}

	@Override
	public Set<Programmer> getProgrammersSetMembers() {
		return programmerDao.getProgrammersSetMembers();
	}

	@Override
	public boolean isSetMember(Programmer programmer) {
 		return programmerDao.isSetMember(programmer);
	}

	@Override
	public void savePHash(Programmer programmer) {
		programmerDao.saveHash(programmer);
	}

	@Override
	public void updatePHash(Programmer programmer) {
		programmerDao.updateHash(programmer);
	}

	@Override
	public Map<Integer, Programmer> findAllPHash() {
		return programmerDao.findAllHash();
	}

	@Override
	public Programmer findPInHash(int id) {
 		return programmerDao.findInHash(id);
	}

	@Override
	public void deletePhash(int id) {
		programmerDao.deleteHash(id);
	}

}
