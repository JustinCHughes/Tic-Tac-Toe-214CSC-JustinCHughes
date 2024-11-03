package com.csc;

public class Human
{
  public static void startGame(char[][] board, String currentState)
  {
    // Initialize variables
		int currentPlayer = 1;

    // Continue game loop as long as currentState says to continue
		while(currentState.equals("Continue"))
		{
			// Prints the board and then calls playerSelect function to
			// prompt user on what cells they want to play
			GameLogic.printBoard(board);
			board = GameLogic.playerSelectCheck(board, currentPlayer);

			// Checks gameState and updates currentState accordingly
			currentState = GameLogic.gameState(board);

			// Updates currentPlayer if currentState is still "Continue"
			if(currentState.equals("Continue"))
			{
				if(currentPlayer == 2)
				{
					currentPlayer = 1;
				}
				else
				{
					currentPlayer = 2;
				}
			}
		}

		String winner = (currentPlayer == 1) ? "Player One" : "Player Two";

		// Prints final board state
		GameLogic.printBoard(board);

		// Checks currentState and outputs result
		if(currentState.equals("Victory"))
		{
			System.out.println(winner + " has won!");
		}
		else
		{
			System.out.println("The game has ended in a draw!");
		}
		System.out.println("Thank you for playing!");
	}
}