package ticTacToeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Player {

	private ActionFigure actionFigure;
	private int countForMoves;
	private PlayerType playerType;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Player(ActionFigure actionFigure, PlayerType playerType) {

		this.actionFigure = actionFigure;
		this.countForMoves = 0;
		this.playerType = playerType;

	}

	// random moves AI vs AI
	// public Move turn(Board board) {
	//
	// if (board.hasMoreSpace()) {
	// Random randomCoord = new Random();
	// int x;
	// int y;
	// x = randomCoord.nextInt(board.getBoardTable().length);
	// y = randomCoord.nextInt(board.getBoardTable()[x].length);
	// while (board.getBoardTable()[x][y] != null) {
	// x = randomCoord.nextInt(board.getBoardTable().length);
	// y = randomCoord.nextInt(board.getBoardTable()[x].length);
	// }
	// return new Move(x, y, this.actionFigure);
	//
	// }
	// return null;
	// }

	// AI vs AI/HumanType with strategy for 3x3 board
	public Move turn(Board board) throws IOException {

		Random randomCoord = new Random();

		int x = -1;
		int y = -1;

		int countForFiguresInRow = 0;
		int countForXInCorners = 0;

		Move crossPlace;
		Move noughtPlace;
		Move possibleMove;

		while (true) {
			while (board.hasMoreSpace()) {

				// strategy for AI player (Winning or Drawing when Playing
				// First)
				if (this.playerType == PlayerType.COMPUTER) {
					switch (this.actionFigure) {
					case CROSS:
						switch (this.getCountForMoves()) {

						// move 1 (Play your first X in a corner)
						// randomly choosing coordinates for
						// 3x3 board between 0.0 || 0.2 || 2.2 || 2.0
						case 0:
							x = (randomCoord.nextInt(2) == 0) ? 0 : board.getBoardTable().length - 1;
							y = (randomCoord.nextInt(2) == 1) ? 0 : board.getBoardTable()[x].length - 1;
							this.countForMoves++;
							break;

						case 1:
							// Move 2
							// Try to win if your opponent plays the first Move
							// "O"
							// in the center.
							// Place your second X in the opposite corner from
							// your
							// first,
							// so there's a line going "X O X" diagonally across
							// theboard.
							// OR
							// place your second X on an edge square (not a
							// corner),
							// not touching your first X.\
							// So in this case program randomly choose position
							// between
							if (board.getBoardTable()[1][1] == ActionFigure.NOUGHT) {
								for (int i = 0; i < board.getBoardTable().length; i += 2) {
									for (int j = 0; j < board.getBoardTable().length; j += 2) {
										if (board.getBoardTable()[i][j] == ActionFigure.CROSS) {
											x = (i == 0) ? 1 + (int) (Math.random() * ((2 - 1) + 1))
													: (int) (Math.random() * ((1 - 0) + 1));
											if (x == 1 && j == 0) {
												y = 2;
											} else if ((x == 2) || (x == 0 && j == 0)) {
												y = 1 + (int) (Math.random() * ((2 - 1) + 1));
											} else if (x == 1 && j == 2) {
												y = 0;
												// } else if (x == 0 && j == 0){
												// y =
												// 1+(int)(Math.random()*((2-1)+1));
											} else if (x == 0 && j == 2) {
												y = (int) (Math.random() * ((1 - 0) + 1));
											}
											this.countForMoves++;
											return new Move(x, y, this.getActionFigure());
										}
									}
								}

								// Win automatically if your opponent plays his
								// first O
								// in any square besides the center.
								// Respond by putting your second X in any other
								// corner,
								// with an empty space in between the two X's.
							} else if (board.getBoardTable()[1][1] == null) {
								for (int i = 0; i < board.getBoardTable().length; i++) {
									for (int j = 0; j < board.getBoardTable()[i].length; j++) {
										if (board.getBoardTable()[i][j] == ActionFigure.NOUGHT) {
											do {
												if (i == 0) {
													x = 2;
													y = (randomCoord.nextInt(2) == 0) ? 0 : 2;
												} else if (j == 0) {
													x = (randomCoord.nextInt(2) == 0) ? 0 : 2;
													y = 2;
												} else if (i == 2) {
													x = 0;
													y = (randomCoord.nextInt(2) == 0) ? 0 : 2;
												} else if (j == 2) {
													x = (randomCoord.nextInt(2) == 0) ? 0 : 2;
													y = 0;
												}
											} while (board.getBoardTable()[x][y] != null);
											this.countForMoves++;
											return new Move(x, y, this.getActionFigure());

										}
									}
								}
							}
							break;

						// Place your third X so you have two possible winning
						// moves.

						case 2:
							// A) But first check if there are no 2 'X' in the
							// row
							// to make winning MOVE for CROSS
							for (int i = 0; i < board.getBoardTable().length; i++) {
								for (int j = 0; j < board.getBoardTable()[i].length; j++) {
									if (board.getBoardTable()[i][j] == ActionFigure.CROSS) {
										crossPlace = new Move(i, j, ActionFigure.CROSS);
										possibleMove = checkIfTwo_Sign_FiguresInTheRowThenMakeMove(board, crossPlace);
										if (possibleMove != null) {
											this.countForMoves++;
											return possibleMove;
										}
									}
								}
							}

							// B) Then check if there are no 2 'O' in the row to
							// block winning move for NOUGHT
							for (int i = 0; i < board.getBoardTable().length; i++) {
								for (int j = 0; j < board.getBoardTable()[i].length; j++) {
									if (board.getBoardTable()[i][j] == ActionFigure.NOUGHT) {
										noughtPlace = new Move(i, j, ActionFigure.NOUGHT);
										possibleMove = checkIfTwo_Sign_FiguresInTheRowThenMakeMove(board, noughtPlace);
										if (possibleMove != null) {
											possibleMove.setActionFigure(ActionFigure.CROSS);
											this.countForMoves++;
											return possibleMove;
										}
									}
								}
							}

							// C) If there is no sign in the middle of the 3x3
							// board,
							// and two previous CROSS signs placed in the
							// corners
							// put CROSS in the middle of the 3x3 board so you
							// have
							// two
							// possible winning moves
							// unless there are no 2 'O' in the row, which you
							// would
							// block
							for (int i = 0; i < board.getBoardTable().length; i += 2) {
								for (int j = 0; j < board.getBoardTable().length; j += 2) {
									if (board.getBoardTable()[i][j] == ActionFigure.CROSS) {
										countForXInCorners++;
									}
								}
							}
							if (board.getBoardTable()[1][1] == null && countForXInCorners == 2) {
								x = 1;
								y = 1;
								this.countForMoves++;
								return new Move(x, y, this.getActionFigure());

							}

							// if A, B, C are not work put your third x in a
							// free
							// corner, but probably it`s a Draw till the end

							do {
								x = (randomCoord.nextInt(2) == 0) ? 0 : board.getBoardTable().length - 1;
								y = (randomCoord.nextInt(2) == 1) ? 0 : board.getBoardTable()[x].length - 1;
							} while (board.getBoardTable()[x][y] != null);
							this.countForMoves++;

							break;

						// 4th MOVE
						case 3:
							// A) First check if there are no 2 'X' in the row
							// to
							// make
							// winning MOVE for CROSS
							for (int i = 0; i < board.getBoardTable().length; i++) {
								for (int j = 0; j < board.getBoardTable()[i].length; j++) {
									if (board.getBoardTable()[i][j] == ActionFigure.CROSS) {
										crossPlace = new Move(i, j, ActionFigure.CROSS);
										possibleMove = checkIfTwo_Sign_FiguresInTheRowThenMakeMove(board, crossPlace);
										if (possibleMove != null) {
											this.countForMoves++;
											return possibleMove;
										}
									}
								}
							}

							// B) Then check if there are no 2 'O' in the row to
							// block
							// winning move for NOUGHT
							for (int i = 0; i < board.getBoardTable().length; i++) {
								for (int j = 0; j < board.getBoardTable()[i].length; j++) {
									if (board.getBoardTable()[i][j] == ActionFigure.NOUGHT) {
										noughtPlace = new Move(i, j, ActionFigure.NOUGHT);
										possibleMove = checkIfTwo_Sign_FiguresInTheRowThenMakeMove(board, noughtPlace);
										if (possibleMove != null) {
											possibleMove.setActionFigure(ActionFigure.CROSS);
											this.countForMoves++;
											return possibleMove;
										}
									}
								}
							}

							do {
								x = randomCoord.nextInt(board.getBoardTable().length);
								y = randomCoord.nextInt(board.getBoardTable()[x].length);
							} while (board.getBoardTable()[x][y] != null);
							this.countForMoves++;

							break;

						default:
							System.out.println("Unapropriate Move");
							break;
						}

						return new Move(x, y, this.getActionFigure());

					case NOUGHT:

						switch (this.getCountForMoves()) {
						case 0:
							do {
								x = randomCoord.nextInt(board.getBoardTable().length);
								y = randomCoord.nextInt(board.getBoardTable()[x].length);
							} while (board.getBoardTable()[x][y] != null);
							this.countForMoves++;
							break;
						case 1:
							// A) First check if there are no 2 'X' in the row
							// to
							// BLOCK
							// winning MOVE for CROSS
							for (int i = 0; i < board.getBoardTable().length; i++) {
								for (int j = 0; j < board.getBoardTable()[i].length; j++) {
									if (board.getBoardTable()[i][j] == ActionFigure.CROSS) {
										crossPlace = new Move(i, j, ActionFigure.CROSS);
										possibleMove = checkIfTwo_Sign_FiguresInTheRowThenMakeMove(board, crossPlace);
										if (possibleMove != null) {
											possibleMove.setActionFigure(ActionFigure.NOUGHT);
											this.countForMoves++;
											return possibleMove;
										}
									}
								}
							}

							do {
								x = randomCoord.nextInt(board.getBoardTable().length);
								y = randomCoord.nextInt(board.getBoardTable()[x].length);
							} while (board.getBoardTable()[x][y] != null);
							this.countForMoves++;
							break;

						case 2:
							// A) First check if there are no 2 'X' in the row
							// to
							// BLOCK
							// winning MOVE for CROSS
							for (int i = 0; i < board.getBoardTable().length; i++) {
								for (int j = 0; j < board.getBoardTable()[i].length; j++) {
									if (board.getBoardTable()[i][j] == ActionFigure.CROSS) {
										crossPlace = new Move(i, j, ActionFigure.CROSS);
										possibleMove = checkIfTwo_Sign_FiguresInTheRowThenMakeMove(board, crossPlace);
										if (possibleMove != null) {
											possibleMove.setActionFigure(ActionFigure.NOUGHT);
											this.countForMoves++;
											return possibleMove;
										}
									}
								}
							}
							// B) Then check if there are no 2 'O' in the row to
							// MAKE
							// winning move for NOUGHT
							for (int i = 0; i < board.getBoardTable().length; i++) {
								for (int j = 0; j < board.getBoardTable()[i].length; j++) {
									if (board.getBoardTable()[i][j] == ActionFigure.NOUGHT) {
										noughtPlace = new Move(i, j, ActionFigure.NOUGHT);
										possibleMove = checkIfTwo_Sign_FiguresInTheRowThenMakeMove(board, noughtPlace);
										if (possibleMove != null) {
											this.countForMoves++;
											return possibleMove;
										}
									}
								}
							}

							do {
								x = randomCoord.nextInt(board.getBoardTable().length);
								y = randomCoord.nextInt(board.getBoardTable()[x].length);
							} while (board.getBoardTable()[x][y] != null);
							this.countForMoves++;

							break;
						case 3:
							// A) First check if there are no 2 'X' in the row
							// to
							// BLOCK
							// winning MOVE for CROSS
							for (int i = 0; i < board.getBoardTable().length; i++) {
								for (int j = 0; j < board.getBoardTable()[i].length; j++) {
									if (board.getBoardTable()[i][j] == ActionFigure.CROSS) {
										crossPlace = new Move(i, j, ActionFigure.CROSS);
										possibleMove = checkIfTwo_Sign_FiguresInTheRowThenMakeMove(board, crossPlace);
										if (possibleMove != null) {
											possibleMove.setActionFigure(ActionFigure.NOUGHT);
											this.countForMoves++;
											return possibleMove;
										}
									}
								}
							}
							// B) Then check if there are no 2 'O' in the row to
							// MAKE
							// winning move for NOUGHT
							for (int i = 0; i < board.getBoardTable().length; i++) {
								for (int j = 0; j < board.getBoardTable()[i].length; j++) {
									if (board.getBoardTable()[i][j] == ActionFigure.NOUGHT) {
										noughtPlace = new Move(i, j, ActionFigure.NOUGHT);
										possibleMove = checkIfTwo_Sign_FiguresInTheRowThenMakeMove(board, noughtPlace);
										if (possibleMove != null) {
											this.countForMoves++;
											return possibleMove;
										}
									}
								}
							}

							do {
								x = randomCoord.nextInt(board.getBoardTable().length);
								y = randomCoord.nextInt(board.getBoardTable()[x].length);
							} while (board.getBoardTable()[x][y] != null);
							this.countForMoves++;
							break;

						default:
							System.out.println("Unapropriate Move");
							break;
						}

						return new Move(x, y, this.getActionFigure());

					default:
						break;
					}
				} else if (this.playerType == PlayerType.HUMAN) {

					System.out.println("Прохання здійснити наступний  хід." + "\n"
							+ "Згідно даних адрес та незайнятих комірок прошу обрати x та y для Вашого ходу" + "\n"
							+ "'X.Y', це відповідні числа адреси окремої комірки для ходу.");
					System.out.println();
					for (int i = 0; i < board.getBoardTable().length; i++) {
						for (int j = 0; j < board.getBoardTable()[i].length; j++) {
							System.out.print((board.getBoardTable()[i][j] != null
									? " " + board.getBoardTable()[i][j].getSign() + " " : "" + i + "." + j)
									+ (j != 2 ? "|" : ""));

						}
						System.out.println();
					}
					System.out.println();

					try {
						System.out.println(
								"Введіть число X. Можливі значення [0;2], та відповідно до матриці вільних комірок");
						x = Integer.parseInt(br.readLine());
						System.out.println(
								"Введіть число Y. Можливі значення [0;2], та відповідно до матриці вільних комірок");
						y = Integer.parseInt(br.readLine());
					} catch (NumberFormatException e) {
						System.out.println(
								"Ви ввели не вірне значення в поле Х або Y, повинне бути число для відповідних вільних комірок");

						break;
					} catch (Exception e) {
						System.out.println(
								"Ви ввели не вірне число, або значення. Значення повинно бути в межах [0;2], та відповідно до вільних комірок");

						break;
					}
					if (!(x >= 0 && x <= 2) && (y >= 0 && y <= 2)) {
						System.out.println(
								"Ви ввели не вірні значення, Можливі значення [0;2], та відповідно до матриці вільних комірок");
						break;
					} else if (board.getBoardTable()[x][y] != null) {
						System.out.println("Ви ввели значення комірки, в якої вже занесений знак");
						break;
					}

					return new Move(x, y, this.getActionFigure());

				}

			}
		}

	}

	private Move checkIfTwo_Sign_FiguresInTheRowThenMakeMove(Board board, Move signPlaceToCheck) {

		int countForWinningRows = 0;
		int countForFiguresInRow = 0;

		Move signPlace = signPlaceToCheck;

		// for (int i = 0; i < board.getBoardTable().length; i++) {
		// for (int j = 0; j < board.getBoardTable()[i].length; j++) {
		// if (board.getBoardTable()[i][j] == ActionFigure.CROSS){
		// crossPlace = new Move(i, j, ActionFigure.CROSS);

		// Перевірка по Осі Х
		for (int k = 0; k < board.getBoardTable()[signPlace.getX()].length; k++) {
			if (board.getBoardTable()[signPlace.getX()][k] != null
					&& board.getBoardTable()[signPlace.getX()][k] == (signPlace.getActionFigure())) {
				countForFiguresInRow++;
			}
		}
		if (countForFiguresInRow == board.getBoardTable()[signPlace.getX()].length - 1) {
			for (int k = 0; k < board.getBoardTable()[signPlace.getX()].length; k++) {
				if (board.getBoardTable()[signPlace.getX()][k] == null) {
					return new Move(signPlace.getX(), k, signPlace.getActionFigure());
				}
			}
			countForFiguresInRow = 0;
		} else {
			countForFiguresInRow = 0;
		}

		// Перевірка по Осі Y
		for (int k = 0; k < board.getBoardTable().length; k++) {
			if (board.getBoardTable()[k][signPlace.getY()] != null
					&& board.getBoardTable()[k][signPlace.getY()] == (signPlace.getActionFigure())) {
				countForFiguresInRow++;
			}

		}
		if (countForFiguresInRow == board.getBoardTable().length - 1) {
			for (int k = 0; k < board.getBoardTable().length; k++) {
				if (board.getBoardTable()[k][signPlace.getY()] == null) {
					return new Move(k, signPlace.getY(), signPlace.getActionFigure());
				}
			}
			countForFiguresInRow = 0;
		} else {
			countForFiguresInRow = 0;
		}

		// Перевірка по діагоналі 45*, де адреса х = y:

		if (signPlace.getX() == signPlace.getY()) {

			for (int k = 0; k < board.getBoardTable().length; k++) {
				if (board.getBoardTable()[k][k] != null
						&& board.getBoardTable()[k][k] == (signPlace.getActionFigure())) {
					countForFiguresInRow++;
				}
			}
			if (countForFiguresInRow == board.getBoardTable().length - 1) {
				for (int k = 0; k < board.getBoardTable().length; k++) {
					if (board.getBoardTable()[k][k] == null) {
						return new Move(k, k, signPlace.getActionFigure());
					}
				}
				countForFiguresInRow = 0;
			} else {
				countForFiguresInRow = 0;
			}
		}

		// Перевірка по діагоналі 45*, де сума значень х та y =
		// board.getBoardTable().length-1:
		if ((signPlace.getX() + signPlace.getY()) == board.getBoardTable().length - 1) {

			for (int k = 0, z = board.getBoardTable().length - 1; k < board.getBoardTable().length; k++, z--) {
				if (board.getBoardTable()[k][z] != null
						&& board.getBoardTable()[k][z] == (signPlace.getActionFigure())) {
					countForFiguresInRow++;
				}
			}
			if (countForFiguresInRow == board.getBoardTable().length - 1) {
				for (int k = 0, z = board.getBoardTable().length - 1; k < board.getBoardTable().length; k++, z--) {
					if (board.getBoardTable()[k][z] == null) {

						return new Move(k, z, signPlace.getActionFigure());
					}
				}
				countForFiguresInRow = 0;
			} else {
				countForFiguresInRow = 0;
			}
		}

		return null;
		//
		// }
		// }
		// }
	}

	public ActionFigure getActionFigure() {
		return actionFigure;
	}

	public int getCountForMoves() {
		return countForMoves;
	}

	public void setCountForMoves(int countForMoves) {
		this.countForMoves = countForMoves;
	}

}
