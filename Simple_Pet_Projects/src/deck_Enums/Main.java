package deck_Enums;

public class Main {

	public static void main(String[] args) {
	
		Deck deck = new Deck();
		System.out.println();
	
		deck.drawOne();
		deck.drawOne();
		
		
		
		System.out.println();
		for (int i = 0; i < deck.getCards().length; i++) {
			System.out.println(deck.getCards()[i]);	
		}
		
		System.out.println();
		deck.shuffle();
		System.out.println();
		for (int i = 0; i < deck.getCards().length; i++) {
			System.out.println(deck.getCards()[i]);		
		}
		
		deck.shuffle();
		
		System.out.println();
		for (int i = 0; i < deck.getCards().length; i++) {
			System.out.println(deck.getCards()[i]);		
		}
		
		System.out.println(deck.drawOne());
		System.out.println();
		deck.shuffle();
		
		System.out.println();
		for (int i = 0; i < deck.getCards().length; i++) {
			System.out.println(deck.getCards()[i]);		
		}
		
		deck.order();
		System.out.println();
		for (int i = 0; i < deck.getCards().length; i++) {
			System.out.println(deck.getCards()[i]);	
		}
		
	}
	
	
	
}
