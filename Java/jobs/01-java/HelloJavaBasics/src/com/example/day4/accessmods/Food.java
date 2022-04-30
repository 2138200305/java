package com.example.day4.accessmods;

public class Food {
	private String name= "salmon";
	String color= "gray"; //default access
	protected int calories= 123;
	public boolean cooked= false;
	
	public Food(){
		
	}
	
	protected void cook() {
		System.out.println("in the process of grillin'");
		cooked=true;
		System.out.println(name);
	}
}
