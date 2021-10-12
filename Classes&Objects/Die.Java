package cambrian.mapd.die;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Nitin Sharma(A00248347)
 * 
 *  MAPD: Android Development: Lab 3 - Classes/ Objects
 *   
 */

public class Die {

	/**
	 * Data fields to describe the die 
	 * 1. Type - or name(eg d20) 
	 * 2. Number of sides (eg 20) 
	 * 3. Current side up
	 */
	private String diceType;
	private int noOfSides;
	private int currentSideUp;
    
	
	//Creating Appropriate Accessors and Mutators
	/**
	 * @return the diceType
	 */
	protected String getDiceType() {
		return diceType;
	}

	/**
	 * @param diceType the diceType to set
	 */
	protected void setDiceType(String diceType) {
		this.diceType = diceType;
	}

	/**
	 * @return the noOfSides
	 */
	protected int getNoOfSides() {
		return noOfSides;
	}

	/**
	 * @param noOfSides the noOfSides to set
	 */
	protected void setNoOfSides(int noOfSides) {
		this.noOfSides = noOfSides;
	}

	/**
	 * @return the currentSideUp
	 */
	protected int getCurrentSideUp() {
		return currentSideUp;
	}

	/**
	 * @param currentSideUp the currentSideUp to set
	 */
	protected void setCurrentSideUp(int currentSideUp) {
		this.currentSideUp = currentSideUp;
	}

	/*
	 * A 0 argument constructor Default type/name: "d6"; default number of sides: 6;
	 * random side up generated from the roll method
	 */
	public Die() {
		diceType = "d6";
		noOfSides = 6;
	  }

	/*
	 * A 1 argument constructor Number of sides is the parameter. Default
	 * type/name:"d{number of sides}" random side up generated from the roll method
	 */
	public Die(int noOfSides) {
		this.diceType = "d" + noOfSides;
		this.noOfSides = noOfSides;
	}

	/*
	 * A 2 argument constructor Both the number of sides and the type are
	 * parameters; random side up generated from the roll method
	 */
	public Die(int noOfSides, String diceType) {
		this.diceType = diceType;
		this.noOfSides = noOfSides;
	}

	/*
	 * A roll method to generate a random value Your roll method can make use of
	 * built-in random functions like Math.random() or the Random class. roll is a
	 * special set method that doesn't take any arguments and shouldn't return a
	 * value
	 */
	public void roll() {
		// creating an object of Random class
		Random random = new Random();
		int max = noOfSides;
		int min = 1;
		//Setting the currentSideUp with random value generated from the random function
		currentSideUp = random.nextInt(max + 1 - min) + min;
	}

}
