package ticTacToe;

import java.util.ArrayList;
import java.util.Random;

public class AI {
	public static int pickSpot(TicTacToe game) {
		ArrayList<Integer> choices = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			//if slot is available add it as a choice
			if(game.board[i] == '-') {
				choices.add(i +1); //+1 to account for how the user sees the UI
				
			}
		}
		Random rand = new Random();
		//pick a random index based on the available spots
		int choice = choices.get(Math.abs(rand.nextInt() % choices.size()));
		return choice;
	}
}
