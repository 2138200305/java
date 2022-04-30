package com.example.day4.inheritance;

public class Animal {
	boolean isAlive= true;
	int height=10;
	int weight=11;
	String color="blue";
	
	Animal(){
		//System.out.println("in animal no args");
	}
	
	Animal(String s){
		//System.out.println("in animal args constructor");
	}
	
	void speak() {
		System.out.println("Make animal noises!");
	}
	
	void checkColor() {
		System.out.println("checkColorAnimal: "+color);
	}
	
	Object mySound() {
		return "Animal sound";
	}
	
	static int myStaticVariable=4;
	static void myStaticMethod() {
		
	}
}
