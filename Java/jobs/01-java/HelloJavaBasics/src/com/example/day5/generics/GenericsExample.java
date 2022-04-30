package com.example.day5.generics;

import java.io.Serializable;

/*What is/are "Generics"?
 * Generics use angle brackets to create a "placeholder" for a future datatype.
 *  When instantiating a generic object you must provide the datatype, from
 *  that point that SPECIFIC object will always be the specified datatype. But
 *  other instances from the same generic class can represent other specified
 *  datatypes (each individual object will have its own generic type, and cannot
 *  be changed once set).
 * 
 * angle brackets= hard brackets = diamond brackets= chevrons =
 * 		greater and less than sign 
 */
class GenericClass<BunnyWabbit /*extends Serializable*/ /*, DuckSeasonFire*/>{
	private BunnyWabbit value;
	//private DuckSeasonFire otherValue;
	
	public GenericClass(BunnyWabbit value) {
		this.value= value;
	}
	
	public BunnyWabbit getValue() {
		return value;
	}
}
/*
 * WE CAN USE GENERICS IN A FEW OTHER TYPES OF WAYS:
 * 
 * 	YOu're able to use generics with methods:
 * 		public static <T> void method1( T myVariable) { T.toString(); }
 * 		//the argument you give the method will determine what T will be
 * 
 *  YOu're able to use generics like:
 *  	public final <T,J> void method1(T myVar, J myOtherVar) { blah blah blah}
 *   OR
 *   	public final <T> void method1(T myVar, int myOtherVar) { blah blah blah}
 *   OR
 *   	public final <first, second> void method1(blah blah......
 *   
 *   YOu're able able to...
 *   	private static <T extends Runnable> void method2(T myVar) { }
 *   OR
 *     private static <T extends Runnable> void method2(T... myVar) { }
 * 
 * 
 */




public class GenericsExample {

	public static void main(String[] args) {
		GenericClass<String> firstExample = new GenericClass<String>("hello");
		GenericClass<Object> secondExample = new GenericClass<Object>(new Thread());
		
		
		System.out.println(firstExample.getValue() instanceof String);
		System.out.println(secondExample.getValue() instanceof Thread);
		//instance of
		//     SOME_OBJECT  instanceof   SOME_CLASS
		//    it will return true or false

		
		//later versions of java don't force you to type the datatype in both
		// sets of angle brackets
		GenericClass<Character> thirdExample = new GenericClass<>('t');
		
		/*if you don't use the diamond brackets then the generics default
		 *  to the object class. This is NOT good practice, the angle brackets
		 *  offer compile time safety
		 */
		GenericClass fourthExample = new GenericClass<>(88);
		
		System.out.println("default case: ");
		System.out.println(fourthExample.getValue() instanceof Integer);
		
	}
	
	public static <T> void method1(T myVar) {
		System.out.println(myVar);
	}

	
	/*Suppose  we have a class hierarchy:
	 * 				Animal {avgWeight=10; }
	 * 
	 * Monkey		Wolf		Turtle			..and so on
	 * 
	 * each child class has its OWN copy of avgWeight (so the parents 
	 * 			will be shadowed)
	 */
	
	/*void checkWeight(Animal ani) {
		if(ani instanceof Monkey) { //then cast
		}
		else if(ani instanceof Wolf) {}
	}
	void checkWeight(Monkey mon) {}
	void checkWeight(Wolf wo) {}*/
}
