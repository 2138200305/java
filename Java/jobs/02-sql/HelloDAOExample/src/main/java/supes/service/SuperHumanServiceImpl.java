package supes.service;

import java.util.List;

import supes.dao.SuperHumanDao;
import supes.dao.SuperHumanDaoImpl;
import supes.model.SuperHuman;

public class SuperHumanServiceImpl implements SuperHumanService {

	private SuperHumanDao supeDao = new SuperHumanDaoImpl();
	
	@Override
	public List<SuperHuman> getAllSuperHumans() {
		//any business logic goes here
		return supeDao.selectAllSuperHumans();
	}

	@Override
	public SuperHuman getSuperHuman(String name) {
		//any business logic goes here
		return supeDao.selectSuperHumanByName(name);
	}

	@Override
	public boolean checkUsernameAndPassword(String u, String p) {
		//any business logic goes here
		return false; //your business logic will determine true or false
	}

	@Override
	public void triggerJoinPrint(String name) {
		//any business logic goes here
		supeDao.joinExamplePrint(name);
		//more business logic goes here
	}

}
