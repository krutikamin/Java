package chapter04;

import java.util.Scanner;

/**
 * 
 * @author Krutik Amin
 * 	This program converts a string input to a capitalized string
 *  using printCapitalized method and displays the end result.
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
		
		//for(int spaceIndex = s.indexOf(' '); spaceIndex < s.length(); spaceIndex = s.indexOf(' ', spaceIndex)) {
		for(int index = 0; index < s.length(); index++) {
			//char oldChar = s.charAt(spaceIndex+1);
			if(s.charAt(index) == ' ' || index == 0) {
				capitalizeNextCharacter = true;
			} else {
				capitalizeNextCharacter = false;
			}
			if(capitalizeNextCharacter) {
				char oldChar = s.charAt(index+1);
				char newChar = Character.toUpperCase(oldChar);
				System.out.printf("Old char = %c, new char = %c\n", oldChar, newChar);
				String tempString = s.substring(0, s.indexOf(s.charAt(index)));
				tempString = tempString.concat(Character.toString(newChar));
				tempString = tempString.concat(s.substring(s.indexOf(s.charAt(index) + 1)));
				s = tempString;
				System.out.println(s);
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
