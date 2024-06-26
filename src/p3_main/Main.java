package p3_main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import p1_cards.Card;
import p1_cards.CardType;
import p1_cards.Color;
import p1_cards.ColorSwapCard;
import p1_cards.PlusFourCard;
import p1_cards.PlusTwoCard;
import p1_cards.ReverseCard;
import p1_cards.SkipCard;
import p2_deck.Deck;
import p2_deck.PlayerHand;

public class Main {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//create deck and players hands
		Deck deck = Deck.getInstance();
		
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
				
		Card currentCard = deck.getDeck().get(0); //removes card
		deck.returnCard(currentCard); //places card in reshuffle pile
		CardType currentCardType = currentCard.getCardType();
		Color currentColor = currentCard.getColor();
		
		System.out.println("\nThe card being played is: " + currentCard + "\n");

		while(playerHand.getSize()>0 && npcHand.getSize()>0) {
			if (deck.getSize() == 0) {
				deck.reshuffleDeck();
			}
			
			
		//game.returnPlayerCard(idx);
		//game.returnNpcCard(idx);
		//game.getCurrentCard() { have a stack (FILO), only pop the most recent
		//game.reshuffleDeck() { stream stack into deck.
		
			
			while (playerHand.getSize()>0 && npcHand.getSize()>0) {
				System.out.println("Your cards are: \n");
				int i = 0;
				for (; i<playerHand.getSize(); i++) {
					if (validateCardChoice(playerHand.getCard(i), currentCard, currentColor)) {
						System.out.println("\u001B[32m" + (i+1) + ". " + playerHand.getHand().get(i).toString() + "\u001B[0m");
						playerHand.setIsPlayable(true);
					} else {
						System.out.println((i+1) + ". " + playerHand.getHand().get(i).toString());

					}
			
				}
				
				while (!playerHand.isPlayable()) {
					Card newCard = deck.getCard();
					playerHand.addCard(newCard);
					try {
						TimeUnit.MILLISECONDS.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (validateCardChoice(newCard, currentCard,currentColor)) {
						System.out.println("\u001B[32m" + (++i) + ". " + newCard.toString() + "\u001B[0m");
						playerHand.setIsPlayable(true);
						break;
					} else {
						System.out.println((++i) + ". " + newCard.toString());
					}
				}
				
				while (true) {
					try {
						System.out.println("Choose the card you want to play: "); //replace
						int chosenIdx = Integer.parseInt(sc.nextLine())-1;
						Card chosenCard = playerHand.getCard(chosenIdx);
						if (!validateCardChoice(chosenCard, currentCard, currentColor)) {
							throw new Exception();
						}
						currentCard = playerHand.chooseCard(chosenIdx);
						currentCardType = currentCard.getCardType();
						if (!currentColor.equals(Color.BLACK)) {
							currentColor = currentCard.getColor();
						}
						break;
					} catch (Exception e) {
						System.out.println("Choose a valid card");
					}
				}
				
	
				deck.returnCard(currentCard);
				
				System.out.println("\nThe card you chose was: " + currentCard);
				
				//color swap and plus 4
				if (currentCardType.getClass().equals(ColorSwapCard.class) ||
						currentCardType.getClass().equals(PlusFourCard.class)) {
					System.out.println("Choose the color to swap to: Red, Yellow, Green, Blue");
					currentColor = colorSwap();
					System.out.println("The new color is: " + currentColor);
				}
				
				//plus two and plus 4
				if (currentCardType.getClass().equals(PlusTwoCard.class)) {
					addCards(npcHand, 2);
				} else if (currentCardType.getClass().equals(PlusFourCard.class)) {
					addCards(npcHand, 4);
				}
				
				playerHand.setIsPlayable(false);
				
				//swap
				if (currentCardType.getClass().equals(ReverseCard.class) ||
						currentCardType.getClass().equals(SkipCard.class)) {
					continue;
				}
				break;
			}
			
			while (true) {
				int i = 0;
				for (; i<npcHand.getSize(); i++) {
					if (validateCardChoice(npcHand.getCard(i), currentCard, currentColor)) {
						currentCard = npcHand.chooseCard(i);
						currentCardType = currentCard.getCardType();
						currentColor = currentCard.getColor();
						deck.returnCard(currentCard);
						
						npcHand.setIsPlayable(true);
						break;
					}
				}
				
				while (!npcHand.isPlayable()) {
					try {
						TimeUnit.MILLISECONDS.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("The other player picks up a card.");
					Card newCard = deck.getCard();
					npcHand.addCard(newCard);
					
					if (validateCardChoice(newCard, currentCard, currentColor)) {
						
						currentCard = npcHand.chooseCard(npcHand.getSize()-1);
						currentCardType = currentCard.getCardType();
						if (!currentColor.equals(Color.BLACK)) {
							currentColor = currentCard.getColor();
						}						
						deck.returnCard(currentCard);
						npcHand.isPlayable();
						break;
					}
				}
				
				try {
					TimeUnit.MILLISECONDS.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("\nThe card being played is: " + currentCard);
				System.out.println("The other player has " + npcHand.getSize() + " cards left.\n");
				
				//color swap and plus 4
				if (currentCardType.getClass().equals(ColorSwapCard.class) ||
						currentCardType.getClass().equals(PlusFourCard.class)) {
					int randInt = (int)Math.random()*4;
					if (randInt==0) {
						currentColor = Color.RED;
					} else if (randInt==1) {
						currentColor = Color.YELLOW;
					} else if (randInt==2) {
						currentColor = Color.GREEN;
					} else {
						currentColor = Color.BLUE;
					}
					System.out.println("The new color is: " + currentColor + "\n");
				}
				
				//plus two and plus 4
				if (currentCardType.getClass().equals(PlusTwoCard.class)) {
					addCards(playerHand, 2);
				} else if (currentCardType.getClass().equals(PlusFourCard.class)) {
					addCards(playerHand, 4);
				}
				
				npcHand.setIsPlayable(false);
				
				//swap
				if (currentCardType.getClass().equals(ReverseCard.class) ||
						currentCardType.getClass().equals(SkipCard.class)) {
					continue;
				}
				break;
			}
									
		}
		
		sc.close();
	}
	
	public static Color colorSwap() {
		while (true) {
			try {
				return Color.valueOf(sc.nextLine().trim().toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println("Choose a valid color");
			}
		}
	}
	
	public static void addCards(PlayerHand hand, int numberOfCards) {
		for (int i = 0; i<numberOfCards; i++) {
			hand.addCard(Deck.getInstance().getCard());
		}
	}
	
	public static boolean validateCardChoice(Card chosenCard, Card currentCard, Color currentColor) {
		if (currentCard.getColor().equals(Color.BLACK) && chosenCard.getColor().equals(currentColor)) {
			// if a black card, then choose based on new color alone
			return true;
		} else
			//otherwise choose based on cardtype, color, or any black
			if (chosenCard.getCardType().getClass() != currentCard.getCardType().getClass() && 
			!chosenCard.getColor().equals(currentCard.getColor()) &&
			!chosenCard.getColor().equals(Color.BLACK)) {
				return false;
			} 
		return true;
		
	}

}
