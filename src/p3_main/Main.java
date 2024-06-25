package p3_main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import p1_cards.Card;
import p1_cards.CardType;
import p2_deck.Deck;
import p2_deck.PlayerHand;

public class Main {
	
	public static void main(String[] args) {
		//create deck and players hands
		Deck deck = Deck.getInstance();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Uno! \nWhat is your name? ");
		String playerName = sc.nextLine();
		
		System.out.println("\nWelcome " + playerName + "! Press enter to begin.");
		String enter = "enter";
		while (!(enter.equals(""))) {
			enter = sc.nextLine();
		}
		
		for (int i = 0; i<"beginning...\n".length(); i++) {
			System.out.print("BEGINNING...\n".charAt(i));
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		PlayerHand playerHand = new PlayerHand();
		PlayerHand npcHand = new PlayerHand();
		
		deck.dealCards(playerHand);
		deck.dealCards(npcHand);
				
		Card currentCard = npcHand.chooseCard(1);
//		
//		while(playerHand.getSize()>0 && npcHand.getSize()>0) {
//			if (deck.getSize() == 0) {
//				deck.reshuffleDeck();
//			}
//			
//			//1. print players cards
//			//2. ask player to play a card
//			//3. update current card on deck
//			//4. ask npc to play a card
//			//5. update current card on deck
			
			CardType currentCardType = currentCard.getCardType();
			String currentColor = currentCard.getColor();
			System.out.println(currentCard);
			System.out.println(currentCardType.getClass());
			
			System.out.println("Your cards are: \n");
			for (int i = 0; i<playerHand.getSize(); i++) {
				if (currentCardType.getClass() == playerHand.getCard(i).getCardType().getClass() ||
						currentColor.equals(playerHand.getCard(i).getColor())) {
					System.out.println("\u001B[32m" + (i+1) + " " + playerHand.getHand().get(i).toString() + "\u001B[0m");
				} else {
					System.out.println((i+1) + " " + playerHand.getHand().get(i).toString());

				}
		
			}
			
			
			
		
			
			
			
//		}
		
		sc.close();
	}

}
