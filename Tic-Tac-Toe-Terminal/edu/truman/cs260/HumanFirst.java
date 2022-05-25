/**
* @author Jingbo Wang
* Choosing the easy model, and human goes first
*/

package edu.truman.cs260;

public class HumanFirst
{
	/**
	 * constructor for choosing the easy model, and human goes first
	 */
	public HumanFirst()
    {
            int turn = 0;
            int whoseTurn = 0;

            HumanPlayer firstPlayer = new HumanPlayer();
            CompPlayer secondPlayer = new CompPlayer();
            Board tempBoard = new Board();

            System.out.println( );

            System.out.println("Easy model game starts!");
            System.out.println("Human go first!");
            System.out.println( );
            tempBoard.showBoard();
            System.out.println( );

            while(!gameOver(tempBoard))
            {
            	System.out.println();
            	System.out.println("The " + (turn+1) +"'s turn.");
                if(whoseTurn == 0)
                {
                    firstPlayer.setInput(tempBoard,whoseTurn);
                    System.out.println();
                    System.out.println("You placed!");
                    tempBoard.showBoard();

                }
                else
                {
                    secondPlayer.setInput(tempBoard,whoseTurn);
                    System.out.println("It is Computer's turn to play.");
                    System.out.println("Computer placed!");
                    tempBoard.showBoard();
                }

                if(turn %2 == 0)
                {
                    whoseTurn = 1;
                }
                else {
                    whoseTurn = 0;
                }
                turn++;
            }

            tempBoard.displayWinner();
    }

    /**
     * To boolean the game is over or not
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
