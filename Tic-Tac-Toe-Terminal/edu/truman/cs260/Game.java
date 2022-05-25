/**
* @author Jingbo Wang
* To let user to choose model and show the results
*/

package edu.truman.cs260;
import java.util.Scanner;

public class Game
{
    final int HUMANFIRST = 1;
    final int COMPUTERFIRST = 2;
    final int EXIT_CHOICE = 3;

    /**
     * constructor for game
     */
    public Game()
    {
    	int choice = 0;
    	Scanner cin = new Scanner(System.in);

    	choice = getModelChoice(cin);

    	showGameResult(choice, cin);

    	cin.close();
    }

    /**
     * To shouw the notes for the game
     */
    public void gameNotes()
    {
    	  System.out.println();
          System.out.println();
          System.out.println("NOTE:");
          System.out.println("1. H = Human     C = Cumputer");
          System.out.println("2.The enter of place is \"row, column\". ");
          System.out.println("3. The ranges of row and column are between 0 and 2 (Including 0, 2)." );
          System.out.println("4. Column is begining of 0, end to 2.");
          System.out.println("5. Please enter like: \"0,1\"; \"1,1\".");
          System.out.println();
          System.out.println();
    }

    /**
     * to get game model Choice by human
     */
    public int getModelChoice(Scanner cin)
    {
    	int tempChoice = 0;
        System.out.println("Welcome to play TicTacTeo!");

        gameNotes();

        Board board = new Board();
        board.showBoard();

        System.out.println();
        System.out.println();

        System.out.println("Please choose the model to play:");
        System.out.println("1. Easy: Human plays first.");
        System.out.println("2. Hard: Computer plays first.");
        System.out.println("3. Exit the game");
        tempChoice = cin.nextInt();
        return tempChoice;
    }

    /**
     * To start the game, and get the result
     * @param choice human's choice
     * @param cin Scanner.cin
     */
    @SuppressWarnings("unused")
	public void showGameResult(int choice,Scanner cin)
    {
    	 do
         {
             if (choice == HUMANFIRST || choice == COMPUTERFIRST)
             {

                 if(choice == HUMANFIRST)
                 {
                     HumanFirst tempHumanFirst = new HumanFirst();
                 }
                 else
                 {
                 	ComputerFirst tempComputerFirst = new ComputerFirst();
                 }
             }
             else if(choice == EXIT_CHOICE)
             {
                 break;
             }
             else
             {
                 System.out.println("AN invalid choice! Please try again!");
             }
             System.out.println( );
             System.out.println("Play again or exit the game:");
             System.out.println("1. Easy");
             System.out.println("2. Hard");
             System.out.println("3. Exit the game");
             choice = cin.nextInt();
         } while (choice != EXIT_CHOICE);

         System.out.println( );
         System.out.println("Thanks for playing TicTacTeo!");
    }
}


