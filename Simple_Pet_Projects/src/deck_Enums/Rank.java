package deck_Enums;

public enum Rank {

	 ACE("Ace"), KING("King"), QUEEN("Queen"), JACK("Jack"), 
	 TEN("10"), NINE("9"), EIGHT("8"), SEVEN("7"), SIX("6");
	
	private String name;

	private Rank(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
