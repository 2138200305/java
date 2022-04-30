
/*
 * @author Jae Nwawe Project 2.  Here is a description, and there is an accompanying file name Report.txt that has the same description.
 * RockPaperScissors is a java program that uses Math.random to generate three integers.

Then the computer's choice for rock, paper, scissors depends on the Math.random amount multiplied by 3 which leads to the integer 0,1, or 2.
The user will select r, p, or s.  
The computer's choice and user's choice are compared using if statements.
The the user and computer have a score that is incremented by one if they win that game.
The user came replay by typing y.
*/

import java.util.*;
public class RockPaperScissors {
	private static int computerWin = 0;
	private static int userWin = 0;
	private static Character computerChoice;
	public static RockPaperScissors Game = new RockPaperScissors();
	private static Scanner input = new Scanner(System.in);


	public static boolean playAgain() {
	
	
		
		System.out.println("Would you like to play again?  Type y or n");
		Character response = 'n';
		response = input.nextLine().charAt(0);
	
	
		if (response == 'y')  
			return true;
		else 
			return false;
		

		 
	}

		 	
	
	
	public Character userChoice() {
		
		Character userChoice = 'r';
		String response;
		 Scanner input = new Scanner(System.in);
		 System.out.print("Enter r for rock, p for paper, or s for scissors");
		 response=input.nextLine();
	
		 userChoice = response.charAt(0);
			
		return userChoice;
	}
	public static Character computerChoice() {
		
		
		int choiceValue =  (int) ((int) 3 * Math.random());
		
		switch(choiceValue) {
		case (0): computerChoice = 'r'; 
		break;
		
		case (1): computerChoice = 'p'; 
		 break;
		
		case (2): computerChoice = 's'; 
		break;
		
		default: computerChoice = 'r'; 
		break;
			
		
		}
		return computerChoice; 
		
	};
	
	public static void determineWinner(Character userChose, Character computerChose) {
		
		if ((computerChose == 'r' && userChose == 'r')|| (computerChose == 'p' && userChose == 'p')|| (computerChose == 's' && userChose == 'p'))
			System.out.println("There is a tie since the computer and user both choose" + computerChose);
		
		if((computerChose == 'r' && userChose == 's')|| (computerChose == 'p' && userChose == 'r')|| (computerChose == 's' && userChose == 'p')) {
			 computerWin++;
			System.out.println("The computer chose " + computerChose+" which beats "+userChose);
		}
		
		if((computerChose == 'r' && userChose == 'p')|| (computerChose == 'p' && userChose == 's')|| (computerChose == 's' && userChose == 'p')) {
			userWin++;
			System.out.println("The user chose " + userChose+" which beats "+computerChose);
		}
	
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	
		 do{
			
			Character userChose = Game.userChoice();
			Character computerChose = computerChoice();
			System.out.println(computerChose);
			RockPaperScissors.determineWinner(userChose, computerChose);
		 }
		while(RockPaperScissors.playAgain() == true);
		 input.close();
		
		
	

}
}

