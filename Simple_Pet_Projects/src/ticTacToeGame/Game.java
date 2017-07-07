package ticTacToeGame;

import java.io.IOException;

public class Game {

	public static int numberOfMoves = 1;

	public static void main(String[] args) {

		Referee referee = new Referee();

		Player player1 = new Player(ActionFigure.CROSS, PlayerType.HUMAN);
		Player player2 = new Player(ActionFigure.NOUGHT, PlayerType.COMPUTER);

		Board board = new Board();
		System.out.println(board.getBoardTable().length);
		Player[] players = { player1, player2 };

		
			while (board.hasMoreSpace()) {

				try {
					if (Game.turnAndPut(board, referee, players)) {
						break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// if (!board.hasMoreSpace()){
				// System.out.println("Гра завершилась нічиєю");
				// }
				// Move move1 = player1.turn(board);
				// referee.putSignOnBoard(move1, board);
				// board.printBoard();
				// System.out.println();
				// if (referee.checkIfTurnIsWinned(move1, board)){
				// System.out.println("Вітаємо, гравець №1 Переміг");
				// break;
				// } else if (!board.hasMoreSpace()){
				// System.out.println("Гра завершилась нічиєю");
				// }
				//
				// Move move2 = player2.turn(board);
				// referee.putSignOnBoard(move2, board);
				// board.printBoard();
				// System.out.println();
				// if (referee.checkIfTurnIsWinned(move2, board)){
				// System.out.println("Вітаємо, гравець №2 Переміг");
				// break;
				// } else if (!board.hasMoreSpace()){
				// System.out.println("Гра завершилась нічиєю");
				// }

			}
		
	}

	public static boolean turnAndPut(Board board, Referee referee, Player[] players)
			throws NumberFormatException, IOException {
		boolean gameIsOver = false;

		for (int i = 0; i < players.length; i++) {
			Move move = players[i].turn(board);
			referee.putSignOnBoard(move, board);
			System.out.println("Гравець, що грає фігурою '" + move.getActionFigure().getSign() + "', здійснив свій "
					+ numberOfMoves + "-й хід" + "\n" + "Результат ходу");
			System.out.println();
			board.printBoard();
			System.out.println();
			if (referee.checkIfTurnIsWinned(move, board)) {
				System.out.println("Вітаємо, гравець, що грає фігурою \"" + players[i].getActionFigure().getSign()
						+ "\", переміг");
				gameIsOver = true;
				break;
			} else if (!board.hasMoreSpace()) {
				System.out.println("Гра завершилась нічиєю");
				gameIsOver = true;
				break;
			}

		}
		numberOfMoves++;
		return gameIsOver;

	}

}
