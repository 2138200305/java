package com.example.day2;

public class PrimExample {

	/*A bit is a 0 or 1 (a "on" or "off" value)
	 * A byte is 8 bits
	 * A nibble 4 bits
	 * 
	 * meter= 1
	 * kilometer= 1000
	 * megameter= 1,000,000
	 * gigameter= 1,000,000,000
	 * tera		=1,000,000,000,000
	 * peta		=1,000,000,000,000,000
	 * exo
	 * 
	 * kilobyte= 1,024 = 2^10
	 * megabyte= 2^20
	 * gigabyte= 2^30
	 * 
	 * what are the primitive types in java????
	 *	int (4 bytes), double(8 bytes), float(4 bytes), boolean(1 bit),
	 *	long(8 bytes), char(2 bytes), byte(1 byte), short(2 bytes)
	 *	
	 */
	public static void main(String[] stuff) {
		//how do we declare a variable in java?
		//DATATYPE variablename;
		
		int x;	//this is how we declare a variable
		int x2= 16; //this is how we declare a variable AND assign it a value.
		
		boolean bool = true;	//a true or false value
		byte by=7; //1 byte, a smaller space efficient integer representation
		char c= 'T'; //a single character value
		int i= 3889; //4 bytes, an integer numeric value
		double d= 55.2895D; //a decimal numeric value
		float f= 77.892F; // a floating point value. HOlds big decimals with
					//less precision
		short s= 15; //2 bytes, space efficient ints
		long l= 15L; //8 bytes, holds larger ints
		
		//other primitive info
		double dTwo= 28.227;
		//float fTwo= 28.227; //will not work
		float fThree= (float)28.227;
		double dThree= 278.92f;
		int iTwo= 'y';
		char cTwo= 300;
		
		//System.out.println(iTwo);
		//System.out.println(cTwo);
		
		int iThree = 789_223_4_7_4;   //for readability
				//the underscores aren't stored
		//System.out.println(iThree); //underscores don't print
		
		//double solution = 5/9; //integer division
		double solution = 5.0/9;
		//System.out.println(solution);
		
		int temp= 1;
		/*System.out.println(++temp);	//pre increment
		System.out.println(++temp);
		System.out.println(++temp);
		System.out.println(++temp);*/
		
		System.out.println(temp++);	//post increment
		System.out.println(temp++);
		System.out.println(temp++);
		System.out.println(temp++);
		System.out.println(temp);
	}
}












