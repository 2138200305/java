package com.example.day4.wrapper;
/*
 * What is a wrapper class?
 * 	It wraps "stuff" like presents. AKA it is a class that wraps a primitive
 *  types into reference objects.
 *  
 * Each primitive data type has a wrapper class counterpart:
 * 		int			Integer
 * 		double		Double
 * 		float		Float
 * 		char		Character
 * 		boolean		Boolean
 * 		byte		Byte
 * 		short		Short
 * 		long		Long
 */
public class WrapperExample {

	public static void main(String[] args) {
		Integer i = new Integer(5);
		Character c = new Character('t');
		Boolean bool = new Boolean(false);
		
		//each wrapper has many static utility methods
		int temp = Integer.parseInt("678");
		
		//will this print a memory address? or the value we're expecting?
		System.out.println(i);
		
		//will this work?
		Integer myInt= 68;  //autoboxing
		Character myChar= 't';//autoboxing
		
		int newPrimInt= new Integer(5); //unboxing
		boolean myPrimBool= new Boolean("false"); 

	}

}
