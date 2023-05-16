// -----------------------------------------------------
/**	Assignment 1
 	COMP249
 	Written by: Melanie Szubiak 40253252
 	Due: February 3, 2023 */
// ----------------------------------------------------- 
// This program runs the game "Snake and Ladder" to be played by 2 people. If this program is told it will be played by more than 2 people,
// it will set the number of players to 2 with a warning message, continuing the game. If less than 2 players are to play, the game sends 
// a warning message and closes itself. The game takes the name of the two players and decides who will play first based on highest roll while
// keeping track of how many times the turn order is done (if the two dice rolls are the same). The game is designed to allow the players to 
// take turns rolling the dice and printing the board before each turn while reminding the player where they are on the board. The board itself
// is stored in a 2d array. The goal of the game is to reach square 100 (array index [0][0]) but some squares will advance the player and some will
// force the players to retreat. If the players land on the same square/index, the program returns the player who was there first to square 0 (off the board).
// If a player goes past 100/index [0][0], the player is brought back the number of spaces it surpassed [0][0]. A winning message is displayed 
// at square 100/index [0][0] and the program ends.

public class LadderAndSnake {
	private String playerName;
	private int playerSpot;
	private int diceNum;
	private int[][] board = new int[10][10];
	private int newSpot = 0;
	
	/** Create the CONSTRUCTORS */
	
	/** default constructor with no parameters */
	public LadderAndSnake() {		
		}

	/** constructor with 1 int parameter */
	public LadderAndSnake(int roll) {	
		roll = diceNum;
	}
	
	/** constructor with 2 parameters; name and spot location */
	public LadderAndSnake(String playerName, int playerSpot) {		
		this.playerName = playerName;
		this.playerSpot = playerSpot;
	}
	
	
	// Create the GETTERS AND SETTERS for each private variable
	
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerSpot() {
		return playerSpot;
	}

	public void setPlayerSpot(int playerSpot) {
		this.playerSpot = playerSpot;
	}

	public int getDiceNum() {
		return diceNum;
	}

	public void setDiceNum(int diceNum) {
		this.diceNum = diceNum;
	}
	
	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}
	
	public int getNewSpot() {
		return newSpot;
	}

	public void setNewSpot(int newSpot) {
		this.newSpot = newSpot;
	}

	
	/** Create the METHODS (required: flipDice() - flips the dice, play() - plays the game. extra: printBoard() - prints the board, toString() - overrides standard toString method for objects) */
	
		/** Flip dice method - Randomizes numbers 1-6 and stores it in a variable */
	public int flipDice() {
		int roll = (int)(Math.random()*6+1);
		return roll;
	}
	
		/** toString method for objects - Overrides standard toString() method to properly print objects. Takes one LadderAndSnake object as a parameter */
	public String toString(LadderAndSnake a) {
		return playerName + " is now at square " + playerSpot;
	}
	
		/** Printing the board - Fills the array with correct numbers and prints each row individually*/
	public void printBoard() {
		
		//first row (0)
		board[0][0] = 100;
		for(int i = 0; i < 1; i++) {
			for (int j = 1; j < 10; j++) {
				board[i][j] = (board[i][j-1] -1);
			}
		}
		
		//second row (1)
		board[1][0] = 81;
		for (int i = 1; i<2; i++) {
			for (int j = 1; j<10; j++) {
				board[i][j] = (board[i][j-1] +1);
			}
		}
		
		//third row (2)
		board[2][0] = 80;
		for(int i = 2; i < 3; i++) {
			for (int j = 1; j < 10; j++) {
				board[i][j] = (board[i][j-1] -1);
			}
		}
		
		//fourth row (3)
		board[3][0] = 61;
		for(int i = 3; i < 4; i++) {
			for(int j = 1; j < 10; j++) {
				board[i][j] = (board[i][j-1] +1);
			}
		}
		
		//fifth row (4)
		board[4][0] = 60;
		for(int i = 4; i < 5; i++) {
			for (int j = 1; j < 10; j++) {
				board[i][j] = (board[i][j-1] -1);
			}
		}
		
		//sixth row (5)
		board[5][0] = 41;
		for(int i = 5; i < 6; i++) {
			for(int j = 1; j < 10; j++) {
				board[i][j] = (board[i][j-1] +1);
			}
		}
		
		//seventh row (6)
		board[6][0] = 40;
		for(int i = 6; i < 7; i++) {
			for (int j = 1; j < 10; j++) {
				board[i][j] = (board[i][j-1] -1);
			}
		}
		
		//eighth row (7)
		board[7][0] = 21;
		for(int i = 7; i < 8; i++) {
			for(int j = 1; j < 10; j++) {
				board[i][j] = (board[i][j-1] +1);
			}
		}
		
		//ninth row (8)
		board[8][0] = 20;
		for(int i = 8; i < 9; i++) {
			for (int j = 1; j < 10; j++) {
				board[i][j] = (board[i][j-1] -1);
			}
		}
		
		//tenth row (9)
		board[9][0] = 1;
		for(int i = 9; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				board[i][j] = (board[i][j-1] +1);
			}
		}
		//print rows 0-8

		
		for (int i = 0; i < 9; i++) { 
	         for (int j = 0; j < board[i].length; j++) {
	        	
	            System.out.print(" | " + board[i][j] + " | ");
	         }
	         System.out.println();
	         System.out.println();
	      }
		//print row 9 separate to match board aesthetic... needed to line up properly
		for (int i = 9; i < 10; i++) { 
	         for (int j = 0; j < board[i].length; j++) {
	            System.out.print(" |  " + board[i][j] + " | ");
	         }
	         System.out.println();
	         System.out.println();
	      }

	}
		/** Play the game method - Rolls a dice, and creates the new spot for the player object that invokes the method.
		 * Moves the player across the board should they land on a certain index (snakes/ladders). */
	public void play() {
		diceNum = flipDice();
		System.out.println("\nYou rolled a " + diceNum + ".");
		newSpot = (playerSpot+diceNum);
		setPlayerSpot(newSpot);
		
		/** Set up the Ladders route and message */ 
		
		if (playerSpot == board[9][0]) { 	//1
			System.out.println("Congrats! You landed on square #1, which is the start of a ladder!");
			setPlayerSpot(board[6][2]);		//38
		}
		
		if (playerSpot == board[9][3]) {	//4
			System.out.println("Congrats! You landed on square #4, which is the start of a ladder!");
			setPlayerSpot(board[8][6]);		//14
		}
		
		if (playerSpot == board[9][8]) {	//9
			System.out.println("Congrats! You landed on square #9, which is the start of a ladder!");
			setPlayerSpot(board[6][9]);		//31
		}
		
		if (playerSpot == board[7][0]) {	//21
			System.out.println("Congrats! You landed on square #21, which is the start of a ladder!");
			setPlayerSpot(board[5][1]);		//42
		}
		
		if (playerSpot == board[7][7]) {	//28
			System.out.println("Congrats! You landed on square #28, which is the start of a ladder!");
			setPlayerSpot(board[1][3]);		//84
		}
		
		if (playerSpot == board[6][4]) {	//36
			System.out.println("Congrats! You landed on square #36, which is the start of a ladder!");
			setPlayerSpot(board[5][3]);		//44
		}
		
		if (playerSpot == board[4][9]) {	//51
			System.out.println("Congrats! You landed on square #51, which is the start of a ladder!");
			setPlayerSpot(board[3][6]);		//67
		}
		
		if (playerSpot == board[2][9]) {	//71
			System.out.println("Congrats! You landed on square #71, which is the start of a ladder!");
			setPlayerSpot(board[0][9]);		//91
		}
		
		if (playerSpot == board[2][0]) {	//80
			System.out.println("Congrats! You landed on square #80, which is the start of a ladder!");
			setPlayerSpot(board[0][0]);		//100
		}		
		
		
		/** Set up the Snakes */
		
		if (playerSpot == board[8][4]) {	//16
			System.out.println("Uh oh! You landed on square #16, which has a snake's head!");
			setPlayerSpot(board[9][5]);		//6
		}
		
		if (playerSpot == board[5][7]) {	//48
			System.out.println("Uh oh! You landed on square #48, which has a snake's head!");
			setPlayerSpot(board[7][9]);		//30
		}
		
		if (playerSpot == board[0][7]) {	//93
			System.out.println("Uh oh! You landed on square #93, which has a snake's head!");
			setPlayerSpot(board[3][7]);		//68
		}
		
		if (playerSpot == board[0][5]) {	//95
			System.out.println("Uh oh! You landed on square #95, which has a snake's head!");
			setPlayerSpot(board[7][3]);		//24
		}
		
		if (playerSpot == board[0][3]) {	//97
			System.out.println("Uh oh! You landed on square #97, which has a snake's head!");
			setPlayerSpot(board[2][4]);		//76
		}
		
		if (playerSpot == board[0][2]) {	//98
			System.out.println("Uh oh! You landed on square #98, which has a snake's head!");
			setPlayerSpot(board[2][2]);		//78
		}
		
		if (playerSpot == board[0][0]) {
			System.out.println("CONGRATULATIONS YOU LANDED ON SQUARE #100!!! YOU ARE THE WINNER!!! \n\nThe game is finished. Thank you for playing :) ");
			System.exit(0);
		}
		
		if (playerSpot > 100) {
			setPlayerSpot((100 + (100 - playerSpot)));
			System.out.println("Whoops! You passed the finish line! You go back a couple squares...");
		}
				
	}	//END PLAY METHOD
	
} // END CLASS
