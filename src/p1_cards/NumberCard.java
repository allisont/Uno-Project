//package p1_cards;
//
//import java.util.Objects;
//
//public class NumberCard implements CardType{
//	private static final long serialVersionUID = 1L;
//	private int number;
//	
//	public NumberCard(int number) {
//		this.number = number;
//	}
//	
//	public Integer getNumber() {
//		return number;
//	}
//	public void setNumber(Integer number) {
//		this.number = number;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(number);
//	}
//
//	@Override
//	public String toString() {
//		return "Number " + number;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		NumberCard other = (NumberCard) obj;
//		return number == other.number;
//	}
//
//	
//	
//}
