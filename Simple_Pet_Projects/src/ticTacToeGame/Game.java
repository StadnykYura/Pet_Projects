package ticTacToeGame;

public class Game {

	public static void main(String[] args) {
		
		Referee referee = new Referee();
		
		
		Player player1 = new Player(ActionFigure.CROSS);
		Player player2 = new Player(ActionFigure.NOUGHT);
		
		Board board = new Board();
		System.out.println(board.getBoardTable().length);
		Player [] players = {player1, player2};
	
		
		while (board.hasMoreSpace()){
			
			if (Game.turnAndPut(board, referee, players)){
				break;
			}
//			if (!board.hasMoreSpace()){
//				System.out.println("Гра завершилась нічиєю");
//			}
//			Move move1 = player1.turn(board);
//			referee.putSignOnBoard(move1, board);
//			board.printBoard();
//			System.out.println();
//			if (referee.checkIfTurnIsWinned(move1, board)){
//				System.out.println("Вітаємо, гравець №1 Переміг");
//				break;
//			} else if (!board.hasMoreSpace()){
//				System.out.println("Гра завершилась нічиєю");
//			}
//			
//			Move move2 = player2.turn(board);
//			referee.putSignOnBoard(move2, board);
//			board.printBoard();
//			System.out.println();
//			if (referee.checkIfTurnIsWinned(move2, board)){
//				System.out.println("Вітаємо, гравець №2 Переміг");
//				break;
//			} else if (!board.hasMoreSpace()){
//				System.out.println("Гра завершилась нічиєю");
//			}
			
		}
		
	}
	
	
	public static boolean turnAndPut(Board board, Referee referee, Player [] players){
		boolean gameIsOver = false;
		
			for (int i = 0; i < players.length; i++) {
				Move move = players[i].turn(board);
				referee.putSignOnBoard(move, board);
				board.printBoard();
				System.out.println();
				if (referee.checkIfTurnIsWinned(move, board)){
					System.out.println("Вітаємо, гравець, що грає фігурою \"" + players[i].getActrionFigure().getSign() + "\", переміг");
					gameIsOver = true;
					break;
				} else if (!board.hasMoreSpace()){
					System.out.println("Гра завершилась нічиєю");
					gameIsOver = true;
					break;
				}
				
			}
	
		return gameIsOver;
	
	}
	
	
}
