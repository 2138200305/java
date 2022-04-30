package com.example.day2.sysout;

public class SystemOutExample {
	public static void main(String[] stuff) {
		//System.out.println("adds a new line character at the end"); //println()
		//System.out.print("no new line character at the end"); //print()
		//System.out.println("ENDLINE?");
		
		//The String class is a psuedo primitive. Not officially
		//	but unofficially.
		String s1= "i am a string class";
		
		//escape characters
		//include:	\n    is newline
		//			\t    is tab
		//			\"		is the character " , not the end of the string
		//				etc, there are more
		//System.out.print("li\tne1\n");
		//System.out.print("line2\nline3");
		
		System.out.println(88+2);
		System.out.println('g'+1);
		System.out.println(88+2+"oh no!"+7+3);
	}
}
