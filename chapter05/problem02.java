package chapter05;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Krutik Amin
 *         This program tests modified StatCalc.java that have additional
 *         methods to find maximum and minimum value from the dataset.
 *
 */

public class problem02 {

	public static void main(String[] args) {
		
		StatCalc calc = new StatCalc();
		double   entry = 1;
		Scanner  stdin = new Scanner(System.in);
		
		System.out.println("Please enter numbers. Enter 0 to stop.");
		
		do {
			try {
				entry = stdin.nextDouble();
				if(entry == 0) {
					break;
				}
				calc.enter(entry);
			}
			catch(InputMismatchException e) {
				// https://stackoverflow.com/a/18275695
				System.out.println("Not a valid entry. Try again.");
				stdin.next();
				continue;
			}
			
		} while(entry != 0);
		
		if(calc.getCount() == 0) {
			System.out.println("No numbers entered.");
			return;
		}
		
		System.out.println("----------------------------------------------");
		System.out.printf("Total %d numbers entered.\n", calc.getCount());
		System.out.printf("Total = %1.2f.\n", calc.getSum());
		System.out.printf("Mean  = %1.2f\n", calc.getMean());
		System.out.printf("Standard Deviation = %1.2f\n", calc.getStandardDeviation());
		System.out.printf("Max = %1.2f\n", calc.getMax());
		System.out.printf("Min = %1.2f\n", calc.getMin());
		
	}

}
