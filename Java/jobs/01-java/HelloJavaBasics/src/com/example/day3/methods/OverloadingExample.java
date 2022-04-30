package com.example.day3.methods;
/*
 * Overloading is when you have multiple methods with the same name, but
 * 	different parameter lists.
 * There are three ways to change the parameter list:
 * 		-change the data types
 * 		-change the number of parameters
 * 		-change the order of parameters
 */
public class OverloadingExample {

	public static void main(String[] args) {
		//methodOne('c',77,77);
		
		//I have to do this if I don't have a static method
		OverloadingExample oload=new OverloadingExample();
		oload.methodOne();
	}

	void methodOne() {
		System.out.println("there are no parameters");
	}
	
	static void methodOne(int i) {
		System.out.println("an int parameter");
	}
	
	static void methodOne(int i, char c) {
		System.out.println("int param and char param");
	}
	static void methodOne(int i, int c) {
		System.out.println("int param and int param");
	}
	
	static void methodOne(char i, int c) {
		System.out.println("char param and int param");
	}
	
	//var args
	static void methodOne(char c, int... i) {
		System.out.println("in the var args method");
		
		for(int myTemp: i) {
			System.out.println(myTemp);
		}
	}
	
	
	/*static void methodOne(char temp1, int temp2) {
		//changing the variable names is NOT enough to overload
		System.out.println("char param and int param");
	}*/
	
	/*static int methodOne() {
	    //Simply changing the return type is NOT enough to overload
	     // because there will still be ambiguity.
		System.out.println("there are no parameters");
		return 0;
	}*/
	
	
	
	
	
	
	
	
	
	
	/*public void drawRectangle(int x, int y, int height, int width) {}
	public void drawRectangle(int x, int y, int height,
			int width, double transparent) {}
	public void drawRectangleTransparentBackground(int x, int y, int height,
			int width, double transparent, Image bg) {}*/
		
}
