package com.example.day6.threading;
/*
 *  To create a custom thread we must first create a class that extends the 
 *  Thread class; in our custom thread we must now override the run() method;
 *  then instantiate our object and call the start() method.
 *  
 *  BUT...there is another.....
 *  
 *  To create a custom thread we can ALSO create a class that implements Runnable
 *  interface; in our custom thread we must now override the run() method;
 *  then instantiate our object; THEN create a new generic Thread class, and
 *  pass our custom Class into the constructor of the generic Thread class.
 *  Finally, call the .start() method on the generic Thread class.
 *  
 *  
 * PROS AND CONS OF EACH METHOD OF CREATING A CUSTOM THREAD:
 * 
 *  Pros of extending:
 *  	Less lines of code to "start" the thread.
 *  	Far easier to override the functionality of the Thread class when extending.
 *  
 *  Pros of implementing:
 *  	You do NOT use up the one slot you have to extend another class
 *  	Lightweight, meaning you don't have to include unwanted methods/variables
 */
public class CustomThreadExample {

	public static void main(String[] args) {
		//creating and launching a custom thread, by extending thread class
		MyThread myThread = new MyThread();
		
		//The run method will NOT create a separate thread (no multithreading)
		// it will simply...call a method in the CURRENT thread
		//myThread.run();
		
		//The start method will FIRST create a separate thread (multithreading)
		// it will then call the run method inside that newly created process
		myThread.start();
		
		MyRunnable myRun = new MyRunnable();
		
		Thread normalThread =new Thread(myRun);
		normalThread.start();
		
		for(int i=0; i<40; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
