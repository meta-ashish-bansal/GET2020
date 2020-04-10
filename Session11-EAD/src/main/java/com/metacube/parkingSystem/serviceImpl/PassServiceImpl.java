package com.metacube.parkingSystem.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.PassDao;
import com.metacube.parkingSystem.model.Pass;
import com.metacube.parkingSystem.service.PassService;

@Service
public class PassServiceImpl implements PassService {

	@Autowired
	private PassDao passDao;

	@Transactional
	public int addPass(Pass pass) {
		return passDao.addPass(pass);

	}

	@Transactional
	public Pass getPass(int vehicleId) {
	
		return passDao.getPass(vehicleId);
	}

	@Transactional
	public boolean updatePass(Pass pass) {

		return passDao.updatePass(pass);
	}
}
