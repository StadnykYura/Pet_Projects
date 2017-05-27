package ticTacToeGame;

public enum ActionFigure {

	CROSS("X"), NOUGHT("O");
	
	
	private String sign;

	private ActionFigure(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
	
	
}
