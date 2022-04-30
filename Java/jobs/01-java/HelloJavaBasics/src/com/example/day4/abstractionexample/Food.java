package com.example.day4.abstractionexample;

public abstract class Food {
	//private abstract String color; //no abstract variables
	private String name;
	int calories;
	
	public /*abstract*/ Food() {
		super();
		calories=15;
	}
	
	
	abstract void goBad();
	//abstract void initializeCalories();
	
	void heatUp(int degrees) {
		System.out.println("dunk");
		System.out.println();
	}
}
