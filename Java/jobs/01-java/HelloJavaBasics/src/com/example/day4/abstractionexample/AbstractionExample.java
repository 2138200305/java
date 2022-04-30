package com.example.day4.abstractionexample;
/*
 * What is abstraction?
 * 		What something does, not how it does it.
 * 
 * Abstract classes and Concrete classes have more similarities than they have
 *  differences. Some of the differences include:
 *  		-Abstract Classes cannot be instantiated
 *  		-Abstract classes can have abstract methods
 *  		-An abstract method MUST be overridden
 *  	Beyond these differences, the inheritance works the same
 *  
 *  Differences between abstract classes and interfaces:
 *  	interface					abstract classes
 *  --------------				--------------------
 *  implements keyword					extends keyword
 *  many can be implemented		only one can be extended
 *  no constructor					may have a constructor
 *  variables implicitly:			no implicit modifiers
 *  	-public static final		
 *  methods implicitly:
 *  	-public abstract
 *  abstract methods				abstract AND concrete methods
 *  
 *  ..........that is of course...until java 8 ruined my life
 *  The default keyword now allows interfaces to have concrete implementation
 *  
 *  why would we use one over the other?
 *  	PRO ac: can provide concrete implementation (including methods and instance
 *  		variables)
 *  	PRO ac: constructor
 *  	PRO i: can implements multiple interfaces without taking up the ONE
 *  		spot you have to extend a class
 */
public class AbstractionExample {

	public static void main(String[] args) {
		// you cannot instantiate an abstract class
		//Food f= new Food();
		Food f= new Pizza();
		Chicken chick= new Chicken();
		//chick.  //operates exactly like normal inheritance
		
		//you cannot instantiate an interface
		//Chewable chew= new Chewable();
		
		Pizza piz= new Pizza();
		piz.myDefaultMethod();// you may use the default implementation
		Chewable.myStaticMethod();//accessing the interface's static method
				//in a static way
	}

}
