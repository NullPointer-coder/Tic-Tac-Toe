/**
* @author Jingbo Wang
* Choosing the Hard model, and computer goes first
*/

package edu.truman.cs260;

public class ComputerFirst
{
	/**
	 *  constructor for choosing the Hard model, the computer goes first
	 */
	public  ComputerFirst()
    {
            int turn = 0;
            int whoseTurn = 0;

            HumanPlayer secondPlayer = new HumanPlayer();
            CompPlayer firstPlayer = new CompPlayer();
            Board tempBoard = new Board();

            System.out.println( );

            System.out.println("Hard model game starts!");
            System.out.println("Computer goes first!");

            do
            {
            	System.out.println();
            	System.out.println("The " + (turn+1) +"'s turn.");

            	// To get whose turn
            	 if(turn %2 == 0)
                 {
                     whoseTurn = 1;
                 }
                 else
                 {
                     whoseTurn = 0;
                 }

            	// human player's turn
            	if(whoseTurn == 0)
                {
                    secondPlayer.setInput(tempBoard,whoseTurn);
                    System.out.println();
                    System.out.println("You placed!");
                    tempBoard.showBoard();

                }
            	// computer's turn
                else
                {

                    firstPlayer.setInput(tempBoard,whoseTurn);
                    System.out.println("It is Computer's turn to play.");
                    System.out.println("Computer placed!");
                    tempBoard.showBoard();
                    System.out.println();
                }
                turn++;
            }while(!gameOver(tempBoard));

            // display the result
            tempBoard.displayWinner();
    }

	/**
	 * TO boolean the game is over or not
	 * @param tempBoard the game board
	 * @return the game is over or not
	 */
    public boolean gameOver(Board tempBoard)
        {
           if(tempBoard.isFull() == false && tempBoard.hasWinner() == false)
           {
               return false;
           }
            return true;
        }
}
