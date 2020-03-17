import java.util.Scanner;

public class Main 
{
	static Scanner input = new Scanner(System.in);
	/*
	 * ->	TIC-TAC-TOE	  <-
	 * 
	 * GAME LOOP
	 * Render game board
	 * Get user input (player 1)
	 * Update game board
	 * check for ending conditions
	 * ---------------------------
	 * Get user input (player 2)
	 * Update game board
	 * check for ending conditions
	 * Render game board
	 * Repeat this loop
	 * 
	 * 
	 * 
	 * 
	 * USER INPUT
	 * User enter row and column of desired move, then array updates position to true
	 * 
	 * 
	 * 
	 * 
	 * ENDING CONDITION
	 * three in a row, horizontal, vertical, diagonal.
	 * 
	 * 
	 * 
	 * 
	 * GAME BOARD
	 * 3 by 3 boolean array, gameBoard[i][j][k]
	 * 
	 * 
	 * 
	 * 
	 * GAME BOARD VISUAL REPRESENTATION
	 * own method
	 * 
	 */
	
	public static void main(String [] args) 
	{
		Boolean[][] gameBoard = 
			{
				{false,false,false},
				{false,false,false},
				{false,false,false}
			};
		renderGameBoard(gameBoard);
		gameLoop(gameBoard);
		

		
	}

	private static void gameLoop(Boolean[][] gameBoard) 
	{
		
		System.out.print("enter row and column to select move");
		int i = input.nextInt();
		int j = input.nextInt();
		
		updateGameBoard(gameBoard,i,j);
		
		renderGameBoard(gameBoard);
		
		check(gameBoard);
		
	}



	private static void check(Boolean[][] gameBoard) 
	{
		//HORIZONTAL
		if (gameBoard[0][0] == true && gameBoard[0][1] == true && gameBoard[0][0] == true)
			gameOver();
		else if (gameBoard[1][0] == true && gameBoard[1][1] == true && gameBoard[1][0] == true)
			gameOver();
		else if (gameBoard[2][0] == true && gameBoard[2][1] == true && gameBoard[2][0] == true)
			gameOver();
		
		//VERTICAL
		else if (gameBoard[0][0] == true && gameBoard[1][0] == true && gameBoard[2][0] == true)
			gameOver();
		else if (gameBoard[0][1] == true && gameBoard[1][1] == true && gameBoard[2][1] == true)
			gameOver();
		else if (gameBoard[0][2] == true && gameBoard[1][2] == true && gameBoard[2][2] == true)
			gameOver();
		
		//DIAGONAL
		else if (gameBoard[0][0] == true && gameBoard[1][1] == true && gameBoard[2][2] == true)
			gameOver();
		else if (gameBoard[2][2] == true && gameBoard[1][1] == true && gameBoard[0][0] == true)
			gameOver();
		else
			gameLoop(gameBoard);
				
		
	}

	private static void gameOver() {
		System.out.print("Game over");
		
	}

	private static void updateGameBoard(Boolean[][] gameBoard, int i, int j) {
		gameBoard[i][j] = true;	
	}

	private static void renderGameBoard(Boolean[][] gameBoard) 
	{
		
		System.out.printf("[][][]%n[][][]%n[][][]");
		
		System.out.printf("%b%10.4b%10.4b%n", gameBoard[0][0], gameBoard[0][1], gameBoard[0][2]);
		System.out.printf("%b%10.4b%10.4b%n", gameBoard[1][0], gameBoard[1][1], gameBoard[1][2]);
		System.out.printf("%b%10.4b%10.4b%n", gameBoard[2][0], gameBoard[2][1], gameBoard[2][2]);
		
	}

}
