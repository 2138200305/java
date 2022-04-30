package com.example.day2.flowcontrol;

public class IfExample {

	public static void main(String[] args) {

		boolean bool = true;
		
		//if statements   aka   if block
		
		if(bool) {
			//System.out.println("if");
		}else if( !bool) {
			//System.out.println("else if");
		}else {
			//System.out.println("else");
		}
		
		//complicated if statement example
		int temp1=0;
		int temp2=18;
		
		if(temp1==1)
			if(temp2==17) System.out.println("in temp2");
		else {System.out.println("in else");}
		
		//ternary statements
		int x= 90;
		
		String s =  ( x <= 9 ) ? "gravy" : "buttered toast"+method1();
		
		//System.out.println(s);
		
		//switch case
		String k= "ed";
		
		/*switch(k) {
		case "ed":
			System.out.println("first case");
			//if there is no "break" then the case below will fire as well
		case "edd":
			System.out.println("second case");
			break; //break stops the propagation of the logic
		case "plank":
			System.out.println("third case");
			break;
		default:
			System.out.println("default case");
		}*/
		
		
		/*if(k=="kevin") { //not as easy to read as a switch case variation
			//my logic
		}else if(k=="ed") {
			//other logic
		}else if(k=="edd") {
			//again, other logic
		}else if(k=="eddy") {
			//more logic
		}else {
			//final logic
		}*/
		
		//another switch case
		Integer myNum=8;
		Thread t= new Thread();
		/*datatypes that work with switch cases:
		 * Yes:
		 * 	int, char, short, byte, String, Enum
		 * 	Integer, Character, Short, Byte
		 * No:
		 *  double, float, long, boolean
		 */
		switch(myNum) {
		case 6:
			//logic
		default:
			//more logic
		}
		
	}

	public static String method1() {
		return "stuff";
	}
}



