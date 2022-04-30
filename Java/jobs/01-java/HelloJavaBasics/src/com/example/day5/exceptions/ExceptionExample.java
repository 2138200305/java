package com.example.day5.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * All exceptions are thrown at runtime.
 * 
 * Checked vs unchecked:
 * 	checked exceptions need to have a try/catch OR they need to be ducked.
 * 	unchecked exceptions could have a try/catch OR be ducked...but they could
 * 		also not have anything. No syntax error will return in either case.
 * 
 *  Who does the checking? The compiler.
 */
public class ExceptionExample {

	public static void main(String[] args) throws Throwable {
		Object obj = new Object();
		//throw obj; //can only throw a class (or child class) of type "Throwable".

		Exception myException= new IOException();
		
		try {
			throw myException;
		}
		catch(Exception myObj) {
			//System.out.println("in general block");
			myObj.printStackTrace();
		}
		/*catch (IOException e) {
		 //unreachable code because a more general catch block is above
			System.out.println("in IO block");
			e.printStackTrace();
		}*/
		
		
		
		
		try{
			throw new Error();
		}catch(Error myError) {
			//print this issue to a text file
			System.out.println("in error catch");
			//we can TOTALLY catch an error, but we can't recover from it
		}catch(Throwable t) {
			//we can also catch throwable
		}
		
		
		
		
		//to demonstrate ducking AND a ducking main method
		//myDuckingMethod();
		
		//null pointer exception
		/*int[] i=null;
		System.out.println(i.length);*/
		
		System.out.println("done");
	}

	static void myDuckingMethod() throws IOException, FileNotFoundException, Exception {
		///this is how you duck...with the "throws" keyword
			throw new IOException();
		
	}
}
