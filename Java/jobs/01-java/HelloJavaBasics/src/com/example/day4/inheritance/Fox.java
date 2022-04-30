package com.example.day4.inheritance;

public class Fox extends Animal{
	int numOfTails;
	String color="orange"; //this variable has been shadowed. aka shadowing
	
	Fox(){
		//System.out.println();
		//super();
		this("stuff"); //first line can be super() OR this()
		//System.out.println("in fox no arg constructor");
	}
	
	Fox(String s){
		//this();
		//super()
		//System.out.println("in fox one arg constructor");
	}
	
	void checkColorFox() {
		System.out.println("checkColorFox: "+this.color);
	}
	
	@Deprecated //this is a note to the developer that there is no continued support
	void checkColorParent() {
		System.out.println("checkColorParent: "+super.color);
	}
	
	@Override  //this is an annotation
	void speak() {
		System.out.println("yipyipyipyipyipyip~!");
		//super.speak(); //you CAN still access the parent's original method
	}
	
	@Override
	String mySound() {
		//Covariant return types. Changing the return type of an overridden method.
		//There is covariance in return types, exceptions thrown, and access
		// modifiers
		return "Animal sound";
	}
	
	//you're able to shadow a static variable
	static int myStaticVariable=9;
	/*@Override
	static void myStaticMethod() {
		//cannot override a static method
	}*/
}
