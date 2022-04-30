package com.example.day4.accessmodhelper;

import com.example.day4.accessmods.Food;

//OUTSIDE THE PACKAGE
public class AccessModHelper extends Food{

  void printStuff() {
	  System.out.println(calories);
  }
  
  	public void cook() {
		System.out.println("in the process of grillin'");
		
		
	}

  public static void main(String[] args) {
		/*Food food = new Food();
		System.out.println(food.calories);*/

	}
}
