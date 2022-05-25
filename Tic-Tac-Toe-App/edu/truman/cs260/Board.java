/**
 * Jingbo wang
 */
package edu.truman.cs260;

public class Board
{
    final int LENGTH = 9;
    final int HUMAN = -1;
    final int HUMANSUM = -3;
    final int COMPUTER = 1;
    final int COMPUTERSUM = 3;
    final int NULL = 0;

    public int gameBoard[] = new int[LENGTH];

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
        for (int i = 0; i < LENGTH; i++)
        {
           gameBoard[i] = 0;
        }
    }

    /**
     * To get player's chosen position and store into game board.
     * @param position the player's chosen position
     * @return to store into game board
     */
    public int getPostion(int position[])
    {
        return gameBoard[position[0]];
    }

    /**
     * To store which Human's chosen position and store into game board.
     * @param position the player's chosen position
     * @param whoseTurnFlag Boolean value which player's turn to put
     */
    public void setHumanPostion(int position)
    {
       gameBoard[position] = HUMAN;
    }

    /**
     * To store which Computer's chosen position and store into game board.
     * @param position the player's chosen position
     * @param whoseTurnFlag Boolean value which player's turn to put
     */
    public void setCompPostion(int position[], boolean whoseTurnFlag)
    {
        if(whoseTurnFlag == true)
        {
            gameBoard[position[0]] = COMPUTER;
        }
    }

    /**
     *  To check which player could win for each row
     */
    public int CheckRow()
    {
    	int sum = 0;

        //  Check 0-2
        for (int i = 0; i <(LENGTH / 3); i++)
        {
            sum += gameBoard[i];
        }
        if(sum == HUMANSUM)
        {
            return HUMAN;
        }
        else if(sum ==COMPUTERSUM)
        {
            return COMPUTER;
        }

        sum = 0;
        // Check 3-5
        for (int i = 3; i <((LENGTH / 3) * 2); i++)
        {
            sum += gameBoard[i];
        }
        if(sum == HUMANSUM)
        {
            return HUMAN;
        }
        else if(sum ==COMPUTERSUM)
        {
            return COMPUTER;
        }

        sum = 0;
        // Check 6-8
        for (int i = 6; i <LENGTH; i++)
        {
            sum += gameBoard[i];
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
     *  To check which player could win for each column
     */
    public int CheckCol()
    {
        int sum = 0;
        //  Check 0, 3, 6
        int i = 0;
        while (i < 7)
        {
            sum += gameBoard[i];
            i += 3;
        }

        if(sum == HUMANSUM)
        {
            return HUMAN;
        }
        else if(sum ==COMPUTERSUM)
        {
            return COMPUTER;
        }

        sum = 0;
        // Check 1, 4, 7
        i = 1;
        while (i < 8)
        {
            sum += gameBoard[i];
            i += 3;
        }

        if(sum == HUMANSUM)
        {
            return HUMAN;
        }
        else if(sum ==COMPUTERSUM)
        {
            return COMPUTER;
        }

        sum = 0;
        // Check 2, 5, 8
        i = 2;
        while (i < 9)
        {
            sum += gameBoard[i];
            i += 3;
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
     *  To check which player could win for right to left diagonal
     */
    public int CheckRightToLeftDiagonal()
    {
    	 int RightToLeftDiagonal_sum = 0;
         int i = 2;
         while (i < 7)
         {
             RightToLeftDiagonal_sum += gameBoard[i];
             i += 2;
         }

         if(RightToLeftDiagonal_sum == HUMANSUM)
         {
             return HUMAN;
         }
         else if(RightToLeftDiagonal_sum == COMPUTERSUM)
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
    	 int RightToLeftDiagonal_sum = 0;
         int i = 0;
         while (i < 9)
         {
             RightToLeftDiagonal_sum += gameBoard[i];
             i += 4;
         }

        if(RightToLeftDiagonal_sum == HUMANSUM)
        {
            return HUMAN;
        }
        else if(RightToLeftDiagonal_sum == COMPUTERSUM)
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
        for(int i = 0; i < LENGTH; i++)
        {
            if(gameBoard[i] == NULL)
            {
                return false;
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
}
