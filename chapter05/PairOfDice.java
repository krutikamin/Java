package chapter05;

public class PairOfDice {
	
	private int die1;
	private int die2;
	
	public PairOfDice() {
		roll();
	}
	
	public PairOfDice(int val1, int val2) {
		die1 = val1;
		die2 = val2;
	}
	
	public void roll() {
		die1 = (int)(Math.random() * 6) + 1;
		die2 = (int)(Math.random() * 6) + 1;
	}
	
	public int getDie1Value() {
		return die1;
	}
	
	public int getDie2Value() {
		return die2;
	}
}