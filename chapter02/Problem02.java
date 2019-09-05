package chapter02;
/**
 * 
 * @author Krutik Amin
 * This program simulates rolling a pair of dice & 
 * outputs each die as well as the toal roll
 *
 */
public class Problem02 {

	public static void main(String[] args) {
		
		int die1 = (int)(Math.random()*6) + 1;
		int die2 = (int)(Math.random()*6) + 1;
		
		System.out.println("The first die comes up " + die1);
		System.out.println("The second die comes up " + die2);
		System.out.println("Your total roll is " + (die1 + die2));
	}

}
