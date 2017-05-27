package deck_Enums;

import java.util.Random;

public class Deck {

	private Card [] cards;
	private int numberOfActiveCards;
	
	
	public Deck() {
		numberOfActiveCards = (Rank.values().length*Suit.values().length);
		this.cards = new Card[(Rank.values().length*Suit.values().length)];
		int a = 0;
		
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 0; j < Rank.values().length; j++) {
				cards[a] = new Card(Rank.values()[j], Suit.values()[i]);
				System.out.println(cards[a]+ "  ");
				a++;
			}
		}
		
	}
	
	
	public Card[] getCards() {
		return cards;
	}


	public void setCards(Card[] cards) {
		this.cards = cards;
	}


	public int getNumberOfActiveCards() {
		return numberOfActiveCards;
	}


	public void setNumberOfActiveCards(int numberOfActiveCards) {
		this.numberOfActiveCards = numberOfActiveCards;
	}


	public void shuffle() {
	
		Random random = new Random();
		int randomIndex = 0;
		
		for (int i = 0; i < numberOfActiveCards; i++) {
			while (randomIndex == i)
			randomIndex = random.nextInt(numberOfActiveCards);
			Card randomCard = cards[randomIndex];
			cards[randomIndex] = cards[i];
			cards[i] = randomCard;
			
		}
		
	}
	
	public void order() {
		
		for (int i = numberOfActiveCards-1; i >=0; i--) {
			boolean sorted = true;
			for (int j = 0; j < i; j++) {
				if ((compare(cards[j], cards[j+1])) > 0 ) {
					Card tempor = cards [j];
					cards[j] = cards[j+1];
					cards[j+1] = tempor;
					sorted = false;
				}
			}
			
			if (sorted) {
				break;
			}
		}
		

	}
	
	
	public boolean hasNext() {
	
		for (int i = numberOfActiveCards-1; i>= 0; i--) {
			if (numberOfActiveCards > 0 || cards[i] != null){
				return true;
			}
		}
		return false;
	}
	
	public Card drawOne() {
	  
		if (numberOfActiveCards <= 0){
			return null;
		} else if (numberOfActiveCards > 0) {
			Card tempor = cards[numberOfActiveCards-1];
			cards[numberOfActiveCards-1] = null;
			numberOfActiveCards--;
			return tempor;
		} else {
			return null;
		}
	   
	}
	
	private int compare(Card card1, Card card2){
		
		
		int card1SuitIndex = card1.getSuit().ordinal();
		int card2SuitIndex = card2.getSuit().ordinal();
		int card1RankIndex = card1.getRank().ordinal();
		int card2RankIndex = card2.getRank().ordinal();
		
		if (card1SuitIndex != card2SuitIndex)  {
			return card1SuitIndex-card2SuitIndex;
		} else {
				return card1RankIndex - card2RankIndex;
		}
		
		// if ((card1SuitIndex < card2SuitIndex) || (card1SuitIndex > card2SuitIndex)){
		//return card1SuitIndex-card2SuitIndex;}
		
		// else if (card1SuitIndex == card2SuitIndex;{
		//	return card1RankIndex - card2RankIndex;
		//	}
		
		
	}
	
	
	
	
	
}
