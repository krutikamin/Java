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
public class problem04 {

	/**
	 * 
	 * @param     total
	 * @return    number of dice rolls it takes to get total
	 * @exception IllegalArgumentException thrown when number outside 2-12
	 *            This function returns number of tries it takes to land on desired
	 *            total by performing 2 dice rolls until total of them is not equal
	 *            to desired total.
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
				return ++numTries; // Add successful try as well
			} else {
				numTries++;
			}
		} while(true);
	}
	
	/**
	 * 
	 * @param  numRolls - number of dice rolls to perform
	 * @param  total - desired total to get
	 * @return average number of rolls to get desired total
	 *         This function takes numRolls and total and performs simulation of
	 *         rolling two dices numRolls times.
	 *         It also calculates average number of rolls it takes to land on 
	 *         desired total by adding previous average to new average.
	 *         New average is calculated by getting number of rolls it takes to
	 *         get desired total and dividing by number of times rollDice was 
	 *         called.
	 */
	public static double roll(int numRolls, int total) {
		int rollsLeft = 0;
		int numTries = 0;
		
		while(rollsLeft < numRolls) {
			try {
				numTries += (double)rollDice(total);
			}
			catch(IllegalArgumentException e) {
				System.out.println("Invalid input detected. Please try again.");
			}
			rollsLeft++;
		}
		return (double)numTries/numRolls;
	}
	
	/**
	 * 
	 *   main
	 */
	public static void main(String[] args) {
		
		final int numRolls = 10000;
		int       desiredTotal;
		Scanner   stdin = new Scanner(System.in);
		
		System.out.println("Total On Dice" + "\t" + "Average Number of Rolls");
		System.out.println("-------------" + "\t" + "-----------------------");
		
		for(desiredTotal = 2; desiredTotal < 13; desiredTotal++) {
			System.out.printf("%7d%23.4f", desiredTotal, roll(numRolls, desiredTotal));
			System.out.println();
		}
	}

}
