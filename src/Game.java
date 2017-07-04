import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Game {
	public static void main(String[] args) {
		ArrayList<Card> deck = Card.getDeck();
		deck = shuffle(deck);
		
		int numPlayers = Integer.parseInt(JOptionPane.showInputDialog("How many players?"));
		Player[] players = new Player[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			players[i] = new Player(deck);
		}
		
		Player dealer = new Player(deck);
		JOptionPane.showMessageDialog(null, "Show the screen to all players");
		
		String message = "";
		for (int i = 0; i < numPlayers; i++) {
			message += "Player " + i + " drew the " + players[i].getCards().get(1).toString() + ". ";
		}
		message += "The dealer drew the " + dealer.getCards().get(1).toString();
		JOptionPane.showMessageDialog(null, message);
		
		for (int i = 0; i < numPlayers; i++) {
			JOptionPane.showMessageDialog(null, "Show the screen to player " + i);
			
			while (true) {
				int choice = JOptionPane.showOptionDialog(null, "Your " + players[i].toString() + "Would you like to hit?" , "Hit or Stay", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (choice == 0) { // hit
					players[i].hit(deck);
					if (players[i].isBust()) {
						break;
					}
				} else {
					break;
				}
			}
			if (players[i].isBust()) {
				JOptionPane.showMessageDialog(null, "Your " + players[i].toString() + " You busted.");
			}
			JOptionPane.showMessageDialog(null, "Your final score is " + players[i].getScore() + ".");
			 
		}
		
		JOptionPane.showMessageDialog(null, "Show the screen to all players");
		String dealerActions = "The dealer's " + dealer.toString();
		while (dealer.shouldHit()) {
			dealer.hit(deck);
			if (dealer.isBust()) {
				dealerActions += "The dealer hit. The dealer's " + dealer.toString() + "The dealer busted.";
				break;
			} else {
				dealerActions += "The dealer hit. The dealer's " + dealer.toString();
			}
		}
		
		if (!dealer.isBust()) {
			dealerActions += "The dealer's final score is " + dealer.getScore() + ".";
		}
		
		JOptionPane.showMessageDialog(null, dealerActions);
		
		String winnerLoser = "";
		for (int i = 0; i < numPlayers; i++) {
			if (!players[i].isBust() && (dealer.isBust() || players[i].getScore() > dealer.getScore())) {
				winnerLoser += "Player " + i + " won. ";
			} else if (!players[i].isBust() && !dealer.isBust() && players[i].getScore() == dealer.getScore()) {
				winnerLoser += "Player " + i + " tied. ";
			} else {
				winnerLoser += "Player " + i + " lost. ";
			}
		}
		JOptionPane.showMessageDialog(null, winnerLoser);

		

	}
	
	public static ArrayList<Card> shuffle(ArrayList<Card> deck) {
		ArrayList<Card> newDeck = new ArrayList<>();
		while (deck.size() > 0) {
			int randIndex = (int) (Math.random() * deck.size());
			newDeck.add(deck.remove(randIndex));
		}
		return newDeck;
	}
}
