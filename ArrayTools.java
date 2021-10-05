/**
 * 
 */
package cambrian.mapd.arraynmethods;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @author Nitin Sharma(A00248347)
 * 
 * MAPD: Java: Lab 2 - Methods and Arrays
 * 
 * The below program does following:
 * 1. Encrypts using ceasercypher method.
 * 2. Decrypts using ceasercypher method.
 * 3. Calculates the average of an numeric arrray.
 * 4. Search a value in an array
 * 5. Reverse an array.
 */
public class ArrayTools {
	
	public static void main(String args[]) {
		Scanner input = null;
		try {
			input = new Scanner(System.in);
			/*
			 * Let's take a string and offset value as input from the user and perform encrypt and decrypt
			 */
				// Take input from console for string to be Ciphered/Encrypted
				System.out.println("Enter a string to encrypt : ");
				String consoleInputStrVar = input.nextLine();
	
				System.out.println("Enter a value to encrypt with: ");
				int consoleShiftValueStrVar = input.nextInt();
				// Encrypt by caesarCipher 
				String encryptedStr = caesarCipher(consoleInputStrVar, consoleShiftValueStrVar);
				System.out.println("The encrypted string is: " + encryptedStr);
	
				// Decrypt by caesarDecipher
				String decryptedStr = caesarDeCipher(encryptedStr, consoleShiftValueStrVar);
				System.out.println(
						"Decrypting " + encryptedStr + " with -" + consoleShiftValueStrVar + ":..... " + decryptedStr);

			/*
			 * Let's take array size and element as input from the user and calculate avg of
			 * array values
			 */
				System.out.println("\nEnter the size of your array: ");
				int arraySizeVar = input.nextInt();
				float arrayElementsVar = 0;
				float[] averageArrayConsoleVar = new float[arraySizeVar];
                // Allow user to input elements of array		
				for (int j = 0; j < arraySizeVar; j++) {
					System.out.println("Provide array element:" + (j + 1) + " of your array: ");
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
			 * Let's check if array created before have a value which is entered by the user
			 *  
			 */
				System.out.println("\nEnter a value to search in the previous array: ");
				float findMeCharConsoleVar = input.nextFloat();
				boolean existVar = arrayContains(averageArrayConsoleVar, findMeCharConsoleVar);
				if (existVar == true) {
					System.out.println("The array contain's : " + findMeCharConsoleVar);
				} else {
					System.out.println("The array doesn't contain : " + findMeCharConsoleVar);
				}
			/*
			 * Write a method that reverses an array (gives a new array) (can use any data
			 * type you want)
			 */
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
				// charAt used to get char value and shift value is calculated and return ascii
				// code and is converted to char
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
			//To avoid code redundancy utilized the caesarCipher method above with -ve value for decryption.
			return caesarCipher(to_be_encrypted, -shift_value); 
		}

	/*
	 * Method which takes array size and element as input from the user and
	 * calculate avg of array values
	 */
		public static float arrayAvg(float[] arrLocal) {
			float arrayElementsSumVar = 0;
			float arrayAvgVar = 0.0f;
			
			for (int i = 0; i < arrLocal.length; i++) {
				arrayElementsSumVar = arrayElementsSumVar + arrLocal[i];
			}
			arrayAvgVar = arrayElementsSumVar / arrLocal.length;
			return arrayAvgVar;
	
		}

	/*
	 * Method that accepts an array and search value, and determines if the array
	 * contains the value (can use any data type you want)
	 */
		public static boolean arrayContains(float[] arrLocal, float searchValue) {
			boolean containsFlag = false;
			//Traverse the array and compare each element with search value provided by the user.
			for (int i = 0; i < arrLocal.length; i++) {
				if (searchValue == arrLocal[i]) {
					containsFlag = true;
				}
			}
			return containsFlag;
	
		}

	// Method below reverses an array generated before by the user (gives a new array) (can use any data type you want)
		public static float[] arrayReverse(float[] arrLocal) {
			int j = 0;
			float[] revArrLocal = new float[arrLocal.length];
			//Reverse the array by fetching each element from previous array in reverese order and putting in new array.
			for (int i = arrLocal.length; i > 0; i--, j++) {
				revArrLocal[j] = arrLocal[i - 1];
	
			}
			return revArrLocal;
		}

}
