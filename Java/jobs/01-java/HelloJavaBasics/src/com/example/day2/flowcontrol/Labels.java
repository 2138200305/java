package com.example.day2.flowcontrol;

public class Labels {

	public static void main(String[] args) {
		loopOne:
		for(int i=0; i<3; i++) {
			//"break" exits the loop EXACTLY where it is.
			//and proceeds with the code AFTER the loop.
			/*if(i==2)
				break;*/
			anythingiwanted:
			for(int j=0; j<4; j++) {
				//"continue" stops the CURRENT iteration of the loop
				// and then starts the next iteration
				if(i==2)
					break loopOne;
				if(j==2 )
					continue anythingiwanted;
				System.out.println("i: " + i + "\tj: " + j);
			}
			//break;
			System.out.println("in the outer loop");
			
		}

	}

}
