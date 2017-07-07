package ticTacToeGame;

public enum PlayerType {

	COMPUTER("ELEKTRONIK"), HUMAN;
	
	private String name;

	private PlayerType(String name) {
		this.name = name;
	}
	
	private PlayerType() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
