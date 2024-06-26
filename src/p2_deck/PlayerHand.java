package p2_deck;

import java.util.ArrayList;
import java.util.Objects;

import p1_cards.Card;

public class PlayerHand {
	
	private ArrayList<Card> hand;
	private int size;
	private boolean isPlayable;
	
	public PlayerHand() {
		hand = new ArrayList<>();
		size = 0;
		isPlayable = false;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public int getSize() {
		return size;
	}
	
	public Card chooseCard(int idx) {
		size--;
		return hand.remove(idx);
	}
	
	public Card getCard(int idx) {
		return hand.get(idx);
	}
	
	public void addCard(Card card) {
		hand.add(card);
		size++;
	}

	public boolean isPlayable() {
		return isPlayable;
	}

	public void setIsPlayable(boolean isPlayable) {
		this.isPlayable = isPlayable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hand, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerHand other = (PlayerHand) obj;
		return Objects.equals(hand, other.hand) && size == other.size;
	}

	@Override
	public String toString() {
		return hand.toString();
	}
	
	
	
	
}
