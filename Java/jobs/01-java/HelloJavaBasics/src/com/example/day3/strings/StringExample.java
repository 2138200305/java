package com.example.day3.strings;
/*
 * What is a String?
 * 		A class that is implemented using an array of chars;
 * 		(basically, it is an array of chars with functionality)
 * 	A string is immutable.
 * 
 * What in the blue blazes is immutable?
 * 	It means it cannot be changed
 */
public class StringExample {

	public static void main(String[] args) {
		//how can we create a string?
		String s= "Hello World";
		String s2= new String("Hello World");
		
		s= s.concat("!!! :)");
		s=s.substring(4, 12);
		
		//System.out.println(s);
		
		String s3= "sifioj" + "hello";
		
		//the MUTABLE counterparts to a String
		
		//stringbuilder, NOT thread safe
		StringBuilder sb= new StringBuilder("Hello =)");
		sb.append(" World");
		//System.out.println(sb);
		
		//stringbuffer, thread safe
		StringBuffer sbuff = new StringBuffer("Hello from");
		sbuff.append(" the other siiiiiiiiide~!");
		//System.out.println(sbuff);
		
		int[] istuff= {36};
		//System.out.println(istuff);
		
		
		
		
		
		
		
		
		
		//string pool proof
		String tempString= "monkey";
		String tempString2= new String("monkey");
		
		if( tempString == new String("monkey") ) {
			System.out.println("in the if block");
		}
		if(tempString.equals(tempString2)  /* == tempString2*/) {
			System.out.println("SECOND if block");
		}
		
		Object obj= new Object();
		//System.out.println(obj);
		
		System.out.println("done");
	}

}
