package com.example.day3.methods;

public class MethodExample {

	public static void main(String[] args) {
		//A BUNCH OF LOGIC BEFORE
		
		
		/*num=num+2;
		num= num/3*1.25;
		System.out.println(num);
		num=num+2;
		num= num/3*1.25;
		System.out.println(num);
		num=num+2;
		num= num/3*1.25;
		System.out.println(num);*/
		//duplicated 76 more times....
		
		double num=2;
		num= method1(num);
		num= method1(num);
		num= method1(num);
		
		//A BUNCH OF LOGIC AFTER

	}
	
	public static double method1(double num) {
		num=num+2;
		num= num/3*1.25;
		System.out.println(num);
		return num;
	}
	
	/*The method signature:
	 * 
	 * 	[modifier(s)]	[return type]	[method name]	( [parameter list])
	 *  {
	 * 		//our logic
	 *  }
	 *  
	 *  parameter vs argument?
	 *  	parameter is in the method declaration; the allowable variables.
	 *  	argument are passed when the method is invoked; they are the
	 *  		current values when the method is invoked. 
	 * 
	 * modifiers can be keywords like: public, protected, private, static,
	 * 		final, default, synchronized, transient, abstract, etc
	 */
}
