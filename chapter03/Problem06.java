package chapter03;
/**
 * 
 * @author Krutik Amin
 * 	This program will output all numbers between 1 & 10000 with maximum 
 * number of divisors. 
 *
 */
public class Problem06 {

	public static void main(String[] args) {

		final int UPPER_LIMIT = 10000;
		int[]	  numDivisorsArray = new int[UPPER_LIMIT];
		int[] 	  numbersWithHighestDivisors = null;
		int	      divisorCount = 0;
		int 	  maxDivisors = 0;
		int	      numbersWithHighestDivisorsArrayIndex = 0;
	
		for(int dividend = 1; dividend <= UPPER_LIMIT; dividend++) {
			for(int testDivisor = 1; testDivisor <= dividend; testDivisor++) {
				if(dividend % testDivisor == 0) {
					divisorCount++;
				}
			}
			
			// Add divisor count for that dividend to numDivisorsArray
			numDivisorsArray[dividend - 1] = divisorCount;
			
			// Update maxDivisors and numberWithHighestDivisors
			if(divisorCount >= maxDivisors) {
				maxDivisors = divisorCount;
			}
			
			// Reset divisorCount for next integer
			divisorCount = 0;
		}
		
		// Print output
		System.out.println("Aming integers between 1 and " + UPPER_LIMIT + ",\nThe maximum"
				+ " number of divisors was " + maxDivisors);
		System.out.println("Numbers with that many divisors include:");
		for(int index = 0; index < UPPER_LIMIT; index++) {
			if(numDivisorsArray[index] == maxDivisors) {
				System.out.println("\t" + (index + 1));
			}
		}
	}

}
