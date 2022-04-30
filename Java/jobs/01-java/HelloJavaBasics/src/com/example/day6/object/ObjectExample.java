package com.example.day6.object;

public class ObjectExample {

	public static void main(String[] args) {
		//What is the object class?
		// The class in which all other classes are descendents of.
		
		//The Object class
		Object obj = new Object();
		//System.out.println(obj.toString());
			//System.out.print secretly and automatically calls this method
			// by default, the Object class' toString return the memory address
		
		//obj.equals(someOtherObject); //compares the memory address of two objects
				//UNLESS overridden, obviously
		
		//System.out.println(obj.hashCode()); //creates a psuedo unique int value
			// determined by the object itself; this value is used inside of maps

		
		DummyObject dobj = new DummyObject();
		//dobj.  //demo of all objects inheriting from the Object class
		
		
		DummyObject one = new DummyObject();
		DummyObject two = new DummyObject();
		System.out.println(one);
		System.out.println(two);
		System.out.println(one == two); // "==" comparing memory address
		
		String sone= "Trevin";
		String stwo= "Trevin";
		String sthree= "Trevi".concat("n");
		System.out.println("String pool proof: "+ (sone == sthree));
		System.out.println("String pool proof: "+ (sone.equals(sthree)));
	}

}
