package chapter03;

import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 * 	This program reads one line of input text and breaks it up into words.
 * The words are output one per line. The program assumes it's given proper
 * sentence with only one space between the words.
 *
 */
public class Problem04 {

	public static void main(String[] args) {
		
		String	sentence;
		char	aChar;
		
		// Get the sentence
		System.out.println("Please enter the sentence to break into words -");
		sentence = (new Scanner(System.in)).nextLine();
		
		for(int index = 0; index < sentence.length(); index++) {
			aChar = sentence.charAt(index);
			//if((aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z') || (aChar == '\'')) {
			if((Character.isLetter(aChar)) || aChar == '\'') {
				System.out.print(aChar);
			} else if (aChar == ' ') {
				while(aChar == ' ') {
					aChar = sentence.charAt(++index);
				}
				System.out.println();
				index--;
			}
		}
	}

}
