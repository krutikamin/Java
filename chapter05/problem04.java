package chapter05;

import java.util.Scanner;
/**
 * 
 * @author Krutik Amin
 *         <p>
 *         This program deals 2 to 6 random cards from a deck of cards, displays them
 *         and outputs total value of those cards.
 *
 */
public class problem04 {

	public static void main(String[] args) {
		final int NUM_CARDS_TO_DEAL = (int)((6 * Math.random()) + 2); // Random 2-6 value
		char      userResponse;
		
		do {
			int       cardSuitNumber;
			int       cardValue;
			Scanner   stdin = new Scanner(System.in);
			BlackjackHand blackjackHandObj = new BlackjackHand();
			
			System.out.println(NUM_CARDS_TO_DEAL + " random cards will be dealt.\n");
			for(int i = 0; i < NUM_CARDS_TO_DEAL; i++) {
				cardSuitNumber = (int)(4 * Math.random()); // get a random suit of card
				cardValue = (int)(13 * Math.random()) + 1; // get a random value of card
				Card newCard = new Card(cardValue, cardSuitNumber); // create a new card with above values
				blackjackHandObj.addCard(newCard); // add that card to hand
				// display current card and its value
				System.out.println("\t" + (i+1) + ". " + newCard.getValueAsString() + " " + newCard.getSuitAsString());
			}
			// display value of our hand
			System.out.println();
			System.out.println("The value of the hand is " + blackjackHandObj.getBlackjackValue());
			System.out.println("-----------------------------------------------");
			System.out.println("Try again? (y/n)");
			userResponse = stdin.nextLine().charAt(0);
			// close stream in case no more games played
			stdin.close();
		} while(userResponse == 'y' || userResponse == 'Y');
	}
}
