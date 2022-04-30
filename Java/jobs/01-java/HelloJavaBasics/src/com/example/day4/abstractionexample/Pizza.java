package com.example.day4.abstractionexample;

public class Pizza extends Food implements Chewable, Edible{
	String toppings;
	String size;
	
	public Pizza() {
	}
	
	String getToppings() {
		return toppings;
	}

	@Override
	void goBad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chewableMethod() {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public void myDefaultMethod() {
		// TODO Auto-generated method stub
		
	}*/
}
