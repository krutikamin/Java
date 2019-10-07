package chapter05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class problem05 {
	
	/**
	 * 
	 * @param deck       - deck to take cards out
	 * @param playerHand - player's hand with cards
	 * @param dealerHand - dealer's hand with cards
	 * @return boolean   - return true if player has won return false otherwise.
	 *         <p>
	 *         This method plays a game of blackjack. It'll play game until either player or dealer
	 *         wins the game. Player wins the game if they end up with higher hand value than dealer.
	 *         Dealer wins in all other cases provided they don't exceed total hand value of 21. If 
	 *         either of them exceed hand value of 21, they lose the game.
	 *         </p>
	 */

	private static boolean playGame(Deck deck, BlackjackHand playerHand, BlackjackHand dealerHand) {
		String  hitOrStand;
		Scanner stdin = new Scanner(System.in);
		
		// Show player hand & its value
		System.out.println("Player hand -");
		showHand(playerHand, playerHand.getCardCount(), true);
		
		// Show dealer hand
		System.out.println("Dealer hand -");
		System.out.println(dealerHand.getCard((int)(1 * Math.random())));
		// Show dealer hand value
		//System.out.println("\tHand value - " + dealerHand.getBlackjackValue());
		do {
			System.out.print("Hit or stand? - ");
			hitOrStand = stdin.next();
			if(hitOrStand.compareToIgnoreCase("hit") == 0) {
				System.out.println("Player hand -");
				playerHand.addCard(deck.dealCard());
				showHand(playerHand, playerHand.getCardCount(), true);				
				if(playerHand.getBlackjackValue() > 21) {
					return false;
				}
			}
			System.out.println("\tHand value - " + playerHand.getBlackjackValue());
		} while(hitOrStand.compareToIgnoreCase("hit") == 0 && playerHand.getBlackjackValue() < 22);
		
		while(dealerHand.getBlackjackValue() <= 16) {
			dealerHand.addCard(deck.dealCard());
			if(dealerHand.getBlackjackValue() > 21) {
				return true;
			}
			showHand(dealerHand, dealerHand.getCardCount(), true);
			System.out.println("\tHand value - " + dealerHand.getBlackjackValue());
		}
		// if both have same total value, return false to declare player lost
		if(playerHand.getBlackjackValue() == dealerHand.getBlackjackValue()) {
			return false;
		}
		
		// if player's hand has higher value than dealer's then return true
		if(playerHand.getBlackjackValue() > dealerHand.getBlackjackValue()) {
			return true;
		} else { // return false to declare player lost
			return false;
		}
	}
	
	/**
	 * 
	 * @param who - string containing either player or dealer
	 * @exception IllegalArgumentException - if who string contains neither player nor dealer
	 *            <p>
	 *            This method displays if player won the game of blackjack. It'll throw 
	 *            IllegalArgumentException if player is not either "player" or "dealer".
	 *            </p>
	 */
	private static void whoWon(String who) {
		//System.out.println("Player " + who.compareTo("player") == 0 ? "won!" : "lost!");
		if((who.compareToIgnoreCase("player") != 0) && (who.compareToIgnoreCase("dealer") != 0)) {
			throw new IllegalArgumentException("Not a valid player");
		}
		System.out.print("\tPlayer ");
		if(who.compareTo("player") == 0) {
			System.out.println("won!\n");
			
		} else {
			System.out.println("lost!\n");
		}
	}
	
	/**
	 * 
	 * @param hand      - whose hand it's supposed to show
	 * @param numCards  - how many cards to show
	 * @param showValue - if it's supposed to show value of the hand
	 *        <p>
	 *        This method display's hand containing upto numCards cards.
	 *        It also shows total value of the hand if showHand is true.
	 *        </p>
	 */
	private static void showHand(BlackjackHand hand, int numCards, boolean showValue) {
		for(int i = 0; i < numCards; i++) {
			System.out.println(hand.getCard(i));
		}
		if(showValue) {
			System.out.println("\tHand value - " + hand.getBlackjackValue());
		} 
		System.out.println("------------------------");
	}
	
	/**
	 * 
	 * @param args - command-line arguments.
	 * @throws IllegalArgumentException - if player tries to bet less than $1 or more than what
	 * they have.
	 * @throws InputMismatchException - if player tries to enter anything other than integer 
	 * when asked to place bets.
	 *        <p>
	 *        Main method
	 *        </p>
	 */
	
	public static void main(String[] args) {
		final int     MONEY = 100;
		int           playerMoney = MONEY;
		int           betAmount;
		char          userResponse ='n';
		Scanner       stdin = new Scanner(System.in);
		
		do {
			Deck          deck = new Deck(false);
			BlackjackHand playerHand = new BlackjackHand();
			BlackjackHand dealerHand = new BlackjackHand();
			
			deck.shuffle();
			System.out.print("Place bet amount(1-" + playerMoney + ") - $");
			try {
				betAmount = stdin.nextInt();
				if(betAmount < 1 || betAmount > playerMoney) {
					throw new IllegalArgumentException("Out of range value entered. Try again.");
				}
			} catch(InputMismatchException e) {
				System.out.println("Not a valid entry. Please try again.");
				break;
			}
			
			// First two cards are dealt into each player's hand.
			for(int i = 0; i < 2; i++) {
				playerHand.addCard(deck.dealCard());
				dealerHand.addCard(deck.dealCard());
			}
			// Check if dealer has 21 already & declare player lost.
			if(dealerHand.getBlackjackValue() == 21) {
				System.out.println("\tDealer has 21. Dealer cards -");
				showHand(dealerHand, dealerHand.getCardCount(), true);
				System.out.println("\tPlayer cards -");
				showHand(playerHand, playerHand.getCardCount(), true);
				whoWon("dealer");
				playerMoney -= betAmount;
			} else if(playerHand.getBlackjackValue() == 21) { // Check if player has 21
				if(dealerHand.getBlackjackValue() == 21) { // Check if dealer also has 21
					// Declare player lost if both dealer and player has 21
					System.out.println("\tDealer cards -");
					showHand(dealerHand, dealerHand.getCardCount(), true);
					System.out.println("\tPlayer cards -");
					showHand(playerHand, playerHand.getCardCount(), true);
					whoWon("dealer");
					playerMoney -= betAmount;
				} else {
					// Otherwise, declare player winner
					whoWon("player");
					playerMoney += betAmount;
				}
			} else {
				if(playGame(deck, playerHand, dealerHand) == true) {
					whoWon("player");
					playerMoney += betAmount;
				} else {
					
					whoWon("dealer");
					playerMoney -= betAmount;
				}
			}

			// Show dealer hand and its value
			System.out.println("\tDealer cards -");
			showHand(dealerHand, dealerHand.getCardCount(), true);
			// Show player hand and its value
			System.out.println("\tPlayer cards -");
			showHand(playerHand, playerHand.getCardCount(), true);
			if(playerMoney > 0) {
				System.out.printf("\tYou have $%d.\n", playerMoney);
				System.out.println("Play another game? (y/n)");
				userResponse = stdin.next().charAt(0);
			} else {
				System.out.println("\tSorry, you lost all your money!\n");
			}

			System.out.println("---------------------------------------------------------");
		} while((userResponse == 'y' || userResponse == 'Y') && (playerMoney > 0));
		System.out.println("You " + (playerMoney > MONEY ? "won $" : "lost $") + 
				(playerMoney > MONEY ? playerMoney-MONEY : MONEY - playerMoney) + ".");
		stdin.close();
	}

}
