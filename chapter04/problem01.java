package chapter04;

import java.util.Scanner;

/**
 * 
 * @author Krutik Amin
 * 	This program converts a string input to a capitalized string
 *  using printCapitalized method and displays the end result. 
 *  Could be improved.
 *
 */

public class problem01 {
	/**
	 * 
	 * @param string
	 * @return string
	 * 		printCapitalized method returns capitalized string.
	 *      It assumes there's no space at the end of input string and
	 *      string is not empty
	 */
	public static String printCapitalized(String s) {
		
		boolean capitalizeNextCharacter = false;
		char    oldChar = s.charAt(0);
		char    capitalizedChar;
		String  tempString = "";
		
		for(int index = 0; index < s.length(); index++) {
			// Capitalize first character of sentence.
			if(index == 0) {
				oldChar = s.charAt(0);
				capitalizedChar = Character.toUpperCase(oldChar);
				// Add capitalized letter to the first position
				tempString = Character.toString(capitalizedChar);
				// Add rest of the string
				s = tempString.concat(s.substring(1));
			}
			if(s.charAt(index) == ' ') {
				capitalizeNextCharacter = true;
			} else {
				capitalizeNextCharacter = false;
			}
			if(capitalizeNextCharacter) {
				oldChar = s.charAt(index + 1);
				capitalizedChar = Character.toUpperCase(oldChar);
				// Copy substring before capitalized char
				tempString = s.substring(0, index);
				// Add capitalized letter
				tempString = tempString.concat(" " + Character.toString(capitalizedChar));
				// Add rest of the string
				s = tempString.concat(s.substring(index + 2));
			}
		}
		return s;
	}
	
	public static void main(String[] args) {

		String input;
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("Please enter string to capitalize -");
		input = stdin.nextLine();
		System.out.println(printCapitalized(input));
	}

}
