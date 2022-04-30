package com.example.day4.garbage;

public class TrashExample {

	public static void main(String[] args) {
		Object obj;
		Object obj2 = new Object();
		Object obj3= new Object();
		
		obj= null;
		obj2= null;//eligible
		obj= obj2;
		
		obj=obj3;
		obj3=null;
		
		//how do I call the garbage collector?
		System.gc(); //this does NOT force the garbage collector to clean up
		// it only SUGGESTS to the gc to show up
		
		/*The garbage collector will call the "finalize()" method of any object
		 * it is about to delete JUST before deletion. The finalize() method,
		 * however, is deprecated. Nowadays, we just use a finally block if
		 * we want some last minute logic to fire.
		 * 
		 */
		
	}//eligible, the GC will come here because the method scope ends for
	//the reference variables

}
