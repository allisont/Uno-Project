package p3_main;

import p2_deck.Deck;
import p2_deck.PlayerHand;

public class Demo {

	public static void main(String[] args) {
		Deck deck = Deck.getInstance();
		
		PlayerHand allison = new PlayerHand();
		deck.dealCards(allison);
		
		

	}

}
