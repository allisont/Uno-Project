package p1_cards;

import java.util.Objects;

public class ColorSwapCard implements CardType{

	private static final long serialVersionUID = 1L;
	private String colorSwap;
	
	public ColorSwapCard() {

	}
	
	public ColorSwapCard(String colorSwap) {
		this.colorSwap = colorSwap;
	}

	public String getColorSwap() {
		return colorSwap;
	}

	public void setColorSwap(String colorSwap) {
		this.colorSwap = colorSwap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colorSwap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorSwapCard other = (ColorSwapCard) obj;
		return Objects.equals(colorSwap, other.colorSwap);
	}

	@Override
	public String toString() {
		return "Color Swap";
	}
	
	
}
