package chapter05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class problem05 {

	private static boolean playGame(Deck deck, BlackjackHand playerHand, BlackjackHand dealerHand) {
		String  hitOrStand;
		Scanner stdin = new Scanner(System.in);
	
		System.out.println("Player hand -");
		showHand(playerHand, playerHand.getCardCount());
		System.out.println("Dealer hand -");
		showHand(dealerHand, (int)(2 * Math.random()) + 1);
		do {
			System.out.print("Hit or stand? - ");
			hitOrStand = stdin.next();
			if(hitOrStand.compareToIgnoreCase("hit") == 0) {
				System.out.println("Player hand -");
				playerHand.addCard(deck.dealCard());
				showHand(playerHand, playerHand.getCardCount());				
				if(playerHand.getBlackjackValue() > 21) {
					return false;
				}
			}
			System.out.println("\tHand value - " + playerHand.getBlackjackValue());
		} while(hitOrStand.compareToIgnoreCase("hit") == 0 && playerHand.getBlackjackValue() < 22);
		
		while(dealerHand.getBlackjackValue() <= 16) {
			dealerHand.addCard(deck.dealCard());
			showHand(dealerHand, dealerHand.getCardCount());
			System.out.println("\tHand value - " + dealerHand.getBlackjackValue());
		}
		if(dealerHand.getBlackjackValue() > 21) {
			return true;
		}
		
		if(playerHand.getBlackjackValue() == dealerHand.getBlackjackValue()) {
			return false;
		}
		
		if(playerHand.getBlackjackValue() > dealerHand.getBlackjackValue()) {
			return true;
		} else {
			return false;
		}
	}
	
	private static void whoWon(String who) {
		//System.out.println("Player " + who.compareTo("player") == 0 ? "won!" : "lost!");
		System.out.print("\tPlayer ");
		if(who.compareTo("player") == 0) {
			System.out.println("won!\n");
		} else {
			System.out.println("lost!\n");
		}
	}
	
	private static void showHand(BlackjackHand hand, int numCards) {
		for(int i = 0; i < numCards; i++) {
			System.out.println(hand.getCard(i));
		}
		//System.out.println("\tHand value - " + hand.getBlackjackValue()); 
		System.out.println("-----------");
	}
	
	public static void main(String[] args) {
		final int     MONEY = 100;
		int           betAmount;
		char          userResponse;
		Scanner       stdin = new Scanner(System.in);
		
		do {
			Deck          deck = new Deck(false);
			boolean       validAmount;
			BlackjackHand playerHand = new BlackjackHand();
			BlackjackHand dealerHand = new BlackjackHand();
			
			deck.shuffle();
			System.out.print("Place bet amount(1-" + MONEY + ") - $");
			try {
				betAmount = stdin.nextInt();
				if(betAmount < 1 || betAmount > 100) {
					throw new IllegalArgumentException("Out of range value entered. Try again.");
				}
			} catch(InputMismatchException e) {
				System.out.println("Not a valid entry. Please try again.");
			}
			validAmount = true;
			// First two cards are dealt into each player's hand.
			for(int i = 0; i < 2; i++) {
				playerHand.addCard(deck.dealCard());
				dealerHand.addCard(deck.dealCard());
			}
			// Check if dealer has 21 already & declare player lost.
			if(dealerHand.getBlackjackValue() == 21) {
				System.out.println("\tDealer has 21. Dealer cards -");
				showHand(dealerHand, dealerHand.getCardCount());
				System.out.println("\tPlayer cards -");
				showHand(playerHand, playerHand.getCardCount());
				whoWon("dealer");
			} else if(playerHand.getBlackjackValue() == 21) { // Check if player has 21
				if(dealerHand.getBlackjackValue() == 21) { // Check if dealer also has 21
					// Declare player lost if both dealer and player has 21
					System.out.println("\tDealer cards -");
					showHand(dealerHand, dealerHand.getCardCount());
					System.out.println("\tPlayer cards -");
					showHand(playerHand, playerHand.getCardCount());
					whoWon("dealer");
				} else {
					// Otherwise, declare player winner
					System.out.println("\tDealer cards -");
					showHand(dealerHand, dealerHand.getCardCount());
					System.out.println("\tPlayer cards -");
					showHand(playerHand, playerHand.getCardCount());
					whoWon("player");
				}
			} else {
				if(playGame(deck, playerHand, dealerHand) == true) {
					whoWon("player");
				} else {
					whoWon("dealer");
				}
			}
			
			System.out.println("Play another game? (y/n)");
			userResponse = stdin.next().charAt(0);
			System.out.println("---------------------------------------------------------");
		} while (userResponse == 'y' || userResponse == 'Y');
		stdin.close();
	}

}
