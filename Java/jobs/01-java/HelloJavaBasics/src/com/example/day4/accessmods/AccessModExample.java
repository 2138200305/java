package com.example.day4.accessmods;
/*What are modifiers?
 * 	keywords that alter functionality of some variable, method,
 * 		classes, or interfaces.
 * 
 * Examples of modifiers?
 * 		static, abstract, final, synchronized, transient, native, etc
 * 
 * What are access modifiers?
 * 	Access Modifiers restrict or expand the permissions to an object's members
 * 	and/or itself. Not to be confused with scope. SCOPE limits the life span of
 * 	the variables, methods, etc. ACCESS MODIFIERS don't determine the life span...
 * 	instead, it determines who/what has access to the variables, methods, etc.
 * 
 * Access Modifiers in java:
 * 		public	-  everything
 * 		protected- the class itself, the package, the children
 * 		(default)- the class itself, the package
 * 		private	-  the class itself
 */
public class AccessModExample {

	public static void main(String[] args) {
		//INSIDE the package
		Food food = new Food();
		System.out.println(food.calories);

	}

}
