package com.example.day4.finalexample;
/*
 * What does the final keyword do in java?
 *  It will make a variable immutable (cannot be changed) after it
 *  has been declared.
 *  
 *  variable- it's value cannot be altered after declaration
 *  method-   the method cannot be overridden
 *  class-		the class cannot be extended
 */
public /*final*/ class FinalExample {
	//you MUST initialize a final variable
	static final int MAX_NUM=60;
	static final String S= "hello world";
	
	/*public final FinalExample() {
	 *  //you cannot create a final constructor, because we NEVER override a
	 *  //a constructor to begin with
	}*/
	
	public static void main(String[] args) {
		System.out.println(MAX_NUM);
		//MAX_NUM=17;
		
		Double c;
	}
	
	public final void method1(){
	  
	}
	 
	/*public final void method1(int i){
		  //overloading is fine
	}*/
	
	public static final void method2() {
		/*
		 * There is no point in making a final static method BECAUSE
		 * you cannot override a static method to begin with.
		 */
	}
}
