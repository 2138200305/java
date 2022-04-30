package com.example.day6.threading;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<40; i++) {
			System.out.println("\t\t"+Thread.currentThread().getName());
		}
		
	}

}
