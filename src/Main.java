/*
 * Author: William Söderqvist
 * Written: 18-3-2020
 */

import java.util.Scanner;

public class Main 
{
	static Scanner input = new Scanner(System.in);
	
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
	
	
	//This is the main loop of the game, it loops until a winning condition is met
	private static void gameLoop(Boolean[][] gameBoard, String[][] playerAnswers, int player) 
	{
		
		if(playerCheck(player++) == false)
			System.out.println("Player 1 - [X]\nEnter row & column [1,2,3]");
		else
			System.out.println("Player 2 - [O]\nEnter row & column [1,2,3]");
		
		int i = (input.nextInt()-1);
		int j = (input.nextInt()-1);
		
		inputCheck(i,j, gameBoard, playerAnswers, player);
		
		updateGameBoard(gameBoard,i,j);
		
		renderGameBoard(gameBoard, playerAnswers, player);
		
		winCondition(gameBoard, playerAnswers, player);
		
		gameLoop(gameBoard, playerAnswers, player);
		
		
	}
	
	
	
	//Checks if input is valid, and if the desired move isnt already "taken".
	private static void inputCheck(int i, int j, Boolean[][] gameBoard, String[][] playerAnswers, int player) 
	{
		if ((i > 2 || i < 0) || (j > 2 || j < 0) || gameBoard[i][j] == true) 
		{
			System.out.println("Try again");
			player = player - 1;
			gameLoop(gameBoard, playerAnswers, player);
		}	
	}

	
	
	//This checks which player is currently playing
	private static boolean playerCheck(int player) 
	{
		return (player%2 == 0);
	}

	
	
	//This checks for winning conditions, and ends game if one exists
	private static void winCondition(Boolean[][] gameBoard, String[][] playerAnswers, int player) 
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

	
	
	//Games is over, and the user gets the option to replay the game
	private static void gameOver(int player) 
	{
		System.out.println("Game over, player " + ((player%2)+1) + " won\n\nPlay Again? (y/n)");
		String s = input.next();
		if(s.equals(("y"))) 
			main(null);
		else 
		{
			System.out.print("Thanks for playing");
			System.exit(0); 
		}
	}

	
	
	//Updates the game board with the player input
	private static void updateGameBoard(Boolean[][] gameBoard, int i, int j) 
	{
		gameBoard[i][j] = true;	
	}

	
	
	//Renders the gameboard
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
						System.out.print("[" + inputPlayer1(playerAnswers[i][j], playerAnswers, i, j) + "]");
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
						System.out.print("[" + inputPlayer2(playerAnswers[i][j], playerAnswers, i, j) + "]");
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

	
	
	//Sets the corresponding character to the move the player has chosen
	private static String inputPlayer1(String playerAnswer, String[][] playerAnswers, int i, int j) 
	{
		if (playerAnswer == null) 
			playerAnswers[i][j] = "O";
		
			return playerAnswers[i][j];
	}
	
	private static String inputPlayer2(String playerAnswer, String[][] playerAnswers, int i, int j) 
	{
		if (playerAnswer == null) 
			playerAnswers[i][j] = "X";
		
			return playerAnswers[i][j];
	}

}
