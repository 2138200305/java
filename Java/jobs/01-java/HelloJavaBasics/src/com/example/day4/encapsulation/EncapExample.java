package com.example.day4.encapsulation;
/*
 * What is encapsulation?
 * 		Restricting direct access to members (variables or methods)
 */
public class EncapExample {

	public static void main(String[] args) {
		//they can't do this when the variable is private
		/*System.out.println(EncapHelper.mySolution[12]);
		EncapHelper.mySolution[12]= 250;
		EncapHelper.mySolution= null;
		System.out.println(EncapHelper.mySolution[12]);*/

		EncapHelper.getMySolution(12);
		EncapHelper.setMySolution(12, 250);
	}

}
