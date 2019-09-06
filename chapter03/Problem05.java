package chapter03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 * 	This program reads from sales.dat file and computes total
 * sales then displays it as well as number of cities for which
 * data was not available
 *
 */
public class Problem05 {

	public static void main(String[] args) {
		
		int		numCitiesWithNoData = 0;
		double	branchSales = 0, totalSales = 0;
		Scanner data;
		String	branch;
		
		// Try to open the file
		try {
			data = new Scanner(new File("sales.dat"));
		} 
		catch(FileNotFoundException e) {
			System.out.println("File could not be opened!");
			return;
		}
		
		while(data.hasNextLine()) {
			branch = data.nextLine();
			try {
				branchSales = Double.parseDouble(branch.substring(branch.indexOf(':') + 2, branch.length()));
				totalSales += branchSales;
			}
			catch(NumberFormatException e) {
				numCitiesWithNoData++;
			}
		}
		
		System.out.println("Total Sales = " + totalSales);
		System.out.print(numCitiesWithNoData + (numCitiesWithNoData > 1 ? " cities" : " city") + " found without any data.");
	}

}
