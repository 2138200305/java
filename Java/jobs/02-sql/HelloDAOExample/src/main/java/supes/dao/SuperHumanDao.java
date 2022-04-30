package supes.dao;

import java.util.List;

import supes.model.SuperHuman;

public interface SuperHumanDao {
	//CRUD METHODS ONLY
	
	//CREATE
	public int insertSuperHuman(SuperHuman sh);
	//READ
	public List<SuperHuman> selectAllSuperHumans();
	public SuperHuman selectSuperHumanById(int id);
	public SuperHuman selectSuperHumanByName(String name);
	public List<SuperHuman> selectSuperHumansByBounty(int bounty);
	//UPDATE
	public int updateSuperHuman(SuperHuman sh);
	//DELETE
	public int deleteSuperHuman(SuperHuman sh);
	
	
	//DEMO OF A INNER JOIN
	public void joinExamplePrint(String name);
}
