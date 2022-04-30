package supes.service;

import java.util.List;

import supes.model.SuperHuman;

public interface SuperHumanService {
	public List<SuperHuman> getAllSuperHumans();
	public SuperHuman getSuperHuman(String name);
	
	public boolean checkUsernameAndPassword(String u, String p);

	//JOIN DEMO
	public void triggerJoinPrint(String name);
}
