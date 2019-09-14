package chapter05;

public class problem01 {

	public static void main(String[] args) {
		
		final int  desiredTotal = 2;         // Desired total to land on
		int        numRolls = 0;             // Count number of rolls
		PairOfDice aPair = new PairOfDice(); // Initialize
		
		while(aPair.getDie1Value() + aPair.getDie2Value() != desiredTotal) {
			aPair = new PairOfDice();
			numRolls++;
		}
		
		// Display number of rolls/initializations it took to land on desired total
		System.out.printf("It took %d rolls to land on %d", numRolls, desiredTotal);
	}

}
