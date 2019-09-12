package chapter04;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 *         This program simulates rolling a pair of dice until the total
 *         on the dice comes up to be a given number. It will throw
 *         exception if it's given invalid number. 
 *
 */
public class problem03 {

	/**
	 * 
	 * @param total
	 * @return number of dice rolls it takes to get total
	 * @exception IllegalArgumentException thrown when number outside 2-12
	 * 
	 */
	public static int rollDice(int total) {
		if(total < 2 || total > 12) {
			throw new IllegalArgumentException ("Invalid entry. Please try again.");
		}
		int	numTries = 0;
		do {
			int dice1 = (int)(Math.random() * 6) + 1;
			int dice2 = (int)(Math.random() * 6) + 1;
			if(dice1 + dice2 == total) {
				return ++numTries; // add successful try as well
			} else {
				numTries++;
			}
		} while(true);
	}
	
	public static void main(String[] args) {
		 
		final int desiredTotal = 2;
		Scanner   stdin = new Scanner(System.in);

		try {
			System.out.println("It took " + rollDice(desiredTotal) + " tries to land on " + desiredTotal + ".");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Illegal entry. Please try again.");
			return;
		}
		
	}

}
