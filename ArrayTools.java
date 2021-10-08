/**
 * 
 */
package cambrian.mapd.arraynmethods;

import java.util.Scanner;

/**
 * @author Nitin Sharma(A00248347)
 * 
 * MAPD: Java: Lab 2 - Methods and Arrays
 * 
 * The below program does the following:
 * 1. Encrypts using ceasercypher method.
 * 2. Decrypts using ceasercypher method.
 * 3. Calculates the average of a numeric array.
 * 4. Search a value in an array
 * 5. Reverse an array.
 */
public class ArrayTools {
	
	public static void main(String args[]) {
		// Collect user input using Scanner class
		Scanner input = null;
		try {
			// instantiate the Scanner class
			input = new Scanner(System.in);
			/*
			 * Task 1: Let's take a string and offset value as input from the user and perform encrypt
			 * You can input any string: It can be as short as Apple and as long as an entire Novel text. Also you 
			 * can provide the special characters whatever you want.
			 * "The method can take it all." 
			 */
				// Take input from console for string to be Ciphered/Encrypted
					System.out.println("Enter a string to encrypt : ");
					String consoleInputStrVar = input.nextLine();
				
				// Take input from console for offset value which will be used for encryption
					System.out.println("Enter a value to encrypt with: ");
					int consoleShiftValueStrVar = input.nextInt();
					// Call caesarCipher method with both the values received from the user  
					String encryptedStr = caesarCipher(consoleInputStrVar, consoleShiftValueStrVar);
					System.out.println("The encrypted string is: " + encryptedStr);
	
			/*
			 * Task 2: Let's take an encrypted string and offset value as input from the user and perform decryption
			 */
				// Decrypt by caesarDecipher
					// Call caesarDeCipher method with encrypted string received from the previous 
					// caesarCipher method and offset value received from the user
					String decryptedStr = caesarDeCipher(encryptedStr, consoleShiftValueStrVar);
					System.out.println("Decrypting " + encryptedStr + " with -" + consoleShiftValueStrVar + ":..... " + decryptedStr);

			/*
			 * Task 3: Let's take array size and element as input from the user and calculate avg of
			 * array values
			 */     
				  //Ask the user to enter the size of the array so that we can take input from him the array elements accordingly.	 
					System.out.println("\nEnter the size of your array: ");
					int arraySizeVar = input.nextInt();
					//Initializing the array making variables and array itself.
					float arrayElementsVar = 0;
					float[] averageArrayConsoleVar = new float[arraySizeVar];
					
	                // Allow user to input elements of array		
					for (int j = 0; j < arraySizeVar; j++) {
						System.out.println("Provide array element:" + (j + 1) + " of your array: ");
						//Takes the array elements from the user	
						arrayElementsVar = input.nextInt();
						averageArrayConsoleVar[j] = arrayElementsVar;
					}
					//Traverse through array and fetch each element to print.
					System.out.print("Testing methods with [ ");
					for (int k = 0; k < averageArrayConsoleVar.length; k++) {
						System.out.print(averageArrayConsoleVar[k] + " ");
					}
					System.out.print(" ]");
					System.out.println("\nThe average is: " + arrayAvg(averageArrayConsoleVar));

			/*
			 * Task 4: Let's check if array created before have a value which is entered by the user
			 *  
			 */
				//Ask the user to provide a value to search in the array.
				System.out.println("\nEnter a value to search in the previous array: ");
				//Take input from the user.
				float findMeCharConsoleVar = input.nextFloat();
				//Call arrayContains method with previously received array from the user and the char which user wants us to find.
				boolean existVar = arrayContains(averageArrayConsoleVar, findMeCharConsoleVar);
				//Check if the value of the variable received is true/false and print accordingly
				if (existVar == true) {
					System.out.println("The array contain's : " + findMeCharConsoleVar);
				} else {
					System.out.println("The array doesn't contain : " + findMeCharConsoleVar);
				}
			/*
			 *Task 5: Write a method that reverses an array (gives a new array) (can use any data
			 * type you want)
			 */ 
				//Call the reversed array
				float[] reveredArrayVar = arrayReverse(averageArrayConsoleVar);
				// System.out.println("The reversed array : "+ reveredArrayVar);
				System.out.print("The array reversed is [ ");
				for (int k = 0; k < reveredArrayVar.length; k++) {
					System.out.print(reveredArrayVar[k] + " ");
				}
				System.out.print(" ]");

		} finally {
			input.close();
		}
	}

	/*
	 * Method below creates a CaesarCipher method that accepts a String (the String to
	 * encrypt), a shift value, and returns the new String. Used str.chatAt(i) method
	 */
		public static String caesarCipher(String cipheredinputStrVar, int shiftValueVar) {
			String ciphertext = ""; // final output will be stored in this variable
			// iterates until the end of string cipheredinputStrVar length
			for (int i = 0; i < cipheredinputStrVar.length(); i++) {
				/*
				 *Concept of below encryption calculation:
				 * When a char is added to and int value, java considers the ASCII value 
				 * of the char and add's it to the int vlaue. The sum which we get is converted 
				 * into a char again to get the new shifted value based on ceaserCypher encryption way.
				 * In order to pick a char from the String entered, charAt(i) is used.  
				 */
				ciphertext += (char) (cipheredinputStrVar.charAt(i) + shiftValueVar);
			}
			// returns encrypted text
			return ciphertext;
		}
	
	/*
	 * Method below takes a string and shift/offset value as input from the user and decrypts it.
	 */
		public static String caesarDeCipher(String to_be_encrypted, int shift_value) 
		{    
			//To avoid code redundancy utilized the caesarCipher method above with -ve offset value for decryption.
			return caesarCipher(to_be_encrypted, -shift_value); 
		}

	/*
	 * Method which takes array size and element as input from the user and calculates avg of array values
	 */
		public static float arrayAvg(float[] arrLocal) {
			float arrayElementsSumVar = 0;
			float arrayAvgVar = 0.0f;
			// Traversing the array elements and adding them one by one to get the sum.
			for (int i = 0; i < arrLocal.length; i++) {
				arrayElementsSumVar = arrayElementsSumVar + arrLocal[i];
			}
			//Dividing the sum with the total number of elements.
			arrayAvgVar = arrayElementsSumVar / arrLocal.length;
			//Return the average
			return arrayAvgVar;
	
		}

	/*
	 * Method that accepts an array and search value, and determines if the array
	 * contains the value (can use any data type you want)
	 */
		public static boolean arrayContains(float[] arrLocal, float searchValue) {
			boolean containsFlag = false;
			//Traverse the array.
			for (int i = 0; i < arrLocal.length; i++) {
				//and compare each element with search value provided by the user
				if (searchValue == arrLocal[i]) {
					containsFlag = true;
				}
			}
			//Return True if we find the element in the array....else false.
			return containsFlag;
	
		}

	// Method below reverses an array generated before by the user (gives a new array) (can use any data type you want)
		public static float[] arrayReverse(float[] arrLocal) {
			int j = 0;
			float[] revArrLocal = new float[arrLocal.length];
			//Reverse the array by fetching each element from previous array in reverse order and putting in new array.
			for (int i = arrLocal.length; i > 0; i--, j++) {
				revArrLocal[j] = arrLocal[i - 1];
				}
			//Return the new array which has elements in reverse order
			return revArrLocal;
		}

}
