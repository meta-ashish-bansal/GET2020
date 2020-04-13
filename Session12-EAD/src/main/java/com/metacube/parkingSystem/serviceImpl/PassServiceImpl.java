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
		passDao.save(pass);
		return pass.getPassId();
	}

	@Transactional
	public Pass getPass(int vehicleId) {

		return passDao.findPassByVehicleId(vehicleId);
	}

	@Transactional
	public boolean updatePass(Pass pass) {
		try {
			passDao.save(pass);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
