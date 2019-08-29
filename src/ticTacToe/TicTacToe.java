//Daniel Kenny 29.08.19
//A Tic Tac Toe console game based on a blondiebytes tutorial
package ticTacToe;

public class TicTacToe {
	
	protected char[] board;
	protected char userMarker;
	protected char aiMarker;
	protected char winner;
	protected char currentMarker;
	
	public TicTacToe(char playerToken, char aiMarker) {
		this.userMarker = playerToken;
		this.aiMarker = aiMarker;
		this.winner = '-';
		this.board = setBoard();
		this.currentMarker = userMarker;
	}
	
	//Set up the board for play
	public static char[] setBoard() {
		char[] board = new char[9];
		//Use for loop to set each place on the board to a -
		for(int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}
	
	//Checks to see if it's the players turn or the computers
	//Checks if the spot indicated is available to use
	public boolean playTurn(int spot) {
		boolean isValid = withinRange(spot) && !isSpotTaken(spot);
		if(isValid) {
			board[spot-1] = currentMarker; //-1 used to account for having the player avoid typing 0
			//if currentMarker is user then set to computer else set to user
			currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
		}
		return isValid;
	}
	
	//Check if spot is in range on board
	public boolean withinRange(int number) {
		//return the number if it is greater than 0 and less than 10
		return number > 0 && number < board.length +1;
	}
	
	//check if the spot is already taken
	public boolean isSpotTaken(int number) {
		return board[number-1] != '-';
	}
	
	//Print the board to the console
	public void printBoard() {
		System.out.println();
		for(int i = 0; i < board.length; i++) {
			//use for loop to print a line after every 3 spots
			if(i % 3 == 0) {
				System.out.println();
				System.out.println("------------");
			}
			System.out.print(" | " + board[i]);
		}
		System.out.println();
	}
	
	public static void printIndexBoard() {
		System.out.println();
		for(int i = 0; i < 9; i++) {
			//use for loop to print a line after every 3 spots
			if(i % 3 == 0) {
				System.out.println();
				System.out.println("------------");
			}
			System.out.print(" | " + (i +1));
		}
		System.out.println();
	}
	
	//Check for a winner
	public boolean isThereAWinner() {
		boolean diagonalAndMiddle = (rightDi() || leftDi() || midRow() || secondCol()) && board[4] != '-';
		boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-';
		boolean bottomAndThird = (bottomRow() || thirdCol()) && board[8] != '-';
		
		if(diagonalAndMiddle) {
			this.winner = board[4];
		}
		else if(topAndFirst) {
			this.winner = board[0];
		}
		else if(bottomAndThird) {
			this.winner = board[8];
		}
		//returns true if any of these bools are true
		return diagonalAndMiddle || topAndFirst || bottomAndThird;
 	}
	
	//Helper methods to determine a winner
	
	public boolean topRow() {
		//return true if top row is all the same
		return board[0] == board[1] && board[1] == board[2];
	}
	
	public boolean midRow() {
		return board[3] == board[4] && board[4] == board[5];
	}
	
	public boolean bottomRow() {
		return board[6] == board[7] && board[7] == board[8];
	}
	
	public boolean firstCol() {
		return board[0] == board[3] && board[3] == board[6];
	}
	
	public boolean secondCol() {
		return board[1] == board[4] && board[4] == board[7];
	}
	
	public boolean thirdCol() {
		return board[2] == board[5] && board[5] == board[8];
	}
	
	public boolean rightDi() {
		return board[0] == board[4] && board[4] == board[8];
	}
	
	public boolean leftDi() {
		return board[2] == board[4] && board[4] == board[6];
	}
	
	public boolean isBoardFilled() {
		for(int i =0; i < board.length; i++) {
			if(board[i]== '-') {
				return false;
			}
		}
		return true;
	}
	
	//check if game is over
	public String gameOver() {
		boolean didWin = isThereAWinner();
		if(didWin) {
			return "We have a winner!! The winner is " + this.winner + "'s";
		}
		else if(isBoardFilled()) {
			return "it's a draw. Game Over!";
		}else {
			return "notOver";
		}
		
	}
}
