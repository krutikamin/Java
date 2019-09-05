package chapter02;
import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 * This program asks user for first name and last name then 
 * displays the first name & number of characters in it,
 * the last name & number of characters in it and initials.
 *
 */
public class Problem06 {

	public static void main(String[] args) {
		
		String 	fullName, firstName, lastName;
		Scanner stdin = new Scanner(System.in);
		
		// Get the full name of user
		System.out.println("Please enter your first name and last name, seperated by a space.\n?");
		fullName = stdin.nextLine();
		
		// Get the first name and display it's content and length
		firstName = fullName.substring(0, fullName.indexOf(' '));
		System.out.println("Your first name is " + firstName + ", which has " + firstName.length() +
				" characters");
		
		// Get the last name and display it's content and length
		lastName = fullName.substring(fullName.indexOf(' '));
		System.out.println("Your last name is " + lastName + ", which has " + lastName.length() +
				"characters");
		
		// Display initials
		System.out.println("Your initials are " + fullName.charAt(0) +
				fullName.charAt(firstName.length() + 1));
	}

}
