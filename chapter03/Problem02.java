package chapter03;
/**
 * 
 * @author Krutik Amin
 * This program finds an integer between 1-10000 with highest
 * number of divisors.
 *
 */

public class Problem02 {

	public static void main(String[] args) {
		
		final int UPPERLIMIT = 10000;
		int numberWithHighestDivisors = 0;
		int	divisorCount = 0, maxDivisors = 0;
	
		for(int N = 1; N <= UPPERLIMIT; N++) {
			for(int testDivisor = 1; testDivisor <= N; testDivisor++) {
				if(N % testDivisor == 0) {
					divisorCount++;
				}
			}
			// Update maxDivisors and numberWithHighestDivisors
			if(divisorCount > maxDivisors) {
				maxDivisors = divisorCount;
				numberWithHighestDivisors = N;
			}
			// Reset divisorCount for next integer
			divisorCount = 0;
		}
		
		System.out.println("Number with highest divisors between 1-10000 is " + numberWithHighestDivisors +
				" with " + maxDivisors + " divisors.");
	}

}
