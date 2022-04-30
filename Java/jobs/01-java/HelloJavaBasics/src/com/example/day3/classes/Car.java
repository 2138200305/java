package com.example.day3.classes;
/*Scopes of java:
 * 	static (aka class) - one copy of the variable and/or method
 * 	instance (aka object)-
 * 		each instance(aka object) has a copy of the variables and/or methods
 * 	method-	the variables only exist within the method
 *  block (aka local)- only exists within blocks/curlybraces
 * 
 * 
 * When deciding whether or not to use instance or static scopes...
 *    simply ask yourself "is this information for the collective(class)
 *        or the individual(instance)?
 */
public class Car {
	//these are instance variables
	boolean parked;
	String vin;
	String color;
	String make;
	String model;
	//this is a static variable
	static int numOfCarsCreated;
	
	static class tempClass{
		//you can have a static class ONLY if it is a nested class
	}
	
	/*static {
		vin="14xu8";
		make="Chevy";
	}*/
	
	static void myStaticMethod() {
		//you may access a static variable inside a static method
		//BECAUSE neither of them need to reference a specific instance
		//System.out.println(numOfCarsCreated);
		
		//you may NOT access an instance variable inside of a static
		//method BECAUSE the static method doesn't know which instance
		// to target for your logic
		//System.out.println(color);
	}
	void myInstanceMethod() {
		//you may access an instance variable from inside of an instance method
		//	BECAUSE we're already inside of an object, so just use the current
		//  instance
		System.out.println(color);
		//you may access a static variable from inside of an instance method
		//BECAUSE each object knows where its blueprint is so there is no
		// ambiguity.
		System.out.println(numOfCarsCreated);
		
		int myTemp;
		//System.out.println(myTemp);
		//you will only see the default values for variables if:
		//   it is in static scope, instance scope, or inside of an array
	}
	
	
	/*IF there are NO other constructors....the compiler will create a
	 * 	no args constructor for you.
	 * A default constructor is the constructor given to you by the compiler,
	 * 	NOT any constructor you create
	 */
	
	public Car() {
		//no args constructor
		//this is NOT a default constructor
		System.out.println("in my no args constructor! yay!");
		numOfCarsCreated++;
	}
	public Car(String colorTemp, String modelTemp) {
		//this is an args constructor
		System.out.println("in my two args constructors");
		color=colorTemp;
		model=modelTemp;
		numOfCarsCreated++;
	}
	
	void MTVsPrintMyCar() {
		System.out.println("Make: "+make+ "\tModel: "+model+
					"\tColor: "+color);
	}
}
