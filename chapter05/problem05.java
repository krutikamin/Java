package chapter05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class problem05 {

	private static boolean playGame(Deck deck, BlackjackHand playerHand, BlackjackHand dealerHand) {
		return true;
	}
	
	public static void main(String[] args) {
		final int     MONEY = 100;
		int           betAmount;
		char          userResponse;
		Scanner       stdin = new Scanner(System.in);
		
		do {
			Deck          deck = new Deck();
			BlackjackHand playerHand = new BlackjackHand();
			BlackjackHand dealerHand = new BlackjackHand();
			
			System.out.print("Place bet amount(1-" + MONEY + ") - $");
			try {
				betAmount = stdin.nextInt();
				if(betAmount < 1 || betAmount > 100) {
					throw new IllegalArgumentException("Out of range value entered. Try again.");
				}
			} catch(InputMismatchException e) {
				System.out.println("Not a valid entry. Please try again.");
			}
			
			for(int i = 0; i < 2; i++) {
				playerHand.addCard(deck.dealCard());
				dealerHand.addCard(deck.dealCard());
			}
			
			if(playGame(deck, playerHand, dealerHand) == true) {
				System.out.println("Player won!\n");
			} else {
				System.out.println("Player lost!\n");
			}
			
			System.out.println("Play another game? (y/n)");
			userResponse = stdin.nextLine().charAt(0);
		} while (userResponse == 'y' || userResponse == 'Y');
		stdin.close();
	}

}
