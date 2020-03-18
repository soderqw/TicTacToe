/*
 * Author: William Söderqvist
 * Written: 18-3-2020
 */


public class Main 
{
	
	public static void main(String [] args)
	{	
		Boolean[][] gameBoard = 
			{
				{false,false,false},
				{false,false,false},
				{false,false,false}
			};
		
		String[][] playerAnswers = new String[3][3];
		int player = 1;
		
		Game.gameLoop(gameBoard, playerAnswers, player);
		
	}
	
}
