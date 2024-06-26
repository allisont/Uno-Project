package p1_cards;

import java.io.Serializable;

public class Card implements Serializable{
	private static final long serialVersionUID = 1L;
	private CardType type; //different card types: number
	private Color color;
	
	public Card(CardType type, Color color) {
		this.type = type;
		this.color = color;
	}
	
	public CardType getCardType() {
		return type;
	}
	
	public void setCardType(CardType type) {
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		if (color.equals(Color.BLACK)) {
			return type.toString();
		} else {
			return type + " | " + color;
		}
	}
	
	

}

