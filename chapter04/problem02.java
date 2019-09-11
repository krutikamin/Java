package chapter04;

import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 *         This program returns hexadecimal value of a given character.
 *         It will print error message if given character is not valid.
 *
 */
public class problem02 {

	private static int hexValue(char c) {
		switch(c) {
		case('a') :
			return 10;
		
		case('b') :
			return 11;

		case('c') :
			return 12;

		case('d') :
			return 13;

		case('e') :
			return 14;

		case('f') :
			return 15;
		
		default:
			return -1;
		}
	}
	
	public static void main(String[] args) {
			String  hexString;
			Scanner stdin = new Scanner(System.in);
			int     value = 0;
			boolean validHexString = true;
			
			System.out.print("Please enter hexadecimal string - ");
			hexString = stdin.nextLine();
			
			for(int i = 0; i < hexString.length(); i++) {
				if(Character.isLetter(hexString.charAt(i))) {
					if(hexValue(hexString.charAt(i)) == -1) {
						System.out.print("Invalid hex string entered. Try again.");
						validHexString = false;
						break;
					}
					value = value * 16 + hexValue(Character.toLowerCase(hexString.charAt(i)));
				} else {
					value = value * 16 + Integer.parseInt(Character.toString(hexString.charAt(i)));// + hexValue(Character.toLowerCase(hexString.charAt(i)));
				}
			}
			if(validHexString) {
				System.out.println("Hexadecimal value is " + value);	
			}
	}

}
