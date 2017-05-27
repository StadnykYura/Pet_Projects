package ticTacToeGame;

public class Board {

	private ActionFigure[][] boardTable;
	
	
	public Board() {
		 boardTable = new ActionFigure [3][3];
	}
	
	
	public boolean hasMoreSpace(){
		
		int countFreeSpace=0;
		
		for (int i = 0; i < this.boardTable.length; i++) {
			for (int j = 0; j < this.boardTable.length; j++) {
				if (this.boardTable [i] [j] == null){
					countFreeSpace++;
					if (countFreeSpace > 1){
						return true;
					}
				}
			}
		}
		 return false;
		
	}
	
	
	public void printBoard(){
		for (int i = 0; i < this.boardTable.length; i++) {
			for (int j = 0; j < this.boardTable.length; j++) {
				System.out.print((this.boardTable [i] [j] !=null ? this.boardTable [i] [j] .getSign():" ") + (j != 2 ? "|":""));
				
			}
			System.out.println();	
		}
		
	}


	public ActionFigure[][] getBoardTable() {
		return boardTable;
	}


	



	


	
}
