package supes;

import java.util.List;

import supes.model.SuperHuman;
import supes.service.SuperHumanService;
import supes.service.SuperHumanServiceImpl;

public class MainDriver {

	public static void main(String[] args) {
		SuperHumanService shService = new SuperHumanServiceImpl();
		
		List<SuperHuman> supes = shService.getAllSuperHumans();
		
		System.out.println("PRINTING ALL SUPERHUMANS");
		for(SuperHuman s: supes) {
			System.out.println(s);
		}
		
		System.out.println("PRINTING A SINGLE SUPERHUMAN");
		System.out.println(shService.getSuperHuman("Asura"));
		
		System.out.println("PRINTING A SINGLE SUPERHUMAN WITH THEIR POWERS");
		shService.triggerJoinPrint("Danny Boy");
		
	}

}
