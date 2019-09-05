package chapter03;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 * This program evaluates simple expressions such as 17 + 3 and 
 * 3.14159 * 4.7.
 *
 */
public class Problem03 {

	public static void main(String[] args) {

		char 	operator;
		double	operand1, operand2;
		Scanner stdin = new Scanner(System.in);
		String 	expression;//, operand2;
		
		do {
			System.out.println("Please enter [operand] [operator] [operand]. Only +, -, *, / are allowed operators.");
			
			// Get the first operand
			try {
				operand1 = stdin.nextDouble();
			}
			catch(InputMismatchException e) {
				System.out.println("Please try again with space between each part.");
				operand1 = 1;
				break;
			}
			if(operand1 == 0) {
				break;
			}
			// Get the rest of the string
			expression = stdin.nextLine();
			if(expression.length() < 1) {
				System.out.println("Please try again with space between each part.");
				break;
			}
			// Get operator out of expression string
			operator = expression.charAt(expression.indexOf(' ') + 1);
			// Get the second operand from string
			operand2 = Double.parseDouble(expression.substring(expression.indexOf(operator) + 2));
			
			System.out.print("Expression evaluates to ");
			switch(operator) {
				// Addition
				case('+'):
					System.out.println(operand1 + operand2);
					break;
					
				// Subtraction
				case('-'):
					System.out.println(operand1 - operand2);
					break;
					
				// Multiplication
				case('*'):
					System.out.printf("%1.2f", (operand1 * operand2));
					System.out.println("\n");
					break;
					
				// Division
				case('/'):
					System.out.printf("%1.2f", (operand1 / operand2));
					System.out.println("\n");
					break;
					
				// Default
				default:
					System.out.println(" garbage. Please try again.");
					break;
			}
		} while (operand1 != 0); // if user puts second operand
	}

}
