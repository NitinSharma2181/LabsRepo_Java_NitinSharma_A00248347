/**
 * 
 */
package cambrian.mapd.convert;

import java.util.Scanner;

/**
 * @author Nitin Sharma(A00248347):MAPD 
 *         Lab 1 - Variables and Logic
 *         This program allows a user to convert between different forms of measurements.
 *         I have improvised this code to allow user to provide conversion inputs multiple time,so don't need to re-run the code.
 */
public class Convert {

	public static void main(String[] Strings) {
		// Collect user input using Scanner class
		Scanner input = new Scanner(System.in);
		// Variable to take input from the user whether to continue or not.
		String continueVar = "Y";
		// Exception handling to close the Scanner
		try {
			// Loop to allow the user to repeat the conversions
			while (continueVar.equals("Y")) {

				System.out.print("Enter a value to convert: ");
				Double inputValue = input.nextDouble();

				System.out.print("Enter the current unit of measure: ");
				String inputUnit = null;
				inputUnit = input.next();
				Double kilometerVar, milesVar, centemeterVar, inchVar, kgVar, lbVar, gramVar, ounceVar, celsiusVar,
				fahrenheitVar, kelvinVar, literVar, cupsVar;

				// Validations for inputValue
				if (inputValue != null) {
					// Validations for inputUnit
					if (inputUnit != null) {
						// Passing variable to the switch
						switch (inputUnit) {
						// comparing value of inputUnit variable against each case

						case "km":
							// Conversion 1: "km" to "miles" (Reference: 1km = 0.62mi)
							kilometerVar = inputValue;
							milesVar = kilometerVar * 0.62;
							System.out.println(kilometerVar + " Kilometer is " + milesVar + " miles \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N?");
							continueVar = input.next();
							break;

						case "mi":
							// Conversion 2: "miles" to "km" (Reference: 1mi = 1.61km)
							milesVar = inputValue;
							kilometerVar = milesVar * 1.61;
							System.out.println(milesVar + " miles is " + kilometerVar + " Kilometer \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N?");
							continueVar = input.next();
							break;

						case "cm":
							// Conversion 3: "cm" to "in" (Reference: 1cm = 0.39in)
							centemeterVar = inputValue;
							inchVar = centemeterVar * 0.39;
							System.out.println(centemeterVar + " Centemeter is " + inchVar + " Inch \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
							continueVar = input.next();
							break;

						case "in":
							// Conversion 4: "in" to "cm" (Reference: 1in = 2.54cm)
							inchVar = inputValue;
							centemeterVar = inchVar * 2.54;
							System.out.println(inchVar + " Inch is " + centemeterVar + " Centemeter \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
							continueVar = input.next();
							break;

						case "kg":
							// Conversion 5: "kg" to "lb" (Reference: 1kg = 2.2lb)
							kgVar = inputValue;
							lbVar = kgVar * 2.2;
							System.out.println(kgVar + " Kilogram is " + lbVar + " Pound \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
							continueVar = input.next();
							break;

						case "lb":
							// Conversion 6: "lb" to "kg" (Reference: 1lb = 0.45kg)
							lbVar = inputValue;
							kgVar = lbVar * 0.45;
							System.out.println(lbVar + " Pound is " + kgVar + " Kilogram \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
							continueVar = input.next();
							break;

						case "g":
							// Conversion 7: "g" to "oz" (Reference: 1g = 0.04oz)
							gramVar = inputValue;
							ounceVar = gramVar * 0.04;
							System.out.println(gramVar + " Gram is " + ounceVar + " Ounce \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
							continueVar = input.next();
							break;

						case "oz":
							// Conversion 8: "oz" to "g" (Reference: 1oz = 28.35g)
							ounceVar = inputValue;
							gramVar = ounceVar * 28.35;
							System.out.println(ounceVar + " Ounce is " + gramVar + " Gram \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
							continueVar = input.next();
							break;

						case "C":
							// Conversion 9: "C" to "F" (Reference: C to F (C×9/5)+32)
							System.out.print("Enter the unit of measure in which you want to convert F or K?: ");
							String input_F_Or_K_Var = input.next();

							if (input_F_Or_K_Var.equals("F")) {
								celsiusVar = inputValue;
								fahrenheitVar = (celsiusVar * 9 / 5) + 32;
								System.out.println(celsiusVar + " Celsius is " + fahrenheitVar + " Fahrenheit \n");
								System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
								continueVar = input.next();
							} else if (input_F_Or_K_Var.equals("K")) {
								// Conversion 10: "C" to "K" (Reference: C to K (C+273.15)
								celsiusVar = inputValue;
								kelvinVar = celsiusVar + 273.15;
								System.out.println(celsiusVar + " Celsius is " + kelvinVar + " Kelvin \n");
								System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
								continueVar = input.next();
							}
							break;

						case "F":
							// Conversion 11: "F" to "C" (Reference: F to C (F−32)×5/9)
							System.out.print("Enter the unit of measure in which you want to convert C or K?: ");
							String input_C_Or_K_Var = input.next();
							fahrenheitVar = inputValue;
							if (input_C_Or_K_Var.equals("C")) {
								celsiusVar = (fahrenheitVar - 32) * 5 / 9;
								System.out.println(fahrenheitVar + " Fahrenheit is " + celsiusVar + " Celsius \n");
								System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
								continueVar = input.next();
							} else if (input_C_Or_K_Var.equals("K")) {
								// Conversion 12: "F" to "K" (Reference: F to K (F−32)×5/9+273.15
								kelvinVar = (fahrenheitVar - 32) * 5 / 9 + 273.15;
								System.out.println(fahrenheitVar + " Fahrenheit is " + kelvinVar + " Kelvin \n");
								System.out.println("Note:  Do you want to continue with more unit conversions: Y/N? ");
								continueVar = input.next();
							}
							break;

						case "L":
							// Conversion 13: "L" to "cups" (Reference: 1L = 4.17cups)
							literVar = inputValue;
							cupsVar = literVar * 4.17;
							System.out.println(literVar + " Liter is " + cupsVar + " Cups \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
							continueVar = input.next();
							break;

						case "cup":
							// Conversion 14: "cup" to "L" (Reference: 1cup = 0.24L)
							cupsVar = inputValue;
							literVar = cupsVar * 0.24;
							System.out.println(cupsVar + " Cups is " + literVar + " Liter \n");
							System.out.println("Note: Do you want to continue with more unit conversions: Y/N? ");
							continueVar = input.next();
							break;

						default:
							System.out.println("Invalid Input!\n");
							System.out.println("Note: You want to try again : Y/N? ");
							continueVar = input.next();
						}
					}
				}
			}
		} finally {
			//closing the scanner.
			input.close();
		}

	}
}
