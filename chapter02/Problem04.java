package chapter02;
import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 * This program tells the user how much money he has
 * expressed in dollars calculated from change entered 
 *
 */
public class Problem04 {

	public static void main(String[] args) {
		
		int 	quarters, dimes, nickels, pennies;
		double 	totalAmountInDollar;
		Scanner stdin = new Scanner(System.in);
		
		// Get the number of quarters
		System.out.print("Please enter number of quarters: ");
		quarters = stdin.nextInt();
		System.out.println();
		
		// Get the number of dimes
		System.out.print("Please enter number of dimes   : ");
		dimes = stdin.nextInt();
		System.out.println();
		
		// Get the number of nickels
		System.out.print("Please enter number of nickels : ");
		nickels= stdin.nextInt();
		System.out.println();

		// Get the number of pennies
		System.out.print("Please enter number of pennies : ");
		pennies= stdin.nextInt();
		System.out.println();
		
		// Display total in dollars
		System.out.print("You have $");
		System.out.printf("%1.2f", ((0.25 * quarters) + (0.1 * dimes) + (0.05 * nickels) + (0.01 * pennies)));
	}

}
