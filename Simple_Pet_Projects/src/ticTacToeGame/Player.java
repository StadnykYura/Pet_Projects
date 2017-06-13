package ticTacToeGame;

import java.util.Random;

public class Player {

	private ActionFigure actrionFigure;


	public Player(ActionFigure actrionFigure) {
		
		this.actrionFigure = actrionFigure;
	}
	
	
	public Move turn(Board board){
	
		Random randomCoord = new Random();
		int x;
		int y;
		x = randomCoord.nextInt(board.getBoardTable().length);
		y = randomCoord.nextInt(board.getBoardTable()[x].length);
		while (board.getBoardTable() [x] [y] != null) {
			x = randomCoord.nextInt(board.getBoardTable().length);
			y = randomCoord.nextInt(board.getBoardTable().length);			
		}
		
		return new Move(x, y, this.actrionFigure);
	}


	public ActionFigure getActrionFigure() {
		return actrionFigure;
	}








	
	
	
}
