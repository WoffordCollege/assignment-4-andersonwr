package edu.wofford;

import java.util.Scanner;

public class ConsoleMain {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		TicTacToeModel game = new TicTacToeModel();
		TicTacToeModel.Result result = TicTacToeModel.Result.NONE;

		while (result == TicTacToeModel.Result.NONE){
			game.setMarkAt(keyboard.nextInt(), keyboard.nextInt());
			System.out.println(game.toString());
			result = game.getResult();
		}

		if(result == TicTacToeModel.Result.XWIN){
			System.out.println("X wins");
		} else if (result == TicTacToeModel.Result.OWIN){
			System.out.println("O wins");
		} else {
			System.out.println("Tie");
		}
	}
}