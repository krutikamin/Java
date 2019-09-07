package chapter03;
/**
 * 
 * @author Krutik Amin
 * 	This program finds how many random people you have to select 
 * before you find three people who share the same birthday.
 *
 */
public class Problem07_a {

	public static void main(String[] args) {
		
		boolean[] used = new boolean[365];
		int		  count = 0;
		int	      peopleWithSameBirthdaySoFar = 0;
		final int maxNumPeopleWithSameBirthday = 3;
		
		while(true) {
			int birthday;

			birthday = (int)(Math.random()*365);
			count++;
			
			if(used[birthday]) {
				if(peopleWithSameBirthdaySoFar == maxNumPeopleWithSameBirthday) {
					break;
				} else {	// else block not necessary
					peopleWithSameBirthdaySoFar++;
				}
			}
			
			used[birthday] = true;
		}
		
		System.out.println(count + " people selected before " + maxNumPeopleWithSameBirthday + 
				" people found with same birthday.");
	}

}
