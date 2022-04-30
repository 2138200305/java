package com.example.day4.abstractionexample;
/*
 * An interface is a contract; it forces any implement classes
 * to implement its methods
 * 
 * If you're wondering whether to use an abstract class or an interface,
 * 	ask yourself "am I defining that entire base structure for the series of
 *  classes (abstract class)? OR am I simply requiring a series of class to have
 *  some ADDITIONAL functionality (interface)?
 * 
 */
public /*abstract*/ interface Chewable extends MadeOfMatter, Edible{
		/*public  Chewable() {
			//interfaces cannot have constructors.
		}*/
	
		public static final int myVari= 75; //the implicit nature of variables
			//inside of an interface: public, static, and final
	
		abstract void chewableMethod(); //the implicit nature of methods
			//inside of an interface: public and abstract
		
		
		void method1(); //you can have a class implement TWO different interfaces
			//with each interface asking the class to implement "method1()"
		
		//can I have a concrete implementation inside of an interface?
		
		public static void myStaticMethod() {
			//you CAN, but it must be static
		}
		
		default void myDefaultMethod() {
			//default is a modifier that allows you to have a CONCRETE implementation
			// for a method while inside of an interface
		}
}
