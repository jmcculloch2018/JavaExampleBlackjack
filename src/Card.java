import java.util.ArrayList;

public class Card {
	public static enum Suit {
		Clubs, Diamonds, Hearts, Spades
	}
	private Suit suit;
	private int number; // 1 = A, 11 = J, 12 = Q, 13 = K
	public Card(Suit suit, int number) {
		this.suit = suit;
		this.number = number;
	}
	public static ArrayList<Card> getDeck() {
		ArrayList<Card> deck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (int num = 1; num <= 13; num++) {
				deck.add(new Card(suit, num));
			}
		}
		return deck;
	}
	public String toString() {
		String name = "";
		switch (number) {
		case 1:
			name += "Ace";
			break;
		case 11:
			name += "Jack";
			break;
		case 12:
			name += "Queen";
			break;
		case 13:
			name += "King";
			break;
		default:
			name += number;
			break;
		}
		
		name += " of " + suit;
		return name;
	}
	
	public int getValue() {
		if (number >= 10) {
			return 10;
		} else {
			return number;
		}
	}
	
	public boolean isAce() {
		return number == 1;
	}
}
