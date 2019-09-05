package chapter02;
import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 * This program asks user's name, and then greets the user by
 * name in upper case letters.
 *
 */
public class Problem03 {

	public static void main(String[] args) {
		
		String user;
		
		System.out.println("What is your name?");
		user = (new Scanner(System.in)).nextLine().toUpperCase();
		
		System.out.println("Hello," + user + ", nice to meet you!");
	}

}
