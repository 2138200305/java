package com.example.day5.exceptions;

import java.io.FileNotFoundException;

public class TheCustomExceptionDriver {

	public static void main(String[] args) {
		MyCustomException myE = new MyCustomException();
		
		try {
			throw myE;
		} catch (MyCustomException e) {
			//e.printStackTrace();
			//System.out.println("I took care of it, it's sleeping with the fishes");
		}

		MyCustomRuntimeException myRE = 
				//new MyCustomRuntimeException(); //no args constructor
				//new MyCustomRuntimeException("Rubber Ducky"); //String parameter
				new MyCustomRuntimeException("Rubber Ducky, Again", myE);
		throw myRE;
	}

	void exampleOfFixingAnException() {
		String myFilePath= null;
		
		try {
			if(myFilePath==null)
				throw new FileNotFoundException();
		} catch (FileNotFoundException e) {
			myFilePath="C:/user/Trevin/defaultBackUpFileLocation";
		}
	}
}




