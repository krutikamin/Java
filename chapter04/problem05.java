package chapter04;
/**
 * 
 * @author Krutik Amin
 *         This program finds maximum value in the array, the 
 *         minimum value in array, sum of the array, and average
 *         of the values in array using lambda expression.
 *
 */

public class problem05 {
	
	public static final ArrayProcessor findMax = (array) -> {
		double max = array[0];
		for(int index = 1; index < array.length; index++) {
			max = array[index] > max ? array[index] : max;
		}
		return max;
	};
	
	public static final ArrayProcessor findMin = (array) -> {
		double min = array[0];
		for(int index = 1; index < array.length; index++) {
			min = array[index] < min ? array[index] : min;
		}
		return min;
	};
	
	public static final ArrayProcessor findSum = (array) -> {
		double sum = array[0];
		for(int index = 1; index < array.length; index++) {
			sum += array[index];
		}
		return sum;
	};
	
	public static final ArrayProcessor findAvg = (array) -> {
		return findSum.apply(array) / array.length;
	};
	
	public static ArrayProcessor counter(double value) {
		return (array) -> {
			int counter = 0;
			for(int index = 0; index < array.length; index++) {
				if(array[index] == value) {
					counter++;
				}
			}
			return counter;
		};
	}

	public static void main(String[] args) {

		double[] testArray = {1, 2, 3, 8, -2, -1, 5};
		
		System.out.println("Max value = " + findMax.apply(testArray));
		System.out.println("Min value = " + findMin.apply(testArray));
		System.out.println("Total value = " + findSum.apply(testArray));
		System.out.println("Avg value = " + findAvg.apply(testArray));
		System.out.println("5 value occurs " + counter(5).apply(testArray));
	}

}
