package com.example.day6.threading;

public class ThreadingExample {

	public static void main(String[] args) throws InterruptedException {
		//How do we create a thread in java?
		Thread th = new Thread();
		
		//this is how we grab the reference to the current thread we're in
		Thread mainThread =  Thread.currentThread();
		
		boolean isDaemon = mainThread.isDaemon();
		System.out.println(isDaemon);
		
		mainThread.sleep(3000);
		
		String name=mainThread.getName();
		System.out.println("This thread's name is: "+name);

	}

}
