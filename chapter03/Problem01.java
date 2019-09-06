package chapter03;
/**
 * 
 * @author Krutik Amin
 * This program counts how many turns it takes before the dice 
 * come up snake eyes.
 *
 */
public class Problem01 {

	public static void main(String[] args) {
		
		int die1, die2, numTurns = 0;
		
		do {
			die1 = (int)(Math.random() * 6) + 1;
			die2 = (int)(Math.random() * 6) + 1;
			numTurns++;
		} while (die1 != 1 && die2 != 1);
		
		System.out.print("It took " + numTurns + " roll");
		System.out.print(numTurns > 1 ? "s " : " ");
		System.out.println("to come up snake eyes.");
	}

}
