package com.example.day6.threading;

public class MyThread extends Thread{
	@Override
	public void run() {
		//you don't NEED to override the run method, but the run method
		// is the entry point into your thread's logic; so you probably
		// WANT to.
		
		for(int i=0; i<40; i++) {
			System.out.println("\t"+Thread.currentThread().getName());
		}
	}
}
