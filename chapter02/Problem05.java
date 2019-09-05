package chapter02;
import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 * This program displays number of eggs in gross if over 144
 * or in dozens otherwise as well leftover eggs.
 *
 */
public class Problem05 {

	public static void main(String[] args) {
		
		int	numEggs;
		
		// Get number of eggs
		System.out.print("Please enter number of eggs - ");
		System.out.println();
		numEggs = (new Scanner(System.in)).nextInt();
		
		// Display number of eggs
		System.out.print("Your number of eggs is ");
		if(numEggs > 143) {
			// Display gross
			System.out.print(numEggs / 144 + " gross, ");
			
			// Get the rest of eggs
			numEggs %= 144;
		}
		// Display dozen
		System.out.print(numEggs / 12 + " dozen, and ");
		
		// Display the remaining number of eggs
		System.out.println(numEggs % 12);
	}

}
