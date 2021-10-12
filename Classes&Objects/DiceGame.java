/**
 * 
 */
package cambrian.mapd.die;

import java.util.Scanner;

/**
 * @author User
 *
 */
public class DiceGame {

	    /*
		 * Task 1:Create different sized dice using each constructor
		 * Task 2:Roll the dice and display their results (before and after) 
		 * Task 3:Choose one Die object and set it to show it's highest value
		 * Task 4:BONUS (optional): create 5 six-sided dice. Roll each Die in a loop until you get 5 of a kind. Count and display the number of rolls.
		 */
	
	public static void main(String[] args) {
		
		//Task:1: Create different sized dice using each constructor
			Die die0ArgObj = new Die();
			System.out.println("Creating a default d6...");
			
			Die die1ArgObj = new Die(20);
			System.out.println("Creating a default d20...");
			
			Die die2ArgObj = new Die(10, "d10");
			System.out.println("Creating percentile die (a special d10)...");
			
		//Task2: Roll the dice and display their results (before and after)
			die0ArgObj.roll();
			System.out.println("\nThe current side up for d6 is: " + die0ArgObj.getCurrentSideUp());
			
			die1ArgObj.roll();
			System.out.println("The current side up for d20 is 9: " + die1ArgObj.getCurrentSideUp());
		
			die2ArgObj.roll();
			System.out.println("The current side up for Percentile is " + die2ArgObj.getCurrentSideUp());
			
			System.out.println("\nTesting the roll method");
			
			System.out.println("\nRolling the d6...");
			die0ArgObj.roll();
			System.out.println("The new value is : " + die0ArgObj.getCurrentSideUp());
			
			System.out.println("Rolling the d20...");
			die1ArgObj.roll();
			System.out.println("YAY! It's a  : " + die1ArgObj.getCurrentSideUp());
			
			System.out.println("Rolling the Percentile...");
			die2ArgObj.roll();
			System.out.println("The new value is : " + die2ArgObj.getCurrentSideUp());
			
	    //Task 3: Choose one Die object and set it to show it's highest value
			System.out.println("\nSetting the d20 to show 20... ");
			while(die1ArgObj.getCurrentSideUp()!=20) {
				die1ArgObj.roll();
				System.out.println("Rolling.....to get 20 number up, current side up is: "+die1ArgObj.getCurrentSideUp());
			    }
			if(die1ArgObj.getCurrentSideUp()==20) {
			System.out.println("*****The side up is now 20. Finally.*******");
			}
			
			
			System.out.println("\nDo you wish to change number of sides for a dice? Y/N");
		    Scanner scannerObj = new Scanner(System.in);
		    String strVar = scannerObj.next();
		    char choiceObj = strVar.charAt(0);

		    //changing die face and sides
		    if(choiceObj == 'Y'){
		      System.out.println("Please enter the number of sides: ");
		      int userWishedSideVar = scannerObj.nextInt();
		      die2ArgObj.setNoOfSides(userWishedSideVar);
		      die2ArgObj.setDiceType("d"+userWishedSideVar);
		      die2ArgObj.roll();
		      System.out.println("User Entered number of sides for Dice as: "+userWishedSideVar +" ....currentSideUp after rolling the dice : " + die2ArgObj.getCurrentSideUp());
		     }
			
		/*
		 * Task4: BONUS (optional): create 5 six-sided dice. Roll each Die in a loop until you
		 * get 5 of a kind. Count and display the number of rolls.
		 */
		    
		    //YAHTZEE! Game creating 5 d6 die and roll them to get YAHTZEE!
		    
		    System.out.println("\n----------");
		    System.out.println("BONUS");
		    System.out.println("----------");
		    System.out.println("Creating 5, d6 dices...");
		    Die[] dieObj = new Die[5];
		    int numberOfRolls = 1;
		    boolean FlagYAHTZEE = false;
		    //initializing each dice object
		    dieObj[0] = new Die();  dieObj[1] = new Die();  dieObj[2] = new Die(); dieObj[3] = new Die(); dieObj[4] = new Die();
		   
		    //Using while loop to run till we get same side up for all 5 dices
		    while(!FlagYAHTZEE) {
		    	dieObj[0].roll();	dieObj[1].roll();	dieObj[2].roll(); dieObj[3].roll(); dieObj[4].roll();
	           if((dieObj[0].getCurrentSideUp() == dieObj[1].getCurrentSideUp()) && 
	    		  (dieObj[0].getCurrentSideUp() == dieObj[2].getCurrentSideUp()) &&
	    		  (dieObj[0].getCurrentSideUp() == dieObj[3].getCurrentSideUp()) && 
	    		  (dieObj[0].getCurrentSideUp() == dieObj[4].getCurrentSideUp()))
		        {
		    	  FlagYAHTZEE = true;
		        }
		      numberOfRolls++;
		    }
		    System.out.println("YAHTZEE! It took " + numberOfRolls + " rolls");
			
		}
		
		


}
