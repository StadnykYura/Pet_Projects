package ticTacToeGame;

public class Referee {

	
	public void proposeToMakeTurn() {
		System.out.println("Please, make your Turn");
	}
	
	public boolean checkIfTurnIsWinned(Move move, Board board){
		
	
		int countRow = 0;
		// Перевірка по Осі Х
		for (int j = 0; j < board.getBoardTable().length; j++) {
			if (board.getBoardTable() [move.getX()] [j] != null  
					&& board.getBoardTable() [move.getX()] [j] == (move.getActionFigure()) ) {
						countRow++;
					}
		}
		if (countRow == 3) {
			return true;
		} else {
			countRow = 0;
		}
		
		// Перевірка по Осі Y
		for (int i = 0; i < board.getBoardTable().length; i++) {
			if (board.getBoardTable() [i] [move.getY()] != null 
				&& board.getBoardTable() [i] [move.getY()] == (move.getActionFigure()) ) {
					countRow++;
				}
			
		}
		if (countRow == 3) {
			return true;
		} else {
			countRow = 0;
		}
		
		// Перевірка по діагоналі 45*, де адреса х та y двомірного масиву 3х3: 0.0, 1.1, 2.2 відповідно.
		if (move.getX() == move.getY()) {
			
			int i;
			int j;
			
				for ( i = 0, j = 0 ; i < board.getBoardTable().length; i++, j++) {
					if (board.getBoardTable() [i] [j] != null
							 && board.getBoardTable() [i] [j] == (move.getActionFigure())){
						countRow++;
					}
				}
				if (countRow == 3) {
					return true;
				} else {
					countRow = 0;
				}
		}
		
		// Перевірка по діагоналі 45*, де сума значень х та y =2: адреси 2.0, 1.1, 0.2 відповідно.
		if ((move.getX() + move.getY()) == 2){
			int i;
			int j;
			
				for ( i = 0, j = board.getBoardTable().length-1 ; i < board.getBoardTable().length; i++, j--) {
					if (board.getBoardTable() [i] [j] != null
							 && board.getBoardTable() [i] [j] == (move.getActionFigure())){
						countRow++;
					}
				}
				if (countRow == 3) {
					return true;
				} else {
					countRow = 0;
				}
		}
		
		
		
		return false;
	}

	public void putSignOnBoard(Move move, Board board){
		
		board.getBoardTable() [move.getX()] [move.getY()] = move.getActionFigure();
		
		
	}
	

	
	
}
