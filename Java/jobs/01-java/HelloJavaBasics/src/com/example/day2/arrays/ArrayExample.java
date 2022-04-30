package com.example.day2.arrays;

public class ArrayExample {

	public static void main(String[] args) {
		/*what is an array!?!?!?
		*	It's a series of data entries (of the same type)
		*	sequential in memory
		*
		*	For example, a series of characters
		*MY MEMORY HEAP
		*	[2bytes][2bytes][2bytes]
		*	index 0	 index 1 index 2
		*/
		
		//how do we create an array in java?
		int arryZero[];
		double[] arryOne=new double[14];
		int[] arryTwo= {77, 2389, 55, 2020};
			//there are a few ways to create arrays in java
		
		//we use [ ] to access elements of an array
		//System.out.println(arryTwo[2]);
		arryTwo[2] = 107;
		//System.out.println(arryTwo[2]);
		
		/*UnInitialized array elements use the datatypes' default value
		 * Default values:
		 * 	int is 0, double is 0.0, float is 0.0f, short 0,
		 * long is 0, boolean is false, char is "empty character" aka null
		 * byte is 0, Object is null
		 */
		String[] arry1=new String[14];
		//System.out.println(arry1[9]);
		
		// the length property tells us the size of an array
		// ".length" is NOT a method, so we don't use ".length()"
		//System.out.println(arry1.length);
		
		//what is a multidimensional array
		// In short, it is a matrix
		int[][] arryFour = {{22,77},{109,88},{1,1}};
		int arryFive[][]= new int[100][200];
		
		//
		//int arrySix[][][][][][][][][][][][][][][][][][][][][][][][][][][];
		
		//System.out.println(arryFour[1][0]); //prints 109
		//System.out.println(arryFour); //will print memory address
		
		Object obj= new Object();
		//System.out.println(obj); //will print memory address
		
		int[][] arrySeven= new int[4][2];
		//System.out.println(arrySeven[2][19]); //throws an exception
		
		int[] arryEight= new int[900];
		
		arrySeven[2]=arryEight;
		
		System.out.println(arrySeven[2][19]);
		System.out.println(arrySeven[2].length);
		System.out.println(arrySeven.length);
	}

}
