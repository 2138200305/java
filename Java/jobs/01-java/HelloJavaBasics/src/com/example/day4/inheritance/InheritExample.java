package com.example.day4.inheritance;

public class InheritExample {

	public static void main(String[] args) {
		//Animal an = new Animal();
		//an.  //take a look at the current state and behaviors
		//Monkey mon = new Monkey();
		//mon. //take a look at the current state and behaviors
		
		//AFTER using "extends" keyword
		//mon.  //take a look at the state and behaviors NOW
		//an.  //none of the state and behavior of monkey
		
		
		//Fox fo= new Fox(); //testing this() and super()
		//System.out.println(fo.color);
		//System.out.println(((Animal)fo).color);
		
		//fo.checkColorFox();
		//fo.checkColor();
		//((Animal)fo).checkColor();
		//((Animal)fo).checkColorFox() //this method doesn't exist in Animal
		//fo.checkColorParent();
		
		Monkey mon= new Monkey();
		//mon.speak();
		
		Fox fox = new Fox();
		fox.speak(); //using the overridden fox speak method
		//((Animal)fox).speak();
		
		/*THERE ARE MULTIPLE FORMS OF POLYMORPHISM
		 types:
				upcasting- Referring to a Fox as an Animal. Referring to a child
						as its parent. e.g.  Animal an= (Animal)fox.
						RUNTIME polymorphism
				downcasting-
				overriding- A child changing the implementation of a parent's method
						RUNTIME polymorphism
				overloading- Same method name, different parameter list
						COMPILE time polymorphism
		*/
		Animal myAnimal= new Animal();
		Fox f=(Fox)myAnimal;
		System.out.println(f.height);

	}
	
	void method1(Animal obj) {
		if(obj instanceof Fox)
			System.out.println(((Fox)obj).color);
		else if(obj instanceof Monkey)
			System.out.println(((Monkey)obj).color);
	}
	/*void method1(Animal an) {
		
	}
	void method1(Fox fox) {
		
	}*/
	

}
