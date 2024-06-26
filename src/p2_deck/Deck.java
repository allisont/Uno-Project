package p2_deck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import p1_cards.ColorSwapCard;
import p1_cards.Number0Card;
import p1_cards.Number1Card;
import p1_cards.Number2Card;
import p1_cards.Number3Card;
import p1_cards.Number4Card;
import p1_cards.Number5Card;
import p1_cards.Number6Card;
import p1_cards.Number7Card;
import p1_cards.Number8Card;
import p1_cards.Number9Card;
import p1_cards.PlusFourCard;
import p1_cards.PlusTwoCard;
import p1_cards.ReverseCard;
import p1_cards.SkipCard;
import p1_cards.Card;
import p1_cards.Color;

public class Deck implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Card> deck;
	private ArrayList<Card> reshufflePile;
	private int size;
	
	private static Deck INSTANCE;
	private static Object obj = new Object();
	
	private Deck() {
		size = 108;
		deck = new ArrayList<>();
		reshufflePile = new ArrayList<>();
		
		createDeck();		
	}
	
	public static Deck getInstance() {
		if (INSTANCE == null) {
			synchronized(obj) {
				INSTANCE = new Deck();
				saveDeck();
			}
		}
		return INSTANCE;
	}
	
	public void reshuffleDeck() {
		size = reshufflePile.size();
		deck = new ArrayList<>(reshufflePile);
		reshufflePile.clear();
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public Card getCard() {
		if (size == 0) {
			reshuffleDeck();
		}
		return deck.remove((int)(Math.random()*size--));
	}
	
	public int getSize() {
		return size;
	}
	
	public void returnCard(Card card) {
		reshufflePile.add(card);
	}
	
	public void dealCards(PlayerHand hand) {
		for(int i = 0; i<7; i++) {
			hand.addCard(getCard());
			
		}
	}
	
	private static void loadDeck() {
		if (Files.exists(Paths.get("./deck.dat"))) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./deck.dat"))) {
				 INSTANCE = (Deck) ois.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} 
	}
	
	private static void saveDeck() {
		if (!Files.exists(Paths.get("./deck.dat"))) {
	        try {
				Files.createFile(Paths.get("./deck.dat"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./deck.dat"))) {
	            oos.writeObject(INSTANCE);
	        } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void createDeck() {
		
//		//NUMBER CARDS
//		int number = 0;
//		for (int i = 0; i<19; i++) { //red cards
//			if (number == 10) {
//				number = 1;
//			}
//			deck.add(new Card(new NumberCard(number++), "Red"));
//		}
//		
//		number = 0;
//		for (int i = 0; i<19; i++) { //yellow cards
//			if (number == 10) {
//				number = 1;
//			}
//			deck.add(new Card(new NumberCard(number++), "Yellow"));
//		}
//		
//		number = 0;
//		for (int i = 0; i<19; i++) { //blue cards
//			if (number == 10) {
//				number = 1;
//			}
//			deck.add(new Card(new NumberCard(number++), "Blue"));
//		}
//		
//		number = 0;
//		for (int i = 0; i<19; i++) { //green cards
//			if (number == 10) {
//				number = 1;
//			}
//			deck.add(new Card(new NumberCard(number++), "Blue"));
//		}
		
		for (int i = 0; i<=9; i++) {
			if (i==0) {
				deck.add(new Card(new Number0Card(), Color.RED));
				deck.add(new Card(new Number0Card(), Color.YELLOW));
				deck.add(new Card(new Number0Card(), Color.GREEN));
				deck.add(new Card(new Number0Card(), Color.BLUE));

			} else if (i==1) {
				deck.add(new Card(new Number1Card(), Color.RED));
				deck.add(new Card(new Number1Card(), Color.YELLOW));
				deck.add(new Card(new Number1Card(), Color.GREEN));
				deck.add(new Card(new Number1Card(), Color.BLUE));
				deck.add(new Card(new Number1Card(), Color.RED));
				deck.add(new Card(new Number1Card(), Color.YELLOW));
				deck.add(new Card(new Number1Card(), Color.GREEN));
				deck.add(new Card(new Number1Card(), Color.BLUE));
			} else if (i==2) {
				deck.add(new Card(new Number2Card(), Color.RED));
				deck.add(new Card(new Number2Card(), Color.YELLOW));
				deck.add(new Card(new Number2Card(), Color.GREEN));
				deck.add(new Card(new Number2Card(), Color.BLUE));
				deck.add(new Card(new Number2Card(), Color.RED));
				deck.add(new Card(new Number2Card(), Color.YELLOW));
				deck.add(new Card(new Number2Card(), Color.GREEN));
				deck.add(new Card(new Number2Card(), Color.BLUE));
			} else if (i==3) {
				deck.add(new Card(new Number3Card(), Color.RED));
				deck.add(new Card(new Number3Card(), Color.YELLOW));
				deck.add(new Card(new Number3Card(), Color.GREEN));
				deck.add(new Card(new Number3Card(), Color.BLUE));
				deck.add(new Card(new Number3Card(), Color.RED));
				deck.add(new Card(new Number3Card(), Color.YELLOW));
				deck.add(new Card(new Number3Card(), Color.GREEN));
				deck.add(new Card(new Number3Card(), Color.BLUE));
			} else if (i==4) {
				deck.add(new Card(new Number4Card(), Color.RED));
				deck.add(new Card(new Number4Card(), Color.YELLOW));
				deck.add(new Card(new Number4Card(), Color.GREEN));
				deck.add(new Card(new Number4Card(), Color.BLUE));
				deck.add(new Card(new Number4Card(), Color.RED));
				deck.add(new Card(new Number4Card(), Color.YELLOW));
				deck.add(new Card(new Number4Card(), Color.GREEN));
				deck.add(new Card(new Number4Card(), Color.BLUE));
			} else if (i==5) {
				deck.add(new Card(new Number5Card(), Color.RED));
				deck.add(new Card(new Number5Card(), Color.YELLOW));
				deck.add(new Card(new Number5Card(), Color.GREEN));
				deck.add(new Card(new Number5Card(), Color.BLUE));
				deck.add(new Card(new Number5Card(), Color.RED));
				deck.add(new Card(new Number5Card(), Color.YELLOW));
				deck.add(new Card(new Number5Card(), Color.GREEN));
				deck.add(new Card(new Number5Card(), Color.BLUE));
			} else if (i==6) {
				deck.add(new Card(new Number6Card(), Color.RED));
				deck.add(new Card(new Number6Card(), Color.YELLOW));
				deck.add(new Card(new Number6Card(), Color.GREEN));
				deck.add(new Card(new Number6Card(), Color.BLUE));
				deck.add(new Card(new Number6Card(), Color.RED));
				deck.add(new Card(new Number6Card(), Color.YELLOW));
				deck.add(new Card(new Number6Card(), Color.GREEN));
				deck.add(new Card(new Number6Card(), Color.BLUE));
			} else if (i==7) {
				deck.add(new Card(new Number7Card(), Color.RED));
				deck.add(new Card(new Number7Card(), Color.YELLOW));
				deck.add(new Card(new Number7Card(), Color.GREEN));
				deck.add(new Card(new Number7Card(), Color.BLUE));
				deck.add(new Card(new Number7Card(), Color.RED));
				deck.add(new Card(new Number7Card(), Color.YELLOW));
				deck.add(new Card(new Number7Card(), Color.GREEN));
				deck.add(new Card(new Number7Card(), Color.BLUE));
			} else if (i==8) {
				deck.add(new Card(new Number8Card(), Color.RED));
				deck.add(new Card(new Number8Card(), Color.YELLOW));
				deck.add(new Card(new Number8Card(), Color.GREEN));
				deck.add(new Card(new Number8Card(), Color.BLUE));
				deck.add(new Card(new Number8Card(), Color.RED));
				deck.add(new Card(new Number8Card(), Color.YELLOW));
				deck.add(new Card(new Number8Card(), Color.GREEN));
				deck.add(new Card(new Number8Card(), Color.BLUE));
			} else if (i==9) {
				deck.add(new Card(new Number9Card(), Color.RED));
				deck.add(new Card(new Number9Card(), Color.YELLOW));
				deck.add(new Card(new Number9Card(), Color.GREEN));
				deck.add(new Card(new Number9Card(), Color.BLUE));
				deck.add(new Card(new Number9Card(), Color.RED));
				deck.add(new Card(new Number9Card(), Color.YELLOW));
				deck.add(new Card(new Number9Card(), Color.GREEN));
				deck.add(new Card(new Number9Card(), Color.BLUE));
			}
		}
		
		//swap 4 
		for (int i = 0; i<4; i++) {
			deck.add(new Card(new PlusFourCard(), Color.BLACK));
		}
		
		//swap
		for (int i = 0; i<4; i++) {
			deck.add(new Card(new ColorSwapCard(), Color.BLACK));
		}
		
		//skip
		deck.add(new Card(new SkipCard(), Color.RED));
		deck.add(new Card(new SkipCard(), Color.RED));
		deck.add(new Card(new SkipCard(), Color.YELLOW));
		deck.add(new Card(new SkipCard(), Color.YELLOW));
		deck.add(new Card(new SkipCard(), Color.GREEN));
		deck.add(new Card(new SkipCard(), Color.GREEN));
		deck.add(new Card(new SkipCard(), Color.BLUE));
		deck.add(new Card(new SkipCard(), Color.BLUE));
		
		//reverse
		deck.add(new Card(new ReverseCard(), Color.RED));
		deck.add(new Card(new ReverseCard(), Color.RED));
		deck.add(new Card(new ReverseCard(), Color.YELLOW));
		deck.add(new Card(new ReverseCard(), Color.YELLOW));
		deck.add(new Card(new ReverseCard(), Color.GREEN));
		deck.add(new Card(new ReverseCard(), Color.GREEN));
		deck.add(new Card(new ReverseCard(), Color.BLUE));
		deck.add(new Card(new ReverseCard(), Color.BLUE));
		
		//+2
		deck.add(new Card(new PlusTwoCard(), Color.RED));
		deck.add(new Card(new PlusTwoCard(), Color.RED));
		deck.add(new Card(new PlusTwoCard(), Color.YELLOW));
		deck.add(new Card(new PlusTwoCard(), Color.YELLOW));
		deck.add(new Card(new PlusTwoCard(), Color.GREEN));
		deck.add(new Card(new PlusTwoCard(), Color.GREEN));
		deck.add(new Card(new PlusTwoCard(), Color.BLUE));
		deck.add(new Card(new PlusTwoCard(), Color.BLUE));
			
	}

}
