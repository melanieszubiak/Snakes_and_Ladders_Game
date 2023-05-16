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

import java.util.Scanner;
public class PlayLadderAndSnake {

	public static void main(String[] args) {
		
		/** Initialize keyboard */
		Scanner key = new Scanner(System.in);
		
		/** Create variables for turn order */
		LadderAndSnake first = null;
		LadderAndSnake second = null;
	

		/** Display Welcome Message*/
		System.out.println("Welcome to Mela's Snake and Ladder Game!");
		System.out.print("\nPlease enter how many players will be playing: ");
		
		int numPlayers = key.nextInt();
		
		/** If players are set to 2, continue. If players are set to more than 2, will set players to 2 and continue. If players are set to less than 2, exits.*/
		
		if (numPlayers == 2) {
			System.out.print("\nGreat! ");
		} 
		else if (numPlayers > 2) {
			System.out.println("Initialization was attempted for " + numPlayers + " players; however, this is only expected for an extended"
					+ " version of the game. \nSorry about that! \n\nValue will be set to 2 instead\n");
			numPlayers = 2;
		}
		
			else if (numPlayers < 2) {
				System.out.println("Error: Cannot execute the game with less than 2 players! \n\nWill exit instead.");
				System.exit(0);
			}
		
		/** Asks the players for their names, ignores case and returns first letter as upper case and rest lower case. */
		
		System.out.print("Player 1, please enter your name: ");
		String p1Name = key.next();
		p1Name = p1Name.substring(0,1).toUpperCase() + p1Name.substring(1).toLowerCase();
		
		System.out.print("Thank you " + p1Name + "! \n\nPlayer 2, please enter your name: ");
		
		String p2Name = key.next();
		p2Name = p2Name.substring(0,1).toUpperCase() + p2Name.substring(1).toLowerCase();
		
		System.out.println("Thank you " + p2Name + "!");
		
		
		/** Creation of Objects type LadderAndSnake with player names and initialize start at 0. */
		LadderAndSnake Player1 = new LadderAndSnake(p1Name, 0);
		LadderAndSnake Player2 = new LadderAndSnake(p2Name, 0);
			
		/**DECIDE TURN ORDER while keeping track of ties.*/
		
		System.out.println("\nWe will now decide which of you will start playing first:");
		
		int p1Roll = Player1.flipDice();
		int p2Roll = Player2.flipDice();
		int count = 1;

		
		System.out.println("\n" + p1Name + " got a dice value of " + p1Roll);
		System.out.println(p2Name + " got a dice value of " + p2Roll + "\n");
		
		
		/**Tie Breaker: loops turn order if players get the same dice roll*/
		
		if (p1Roll == p2Roll) {
			while (p1Roll == p2Roll)
			{
				System.out.println("A tie was achieved by " + p1Name + " and " + p2Name+ ", attempting to break the tie...");
				count++;
				p1Roll = Player1.flipDice();
				p2Roll = Player2.flipDice();
				System.out.println("\n" + p1Name + " got a dice value of " + p1Roll);
				System.out.println(p2Name + " got a dice value of " + p2Roll + "\n");
			}
		}	
		
		/**Turn order without tie: Decides which player goes first depending on dice roll value. */
		
		 if (p1Roll > p2Roll)
			{
				System.out.print("Reached final decision on order of playing: " + p1Name + ", then " + p2Name + ". It took " + count + " attempt(s) before reaching a decision.\n");
				first = Player1;
				second = Player2;
			}
		else 
			if (p1Roll < p2Roll)
				{
					System.out.println("Reached final decision on order of playing: " + p2Name + ", then " + p1Name + ". It took " + count + " attempt(s) before reaching a decision.\n");
					first = Player2;
					second = Player1;
				}
		 
		 System.out.println("\nLet's begin the game!");
		 
		 /**PLAY THE GAME: loops the game until either player gets to 100. */
		 
		 while (first.getPlayerSpot() != 100 || second.getPlayerSpot() != 100) {
			 
			 /** FIRST PLAYER TURN: Displays message of who's turn it is, prints the board and reminds the player where they currently are on the board. */
			 System.out.println("\n" + first.getPlayerName() + ", it's your turn. \nPlease see the board below\n");
			 first.printBoard();
			 System.out.print("\n" + first.getPlayerName() + ", you are currently at square #" + first.getPlayerSpot() + ". \nPlease type 'ok' and hit 'Enter' to roll: ");
			 key.next();
			 first.play();
			 System.out.println("\n" + first.getPlayerName() + " is now at square #" + first.getPlayerSpot() + ".");
			 	if (first.getPlayerSpot() == second.getPlayerSpot()) {
			 		System.out.println("Oh no! You landed at the same spot as " + second.getPlayerName() + "! " + second.getPlayerName() + " gets sent back to square #0!"); 
			 		second.setPlayerSpot(0);
			 	}
			 	
			 /**SECOND PLAYER TURN: Displays message of who's turn it is, prints the board and reminds the player where they currently are on the board. */
			 System.out.println("\nNow it's " + second.getPlayerName() + "'s turn! \nPlease see the board below\n");
			 first.printBoard();
			 System.out.print("\n" + second.getPlayerName() + ", you are currently at square #" + second.getPlayerSpot() + ". \nPlease type 'ok' and hit 'Enter' to roll: ");
			 key.next();
			 second.play();
			 System.out.println("\n" + second.getPlayerName() + " is now at square #" + second.getPlayerSpot());
			 if (first.getPlayerSpot() == second.getPlayerSpot()) {
				 System.out.println("Oh no! You landed at the same spot as " + first.getPlayerName() + "! " + first.getPlayerName() + " gets sent back to square #0!");
				 first.setPlayerSpot(0);
			 }
			 
		 }
		
		 /** Closes the keyboard for happy Java */
		key.close();
	}

}
