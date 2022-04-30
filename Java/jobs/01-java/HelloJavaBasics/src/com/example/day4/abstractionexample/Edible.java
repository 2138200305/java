package com.example.day4.abstractionexample;

public interface Edible {
	
	//the implicit nature of methods inside of an interface:
	//    			public and abstract
	void method1(); //you can have a class implement TWO different interfaces
	//with each interface asking the class to implement "method1()"
}
