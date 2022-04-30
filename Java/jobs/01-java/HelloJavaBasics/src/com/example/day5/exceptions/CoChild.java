package com.example.day5.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CoChild extends CoParent {

	@Override
	void method1() throws /*Exception,*/ FileNotFoundException {
		//you CAN have co-variance with the throws declaration
	}
}
