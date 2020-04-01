package com.metacube.parkingSystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.PassDao;
import com.metacube.parkingSystem.model.Pass;
import com.metacube.parkingSystem.service.PassService;

@Service
public class PassServiceImpl implements PassService {

	@Autowired
	private PassDao passDao;

	public int addPass(Pass pass) {
		return passDao.addPass(pass);

	}

	public Pass getPass(int vehicleId) {
	
		return passDao.getPass(vehicleId);
	}

	public boolean updatePass(int passId, Pass pass) {

		return passDao.updatePass(passId, pass);
	}
}
