//Daniel Kenny 29.08.19
//A Tic Tac Toe console game based on a blondiebytes tutorial
package ticTacToe;

import java.util.Scanner;

public class ticTacToeApp {

	public static void main(String[] args) {
		//Getting the user input
		Scanner sc = new Scanner(System.in);
		//Allows for more games
		boolean play = true;
		while(play) {
			//Setting up the game tokens and AI
			System.out.println("Welcome to Tic Tac Toe!");
			System.out.println();
			System.out.println("Enter the single character you want to represent you on the board.");
			char playerToken = sc.next().charAt(0);
			System.out.println("Enter the character to represent the computer.");
			char computerToken = sc.next().charAt(0);
			TicTacToe game = new TicTacToe(playerToken, computerToken);
			AI ai = new AI();
			
			//Set up the game
			System.out.println();
			System.out.println("Let's Play! Enter the number (1-9) you want to place a token on.");
			TicTacToe.printIndexBoard();
			System.out.println();
			
			//Play the game
			while(game.gameOver().equals("notOver")) {
				if(game.currentMarker == game.userMarker) {
					//Players turn
					System.out.println("It's your turn! Enter a position to place your token.");
					int spot = sc.nextInt();
					while(!game.playTurn(spot)) {
						System.out.println("Try again!" + spot + "is not valid");
						 spot = sc.nextInt();
					}
					System.out.println("You picked " + spot + "!");
				}else {
					//It's the Ai's turn
					System.out.println("It'smy turn!");
					//AI picks it's spot
					int aiSpot = AI.pickSpot(game);
					game.playTurn(aiSpot);
					System.out.println("I picked " + aiSpot + "!");
				}
				//Update the game board
				System.out.println();
				game.printBoard();
			}
			//Display result of game.
			System.out.println(game.gameOver());
			System.out.println();
			//set up new game or exit
			System.out.println("Do you want to play again> Y/N");
			char response = sc.next().charAt(0);
			
			play = (response == 'Y' || response == 'y');
			System.out.println();
			System.out.println();
		}

	}

}
