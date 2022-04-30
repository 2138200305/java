package com.example.day2.flowcontrol;

public class FlowControlExample {

	
	/*
	 * What is flow control?
	 * 	Controlling the order in which your lines of code will be read.
	 * 
	 * 	Examples:
	 * 	switches, if-else, loops, try-catch-finally
	 * 
	 * you don't need curly braces after if, else if, else, switch
	 *    while, for loop, etc
	 *    IF there is only 1 line of code after
	 */
	public static void main(String[] args) {
		int i= -35;
		
		//our condition must equate to a true/false value
		// && and || are short circuit operators, if java decides it is
		//		impossible for the condition to change from true to false
		//		OR false to true, then it will stop evaluating.
		//& and | will ALWAYS evaluate both sides.
		if(i<=0 || methodTrue()) { //if(condition) {then execute this code}
			System.out.println("in if-block");
		}else if(i==12){
			System.out.println("in else-if-block");
		}else {
			
			System.out.println("in else-block");
		}
		
		System.out.println("done");
	}
	
	public static boolean methodTrue() {
		System.out.println("in true method()");
		return true;
	}

}
