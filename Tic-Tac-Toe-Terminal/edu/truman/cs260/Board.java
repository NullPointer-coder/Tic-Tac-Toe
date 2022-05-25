/**
* @author Jingbo Wang
*  To be the board in the game consisting
 * a 3x3 two dimensional array grid,
 * and record each step of the game, then show the winner.
*/

package edu.truman.cs260;

public class Board
{
    final int LENGTH = 3;
    final int HUMAN = -1;
    final int HUMANSUM = -3;
    final int COMPUTER = 1;
    final int COMPUTERSUM = 3;
    final int NULL = 0;

    public int[][] gameBoard= new int[LENGTH][LENGTH];

    /**
     * constructor for clear gameBoard
     */
    public Board()
    {
        clearBoard();
    }

    /**
     * clear board to 0
     */
    public void clearBoard()
    {
        for (int row=0; row < LENGTH; row++)
        {
            for (int col=0; col < LENGTH; col++)
            {
                gameBoard[row][col] = 0;
            }
        }
    }

    /**
     * To show the result of board
     */
    public void showBoard()
    {
    	System.out.println("       " + (LENGTH-3) + "   " + (LENGTH-2) + "   " + (LENGTH-1));

        for(int row=0; row < LENGTH; row++)
        {
        	System.out.print("    " + row + " ");
        	for(int col=0; col < LENGTH; col++)
            {
                if(gameBoard[row][col] == HUMAN)
                {
                    System.out.print(" H ");
                }
                if(gameBoard[row][col] == COMPUTER)
                {
                    System.out.print(" C ");
                }
                if(gameBoard[row][col] == NULL)
                {
                    System.out.print(" + ");
                }
                if(col < LENGTH-1)
                {
                    System.out.print("|");
                }
            }
            System.out.println();
            if(row < LENGTH-1)
            {
                System.out.println("      " + "-----------");
            }
        }
    }
    /**
     * To get player's chosen position and store into game board.
     * @param position the player's chosen position
     * @return to store into game board
     */
    public int getPostion(int[] position)
    {
        return gameBoard[position[0]][position[1]];
    }

    /**
     * To store which player's chosen position and store into game board.
     * @param position the player's chosen position
     * @param whoseTurn which player's turn to put
     */
    public void setPostion(int[] position, int whoseTurn)
    {
        if(whoseTurn == 0)
        {
            whoseTurn--;
        }
        if(whoseTurn == HUMAN)
        {
            gameBoard[position[0]][position[1]] = HUMAN;
        }
        if(whoseTurn == COMPUTER)
        {
            gameBoard[position[0]][position[1]] = COMPUTER;
        }
    }

    /**
     *  To check which player could win for each row
     */
    public int CheckRow()
    {
        for(int row = 0; row < LENGTH; row++)
        {
            int sum = 0;
            for(int col = 0; col <LENGTH; col++)
            {
                sum += gameBoard[row][col];
            }
            if(sum == HUMANSUM)
            {
                return HUMAN;
            }
            else if(sum ==COMPUTERSUM)
            {
                return COMPUTER;
            }
        }
        return NULL;
    }

    /**
     *  To check which player could win for each column
     */
    public int CheckCol()
    {

        for(int col = 0; col < LENGTH; col++)
        {
            int sum = 0;
            for(int row = 0; row < LENGTH; row++)
            {
                sum += gameBoard[row][col];
            }
            if(sum == HUMANSUM)
            {
                return HUMAN;
            }
            else if(sum ==COMPUTERSUM)
            {
                return COMPUTER;
            }
        }
        return NULL;
    }

    /**
     *  To check which player could win for right to left diagonal
     */
    public int CheckRightToLeftDiagonal()
    {
        int sum = 0;
        int col = LENGTH -1;
        for(int row = 0; row < LENGTH; row++)
        {
            sum += gameBoard[row][col];
            col--;
        }
        if(sum == HUMANSUM)
        {
            return HUMAN;
        }
        else if(sum ==COMPUTERSUM)
        {
            return COMPUTER;
        }
        return NULL;
    }

    /**
     * To check which player could win for left to right diagonal
     */
    public int CheckLeftToRightDiagonal()
    {
        int sum = 0;
        int row = 0;
        for(int col = 0; col < LENGTH; col++)
        {

            sum += gameBoard[row][col];
            row++;
        }
        if(sum == HUMANSUM)
        {
            return HUMAN;
        }
        else if(sum ==COMPUTERSUM)
        {
            return COMPUTER;
        }

        return NULL;
    }

    /**
     * To check which player is winner
     */
    public int Winner()
    {
        if(CheckRow() == HUMAN)
        { return HUMAN; }
        if(CheckCol() == HUMAN)
        { return HUMAN; }
        if(CheckRightToLeftDiagonal() == HUMAN)
        { return HUMAN; }
        if(CheckLeftToRightDiagonal() == HUMAN)
        { return HUMAN; }

        if(CheckRow() == COMPUTER)
        { return COMPUTER; }
        if(CheckCol() == COMPUTER)
        { return COMPUTER; }
        if(CheckRightToLeftDiagonal() == COMPUTER)
        { return COMPUTER; }
        if(CheckLeftToRightDiagonal() == COMPUTER)
        { return COMPUTER; }

        return NULL;
    }

    /**
     * To check the game board is full by two players or not
     * @return the game board is full or not
     */
    public boolean isFull()
    {
        for(int row=0; row < LENGTH; row++)
        {
            for(int col=0; col < LENGTH; col++)
            {
                if(gameBoard[row][col] == NULL)
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * To Check have the winner or not
     * @return have the winner or not
     */
    public boolean hasWinner()
    {
        if(Winner() == HUMAN || Winner() == COMPUTER)
        {
            return true;
        }
        return false;
    }

    /**
     * To show which one is winner or the game is stalemate
     */
    public void displayWinner()
    {
        if(Winner() == HUMAN)
        {
        	System.out.println();
        	System.out.println("Congratulations! You are the winner!");
        }
        else if(Winner() == COMPUTER)
        {
        	System.out.println();
        	System.out.println("Sorry! You lost! Computer is the winner!");
        }
        else
        {
        	System.out.println();
        	System.out.println("Game is stalemate! No winner!");
        }
    }
}
