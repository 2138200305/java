package com.example.day3.classes;
//this is a class
// a blueprint for an object
public class Animal {
	// how do we give a class state?
	int speed= 15;
	String color="blue";
	boolean isAlive=true;
	
	//how do we give an object behavior?
	void walkFaster() {
		speed+= 5;
	}
	
	void setMortality() {
		isAlive= !isAlive;
	}
}
