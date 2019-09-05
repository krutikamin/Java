package chapter02;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Krutik Amin
 * This program reads "testdata.txt" file and displays a message
 * that contains the name of the student and the student's average 
 * grade on the three exams.
 *
 */
public class Problem07 {
	
	public static void main(String[] args) {

		int 	total = 0;
		int		numTests = 0;
		Scanner data;
		String	studentName;
		
		
		// Try to open the file
		try {
			data = new Scanner(new File("testdata.txt"));
		} 
		catch(FileNotFoundException e) {
			System.out.println("File could not be opened!");
			return;
		}
		
		// Output student's name
		System.out.println("Sudent Name: " + data.nextLine());
		
		// Get exam scores
		while(data.hasNextInt()) {
			total += data.nextInt();
			numTests++;
		}
		
		// Output average score of 3 exams
		System.out.printf("Average grade: %1.2f", ((double)total / numTests));
	}
	
}
