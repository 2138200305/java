package com.example.day3.classes;

/*
 * What is....a class?
 * 		A blueprint for an object.
 * What is.....an object?
 * 		An instance of a class. A group of states(variables) and
 * 		behaviors(methods).
 * 
 * Naming conventions in java:
 * 		variable names:
 * 			camel case.  e.g. myFirstName, myLastName
 * 		class names:
 * 			title case. e.g. Animal, UserStory, ButtonColors
 * 			nouns
 * 		interface names:
 * 			title case. e.g. Runnable, Comparable
 * 			adjectives
 * 		method names:
 * 			camel case. e.g. drawRectangle, run
 * 			verbs
 * 		package names:
 * 			lowercase.		e.g. java, lang, sql, util, etc
 * 		constants:
 * 			uppercase (separated by underscore)
 * 				e.g. RED, YELLOW, MAX_PRIORITY,etc
 */
public class ClassExample {

	public static void main(String[] args) {
		//what is the simplest way to create an animal object
		new Animal();
		Animal an; //ONLY creates a reference to an object, the object isn't created
		
		//what is the difference between initializing and instantiating?
		
		int i= 8; //initializing
		Animal ani= new Animal(); //instantiating
		
		//what is a constructor?
		//a special method that constructs instances of classes
		//e.g. Car myCar= new Car("mercedes");
		
		Car civic= new Car("Cosmic Blue", "Civic");
		civic.MTVsPrintMyCar();
		civic.color="crimson red";
		civic.MTVsPrintMyCar();
		
		Car nissan= new Car("Red", "Nissan");
		nissan.color="green";
		nissan.MTVsPrintMyCar();
		
		System.out.println("civic: "+Car.numOfCarsCreated);
		System.out.println("nissan: "+Car.numOfCarsCreated);
	}

}






