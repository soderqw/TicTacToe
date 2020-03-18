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
		
		String[][] playerAnswers = new String[3][3];
		//renderGameBoard(gameBoard, 0);
		
		int player = 1;
		gameLoop(gameBoard, playerAnswers, player);
		

		
	}

	private static void gameLoop(Boolean[][] gameBoard, String[][] playerAnswers, int player) 
	{
		
		if(playerCheck(player++) == false)
			System.out.println("Player 1\nEnter row & column");
		else
			System.out.println("Player 2\nEnter row & column");
		
		int i = input.nextInt();
		int j = input.nextInt();
		
		updateGameBoard(gameBoard,i,j);
		
		renderGameBoard(gameBoard, playerAnswers, player);
		
		check(gameBoard, playerAnswers, player);
		
		gameLoop(gameBoard, playerAnswers, player);
		
		
	}

	private static boolean playerCheck(int player) {
		return (player%2 == 0);	//False is odd=player 1
	}

	private static void check(Boolean[][] gameBoard, String[][] playerAnswers, int player) 
	{
		//HORIZONTAL
		/*
		 * [x][x][x]
		 * [ ][ ][ ]
		 * [ ][ ][ ]
		 */
		if (gameBoard[0][0] == true && gameBoard[0][1] == true && gameBoard[0][2] == true) 
		{
			if(playerAnswers[0][0].equals(playerAnswers[0][1]) && playerAnswers[0][1].equals(playerAnswers[0][2]))
				gameOver(player);
		}
			
		/*
		 * [ ][ ][ ]
		 * [x][x][x]
		 * [ ][ ][ ]
		 */
		if (gameBoard[1][0] == true && gameBoard[1][1] == true && gameBoard[1][2] == true) 
		{
			if(playerAnswers[1][0].equals(playerAnswers[1][1]) && playerAnswers[1][1].equals(playerAnswers[1][2]))
				gameOver(player);
		}
		
		/*
		 * [ ][ ][ ]
		 * [ ][ ][ ]
		 * [x][x][x]
		 */
		if (gameBoard[2][0] == true && gameBoard[2][1] == true && gameBoard[2][2] == true) 
		{
			if(playerAnswers[2][0].equals(playerAnswers[2][1]) && playerAnswers[2][1].equals(playerAnswers[2][2]))
				gameOver(player);
		}

		
		
		
		
		//VERTICAL
		/*
		 * [x][ ][ ]
		 * [x][ ][ ]
		 * [x][ ][ ]
		 */
		if (gameBoard[0][0] == true && gameBoard[1][0] == true && gameBoard[2][0] == true) 
		{
			if(playerAnswers[0][0].equals(playerAnswers[1][0]) && playerAnswers[1][0].equals(playerAnswers[2][0]))
				gameOver(player);
		}
		
		/*
		 * [ ][x][ ]
		 * [ ][x][ ]
		 * [ ][x][ ]
		 */
		if (gameBoard[0][1] == true && gameBoard[1][1] == true && gameBoard[2][1] == true) 
		{
			if(playerAnswers[0][1].equals(playerAnswers[1][1]) && playerAnswers[1][1].equals(playerAnswers[2][1]))
				gameOver(player);
		}
		
		/*
		 * [ ][ ][x]
		 * [ ][ ][x]
		 * [ ][ ][x]
		 */
		else if (gameBoard[0][2] == true && gameBoard[1][2] == true && gameBoard[2][2] == true) 
		{
			if(playerAnswers[0][2].equals(playerAnswers[1][2]) && playerAnswers[1][2].equals(playerAnswers[2][2]))
				gameOver(player);
		}
		
		
		
		
		
		//DIAGONAL
		/*
		 * [x][ ][ ]
		 * [ ][x][ ]
		 * [ ][ ][x]
		 */
		if (gameBoard[0][0] == true && gameBoard[1][1] == true && gameBoard[2][2] == true) 
		{
			if(playerAnswers[0][0].equals(playerAnswers[1][1]) && playerAnswers[1][1].equals(playerAnswers[2][2]))
				gameOver(player);
		}

		/*
		 * [ ][ ][x]
		 * [ ][x][ ]
		 * [x][ ][ ]
		 */
		if (gameBoard[2][0] == true && gameBoard[1][1] == true && gameBoard[0][2] == true) 
		{
			if(playerAnswers[2][0].equals(playerAnswers[1][1]) && playerAnswers[1][1].equals(playerAnswers[0][2]))
				gameOver(player);
		}
		
		

	}

	private static void gameOver(int player) {
		System.out.print("Game over, player " + ((player%2)+1) + " won");
		System.exit(0); 
	}

	private static void updateGameBoard(Boolean[][] gameBoard, int i, int j) {
		gameBoard[i][j] = true;	
	}

	private static void renderGameBoard(Boolean[][] gameBoard, String[][] playerAnswers, int player) 
	{
		if(playerCheck(player++) == false) 
		{
			for (int i = 0; i < gameBoard.length; i++) 
			{
				for (int j = 0; j < gameBoard.length; j++) 
				{
					if (gameBoard[i][j] == true)
					{
						System.out.print("[" + player1(playerAnswers[i][j], playerAnswers, i, j) + "]");
					}
					else 
					{
						if (playerAnswers[i][j] == null)
							System.out.print("[ ]");
						else
							System.out.print("[" + playerAnswers[i][j] + "]");
					}	
				}
				System.out.println();
			}
		}
		else 
		{
			for (int i = 0; i < gameBoard.length; i++) 
			{
				for (int j = 0; j < gameBoard.length; j++) 
				{
					if (gameBoard[i][j] == true)
					{
						System.out.print("[" + player2(playerAnswers[i][j], playerAnswers, i, j) + "]");
					}
					else 
					{
						if (playerAnswers[i][j] == null)
							System.out.print("[ ]");
						else
							System.out.print("[" + playerAnswers[i][j] + "]");
					}	
				}
				System.out.println();
			}
		}
		
	}

	private static String player1(String playerAnswer, String[][] playerAnswers, int i, int j) {
		if (playerAnswer == null) 
			playerAnswers[i][j] = "O";
		
			return playerAnswers[i][j];
	}
	
	private static String player2(String playerAnswer, String[][] playerAnswers, int i, int j) {
		if (playerAnswer == null) 
			playerAnswers[i][j] = "X";
		
			return playerAnswers[i][j];
	}

}
