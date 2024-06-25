package p1_cards;

import java.io.Serializable;

public class Card implements Serializable{
	private static final long serialVersionUID = 1L;
	private CardType type; //different card types: number
	private String color;
	
	public Card(CardType type, String color) {
		this.type = type;
		this.color = color;
	}
	
	public CardType getCardType() {
		return type;
	}
	
	public void setCardType(CardType type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		if (color != null) {
			return type + " | " + color;
		} else {
			return type.toString();
		}
	}
	
	

}

