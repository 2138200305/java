package com.example.day5.exceptions;

public class FinallyExample {

	public static void main(String[] args) {
		
		try {
			//throw new RuntimeException();
			boolean b= false;
			if(b)
				System.out.println();
			else
				System.exit(0);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}finally {
			/*
			 * regardless of the outcome of the try block, the finally will
			 *  run.
			 *  
			 *  There ARE a couple situations where a finally block will not
			 *  run:
			 *  	-if System.exit() is called
			 *  	-if there is some sort of fatal error that prevents it entirely
			 *  		for example, the finally trying to create an object
			 *  		when you simply are out of memory
			 *  	-total system failure	
			 *  
			 */
			System.out.println("\tin the finally block");
			
		}
		System.out.println("\t\tend of main method");

	}

	void presenceOfTryCatchFinally() {
		//can I have a try catch with no finally?
		//			yes
		
		//can I have a try with no catch?
		// yes BUT the try cannot throw and exception at ALL.
		//	AND it must have a finally as well. YOu cannot have a try by itself.
		try {
			System.out.println("stuff");
		}finally {
			
		}
		
		//throwable is checked
		//throw new Throwable();
	}
}





