import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> cards;
	
	public Player(ArrayList<Card> deck) {
		cards = new ArrayList<>();
		cards.add(deck.remove(deck.size() - 1));
		cards.add(deck.remove(deck.size() - 1));
	}
	
	/**
	 * First card is face down, rest are face up
	 * @return arraylist of cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void hit(ArrayList<Card> deck) {
		cards.add(deck.remove(deck.size() - 1));
	}
	
	public int getScore() {
		
		int score = 0;
		boolean hasAce = false;
		
		for (Card c : cards) {
			score += c.getValue();
			hasAce = hasAce || c.isAce();
		}
		
		if (score <= 11 && hasAce) {
			score += 10;
		}
		
		return score;
		
	}
	
	public boolean isBust() {
		return getScore() > 21;
	}
	
	public boolean shouldHit() {
		return getScore() < 17;
	}
	
	@Override
	public String toString() {
		String name = "cards are ";
		for (int i = 0; i < cards.size(); i++) {
			name += cards.get(i).toString();	
			if (i < cards.size() - 1) {
				name += ", ";
			} else { 
				name += ". ";
			}
		}
		return name;
	}
	
}
