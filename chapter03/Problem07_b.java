package chapter03;
/**
 * 
 * @author Krutik Amin
 * 	This program finds how many different birthdays will random
 * 365 people have.
 *
 */
public class Problem07_b {

	public static void main(String[] args) {

		final int NUM_PEOPLE = 365;
		boolean[] used = new boolean[NUM_PEOPLE];
		int	      peopleWithDifferentBirthday = 0;
		
		for(int index = 0; index < NUM_PEOPLE; index++) {
			int birthday = (int)(Math.random()*365);
			
			if(!used[birthday]) {
				peopleWithDifferentBirthday++;
			}
			
			used[birthday] = true;
		}
		System.out.printf("Random %d people had %d different birthdays.", NUM_PEOPLE,
				peopleWithDifferentBirthday);
	}

}
