package ticTacToeGame;

public class Referee {

	public void proposeToMakeTurn() {
		System.out.println("Please, make your Turn");
	}

	public boolean checkIfTurnIsWinned(Move move, Board board) {

		int countRow = 0;
		// Перевірка по Осі Х
		for (int j = 0; j < board.getBoardTable()[move.getX()].length; j++) {
			if (board.getBoardTable()[move.getX()][j] != null
					&& board.getBoardTable()[move.getX()][j] == (move.getActionFigure())) {
				countRow++;
			}
		}
		if (countRow == board.getBoardTable()[move.getX()].length) {
			return true;
		} else {
			countRow = 0;
		}

		// Перевірка по Осі Y
		for (int i = 0; i < board.getBoardTable().length; i++) {
			if (board.getBoardTable()[i][move.getY()] != null
					&& board.getBoardTable()[i][move.getY()] == (move.getActionFigure())) {
				countRow++;
			}

		}
		if (countRow == board.getBoardTable().length) {
			return true;
		} else {
			countRow = 0;
		}

		// Ці 2 перевірки, що нижче, здійснювати лише для доски рівного
		// двовимірного масиву де boardTable розміром 3x3, 4x4, 5x5..

		if (board.getBoardTable().length == board.getBoardTable()[0].length) {
			
			// Перевірка по діагоналі 45*, де адреса х = y:
			// наприклад для масиву 3х3: адреси полів 0.0, 1.1, 2.2 відповідно.
			// наприклад для масиву 4х4: адреси полів 0.0, 1.1, 2.2, 3.3 відповідно.
			// наприклад для масиву 5х5: адреси полів 0.0, 1.1, 2.2, 3.3, 4.4
			// відповідно.
			
			if (move.getX() == move.getY()) {

				int i;
				int j;

				for (i = 0, j = 0; i < board.getBoardTable().length; i++, j++) {
					if (board.getBoardTable()[i][j] != null
							&& board.getBoardTable()[i][j] == (move.getActionFigure())) {
						countRow++;
					}
				}
				if (countRow == board.getBoardTable().length) {
					return true;
				} else {
					countRow = 0;
				}
			}

			// Перевірка по діагоналі 45*, де сума значень х та y = board.getBoardTable().length-1:
			// наприклад для 3х3 масиву сума значень полів 2: адреси полів 2.0, 1.1, 0.2 відповідно.
			// наприклад для 4х4 масиву сума значень полів 3: адреси полів 3.0, 2.1, 1.2, 0.3 відповідно.
			// наприклад для 5х5 масиву сума значень полів 4: адреси полів 4.0, 3.1, 2.2, 1.3, 0.4 відповідно.

			if ((move.getX() + move.getY()) == board.getBoardTable().length - 1) {
				int i;
				int j;

				for (i = 0, j = board.getBoardTable().length - 1; i < board.getBoardTable().length; i++, j--) {
					if (board.getBoardTable()[i][j] != null
							&& board.getBoardTable()[i][j] == (move.getActionFigure())) {
						countRow++;
					}
				}
				if (countRow == board.getBoardTable().length) {
					return true;
				} else {
					countRow = 0;
				}
			}
		}

		return false;
	}

	public void putSignOnBoard(Move move, Board board) {

		board.getBoardTable()[move.getX()][move.getY()] = move.getActionFigure();

	}

}
