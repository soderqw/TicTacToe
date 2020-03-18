import java.io.IOException;
import java.util.Scanner;

public class Game 
{

	static Scanner input = new Scanner(System.in);
	//This is the main loop of the game, it loops until a winning condition is met
	static void gameLoop(Boolean[][] gameBoard, String[][] playerAnswers, int player)
	{
		int i = 0, j = 0;
		
		//Checks whos turn it is
		if(playerCheck(player++) == false)
			System.out.println("Player 1 - [X]\nEnter row & column [1,2,3]");
		else
			System.out.println("Player 2 - [O]\nEnter row & column [1,2,3]");
		
		//If input is invalid, code in catch will run
		try 
		{
			//Get user input
			i = (input.nextInt()-1);
			j = (input.nextInt()-1);
			
			//Checks if input is within range of gameboard, and if the move isnt already made
			inputCheck(i,j, gameBoard, playerAnswers, player);
			
			updateGameBoard(gameBoard,i,j);
			
			//Checks if all moves are now taken, if so ends the game in a tie game
			if(checkIfOver(gameBoard)) 
			{
				gameEven();
			}
				
			//else just continue the game
			else 
			{
				renderGameBoard(gameBoard, playerAnswers, player);
				
				winCondition(gameBoard, playerAnswers, player);
				
				gameLoop(gameBoard, playerAnswers, player);
			}
		}
		
		catch(Exception e)
		{
			System.err.println(e);
		}	
	}
	
	
	
	private static void gameEven() {
		System.out.println("Tie game!\n\nPlay Again? (y/n)");
		String s = input.next();
		if(s.equals(("y"))) 
			Main.main(null);
		else 
		{
			System.out.print("Thanks for playing");
			System.exit(0); 
		}
	}



	private static boolean checkIfOver(Boolean[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) 
		{
			for (int j = 0; j < gameBoard.length; j++) 
			{
				if (gameBoard[i][j] != true)
					return false;
			}
		}
		return true;
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
		horizontalTest(gameBoard, playerAnswers, player);
		verticalTest(gameBoard, playerAnswers, player);
		diagonalTest(gameBoard, playerAnswers, player);
	}

	
	
	//Tests for winning conditions in diagonal, vertical and horizontal
	private static void diagonalTest(Boolean[][] gameBoard, String[][] playerAnswers, int player) {
		for (int i = 0; i < gameBoard.length; i++) 
		{
			if (gameBoard[0][0] == true && gameBoard[1][1] == true && gameBoard[2][2] == true) 
			{
				if(playerAnswers[0][0].equals(playerAnswers[1][1]) && playerAnswers[1][1].equals(playerAnswers[2][2]))
					gameOver(player);
			}

			if (gameBoard[2][0] == true && gameBoard[1][1] == true && gameBoard[0][2] == true) 
			{
				if(playerAnswers[2][0].equals(playerAnswers[1][1]) && playerAnswers[1][1].equals(playerAnswers[0][2]))
					gameOver(player);
			}
		}	
	}

	
	
	private static void verticalTest(Boolean[][] gameBoard, String[][] playerAnswers, int player) {
		for (int i = 0; i < gameBoard.length; i++) 
		{
			if (gameBoard[0][i] == true && gameBoard[1][i] == true && gameBoard[2][i] == true) 
			{
				if(playerAnswers[0][i].equals(playerAnswers[1][i]) && playerAnswers[1][i].equals(playerAnswers[2][i]))
					gameOver(player);
			}
		}
		
	}

	
	
	private static void horizontalTest(Boolean[][] gameBoard, String[][] playerAnswers, int player) {
		
		for (int i = 0; i < gameBoard.length; i++) 
		{
			if (gameBoard[i][0] == true && gameBoard[i][1] == true && gameBoard[i][2] == true) 
			{
				if(playerAnswers[i][0].equals(playerAnswers[i][1]) && playerAnswers[i][1].equals(playerAnswers[i][2]))
					gameOver(player);
			}
		}
	}



	//Games is over, and the user gets the option to replay the game
	private static void gameOver(int player) 
	{
		System.out.println("Game over, player " + ((player%2)+1) + " won\n\nPlay Again? (y/n)");
		String s = input.next();
		if(s.equals(("y"))) 
			Main.main(null);
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
		for (int i = 0; i < gameBoard.length; i++) 
		{
			for (int j = 0; j < gameBoard.length; j++) 
			{
				if (gameBoard[i][j] == true)
				{
					System.out.print("[" + inputPlayer(playerAnswers[i][j], playerAnswers, i, j, player) + "]");
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
	

	
	//Sets the corresponding character to the move the player has chosen
	private static String inputPlayer(String playerAnswer, String[][] playerAnswers, int i, int j, int player) 
	{
		if (playerAnswer == null) 
		{
			if(playerCheck(player++) == false) 
				playerAnswers[i][j] = "O";
			else
				playerAnswers[i][j] = "X";
		}
		return playerAnswers[i][j];
	}
}
