package chapter03;

import java.util.Arrays;

/**
 * 
 * @author Krutik Amin
 * 	This program finds how many different people you have to check
 * before you find at least one person with a birthday on each of 
 * the 365 days of the year.
 *
 */
public class Problem07_c {

	public static void main(String[] args) {
		
		boolean[] used = new boolean[365];
		int	      birthdays = 0;
		int		  count = 0;
		
		for(int index = 0; index < 365; index++) {
			int birthday = (int)(Math.random()*365);
			count++;

			if(used[birthday] == false) {
				used[birthday] = true;
				//System.out.println("Index = " + index);
			} else {
				index--;
			}
		}
		
		/*
		while(birthdays < 365) {
			int randBirthday = (int)(Math.random()*365);
			count++;
			
			if(used[randBirthday] == false) {
				birthdays++;
				used[randBirthday] = true;
			} 
			
		}
		*/
		System.out.printf("%d people checked before one person with a birthday on each of "
				+ "365 days of year found.\n", count);
	}

}
