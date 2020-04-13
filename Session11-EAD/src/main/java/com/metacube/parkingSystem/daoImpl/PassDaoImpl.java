package com.metacube.parkingSystem.daoImpl;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.PassDao;
import com.metacube.parkingSystem.model.Pass;

@Repository
public class PassDaoImpl implements PassDao {

	@Autowired
	private EntityManager entityManager;


	@Override
	public int addPass(Pass pass) {
		int passId = -1;
		Session session = entityManager.unwrap(Session.class);
		session.save(pass);
		passId = pass.getPassId();
		return passId;
	}





	public Pass getPass(int vehicleId) {
		Pass pass = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			Query<Pass> query = session.createQuery("from Pass where vehicle_vehicleID= :vehicleId", Pass.class);
			query.setParameter("vehicleId", vehicleId);
			pass = query.getSingleResult();
			return pass;
		}
		catch(Exception e) {
			return pass;
		}
	}






	public boolean updatePass(Pass pass) {
		boolean update = false;
		Session session = entityManager.unwrap(Session.class);
		try {
			session.clear();
			session.update(pass);
			update = true;
			return update;
		}
		catch(Exception e) {
			return update;
		}

	}



}
