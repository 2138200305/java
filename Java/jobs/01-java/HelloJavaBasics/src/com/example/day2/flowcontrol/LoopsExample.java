package com.example.day2.flowcontrol;

public class LoopsExample {

	public static void main(String[] args) {
		boolean bool=true;
		int i= 0;
		
		//while loop
		/*while(bool) { //while(CONDITION){ then repeat this logic
			//System.out.println(i++);
			if(i==3)
				bool=false;
		}*/
		
		// do while loop
		//like the while loop, but always runs at least once
		/*do {
			//System.out.println("in the do while loop");
		}while(bool);*/
		
		//for loop
		//anything that you do in a while loop, you can do in a for loop
		//HOWEVER, for loops are easier to read in some situations
		/*For example:
		 * 	for(int i=0; i<myArry.length;i++){
		 * 		//my logic
		 * 	}
		 */
		/*int k= 9;
		int myNum= 0;
		//for(initialization {optional}; condition{default: true}; assignment{optional})
		for( myNum=8; bool; k=k+88-9*5) {
			//System.out.println("stuff");
			System.out.println(i++);
			if(i==3)
				bool=false;
		}*/
		
		
		//an enhanced for loop (for each loop)
		int[] ourArray = {67, 2389, 10, 8};
		
		for(int myTemp: ourArray) {
			System.out.println(myTemp);
		}
		/*for(int theTemp=0; theTemp<ourArray.length; theTemp++) {
			System.out.println(ourArray[theTemp]);
		}*/
		
		
		System.out.println("done");
		/*THIS:
		 * 	++i
		 * 	i++
		 * is the same as THIS:
		 * 		i=i+1
		 * is also the same as THIS:
		 * 		i+=1
		 */
	}

}
