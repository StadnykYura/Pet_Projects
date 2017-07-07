package ticTacToeGame;

public class Move {

	private int x;
	private int y;
	private ActionFigure actionFigure;
	
	
	public Move(int x, int y, ActionFigure actrionFigure) {
		this.x = x;
		this.y = y;
		this.actionFigure = actrionFigure;
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ActionFigure getActionFigure() {
		return actionFigure;
	}


	public void setActionFigure(ActionFigure actionFigure) {
		this.actionFigure = actionFigure;
	}

	


	
	
	
	
}
