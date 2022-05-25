/**
* @author Jingbo Wang
*
* To gave computer's choices and store them
*/
package edu.truman.cs260;

import java.util.Random;

public class CompPlayer extends Player
{
    private final int DEFEND = -2;
    private final int ATTACK = 2;
    private final int FALSE = 3;

    // The range of random number
    private final int RANDOMRANGE = 3;

    /**
     * To get computer's position
     * @param tempBoard the game board
     */
    public void inputComPosition(Board tempBoard)
    {
       isDefined(tempBoard);
       isAttack(tempBoard);
    }

    @Override
    public void setInput(Board tempboard,int whoseTurn)
    {
        Test(tempboard);
        tempboard.setPostion(position, whoseTurn);
    }

    @Override
    public void Test(Board tempBoard)
    {
        do
        {
			Random generator_row = new Random();
	        int randomRow = generator_row.nextInt(RANDOMRANGE);
	        Random generator_col = new Random();
	        int randomCol = generator_col.nextInt(RANDOMRANGE);

	        setInputRow(randomRow);
	        setInputCol(randomCol);

	        if(tempBoard.gameBoard[1][1]==0)
	        {
	        	setInputRow(1);
	        	setInputCol(1);
	        }

            if((isDefendOrAttack(tempBoard, ATTACK)) ||(isDefendOrAttack(tempBoard, DEFEND)))
            {
        	   inputComPosition(tempBoard);
       	    }

        	super.inputPosition();

        }while(!checkInputPosition(position, tempBoard));
        super.inputPosition();
    }

    /**
     * To check computer need to attack or defend for each row
     * @param tempBoard the game board
     * @param motion    defend or attack
     * @return if needs to defend or attack, return the row or not
     */
    public int DefendAndAttackRow(Board tempBoard,int motion)
    {
        int tempRow = 0;
        for (int row = 0; row <LENGTH; row++)
        {
            int sum = 0;
            for (int col = 0; col < LENGTH; col++)
            {
                sum += tempBoard.gameBoard[row][col];
            }
            if (sum == motion)
            {
                tempRow =row;
               return tempRow;
            }
        }
        return FALSE;
    }

    /**
     * To get the column of the position which needs to defend or attack or not
     * @param tempBoard the game board
     * @param motion    defend or attack
     * @return   the column of the position which needs to defend or attack or not
     */
    public int getDefendAndAttackRowCol(Board tempBoard,int motion)
    {
        int tempRow = 0;
        int tempCol = 0;
        if(DefendAndAttackRow(tempBoard,motion) != FALSE)
        {
            tempRow=DefendAndAttackRow(tempBoard,motion);
            for (int col = 0; col < LENGTH; col++)
            {
                if(tempBoard.gameBoard[tempRow][col]  == 0)
                {
                    tempCol = col;
                    return tempCol;
                }
            }
        }
        return FALSE;
    }

    /**
     * To check computer need to attack or defend for each column
     * @param tempBoard the game board
     * @param motion    defend or attack
     * @return if needs to defend or attack, return the column or not
     */
    public int DefendAndAttackCol(Board tempboard,int motion)
    {

        for (int col = 0; col < LENGTH; col++)
        {
            int sum = 0;
            for (int row = 0; row < LENGTH; row++)
            {
                sum += tempboard.gameBoard[row][col];
            }
            if (sum == motion)
            {
                return col;
            }
        }
        return FALSE;
    }

    /**
     * To get the row of the position which needs to defend or attack or not
     * @param tempBoard the game board
     * @param motion    defend or attack
     * @return   the row of the position which needs to defend or attack or not
     */
    public int getDefendAndAttackColRow(Board tempboard,int motion)
    {
        if(DefendAndAttackCol(tempboard, motion) != FALSE)
        {
            int tempCol = DefendAndAttackCol(tempboard, motion);
            for (int row = 0; row < LENGTH; row++)
            {
                if(tempboard.gameBoard[row][tempCol]  == 0)
                {
                    return row;
                }
            }
        }
        return FALSE;
    }


    /**
     * To check computer need to attack or defend for right to left diagonal or not
     * @param tempBoard the game board
     * @param motion    defend or attack
     * @return if needs to defend or attack or not
     */
    public int DefendAndAttackRightToLeftDiagonal(Board tempboard, int motion)
    {
        int RightToLeftDiagonal_sum = 0;
        int col = LENGTH - 1;
        for(int row = 0; row < LENGTH; row++)
        {
            RightToLeftDiagonal_sum += tempboard.gameBoard[row][col];
            col--;
        }
        if(RightToLeftDiagonal_sum == motion)
        {
            return 1;
        }
        return FALSE;
    }

    /**
     * To get row if computer need to attack or defend for right to left diagonal or not
     * @param tempboard the game board
     * @param motion    defend or attack
     * @return the row of the position which needs to defend or attack or not
     */
    public int getRowRightToLeftDiagonal(Board tempboard,int motion)
    {
        if(DefendAndAttackRightToLeftDiagonal(tempboard, motion) != FALSE)
        {
            int col = LENGTH - 1;

            for(int row = 0; row < LENGTH; row++)
            {
                if(tempboard.gameBoard[row][col] == 0)
                {
                  return row;
                }
                col--;
            }
        }
        return FALSE;
    }

    /**
     * To get column if computer need to attack or defend for right to left diagonal or not
     * @param tempboard the game board
     * @param motion    defend or attack
     * @return the column of the position which needs to defend or attack or not
     */
    public int getColRightToLeftDiagonal(Board tempboard, int motion)
    {
        if( DefendAndAttackRightToLeftDiagonal(tempboard, motion) != FALSE)
        {
            int col = LENGTH - 1;
            for(int row = 0; row < LENGTH; row++)
            {
                if(tempboard.gameBoard[row][col] == 0)
                {
                    return col;
                }
                col--;
            }
        }
        return FALSE;
    }

    /**
     * To check computer need to attack or defend for left to right diagonal or not
     * @param tempBoard the game board
     * @param motion    defend or attack
     * @return if needs to defend or attack or not
     */
    public int DefendAndAttackLeftToRightDiagonal(Board tempboard, int motion)
    {
        int LeftToRightDiagonal_sum = 0;
        int row = 0;
        for(int col = 0; col < LENGTH; col++)
        {
            LeftToRightDiagonal_sum += tempboard.gameBoard[row][col];
            row++;
        }
        if(LeftToRightDiagonal_sum == motion)
        {
            return 1;
        }

        return FALSE;
    }

    /**
     * To get row if computer need to attack or defend for left to right diagonal or not
     * @param tempboard the game board
     * @param motion    defend or attack
     * @return the row of the position which needs to defend or attack or not
     */
    public int getRowLeftToRightDiagonal(Board tempboard,int motion)
    {
        if(DefendAndAttackLeftToRightDiagonal(tempboard,motion) != FALSE)
        {
            int col = 0;
            for (int row = 0; row < LENGTH; row++)
            {
                if (tempboard.gameBoard[row][col] == 0)
                {
                    return row;
                }
                col++;
            }
        }
        return FALSE;
    }

    /**
     * To get column if computer need to attack or defend for left to right diagonal or not
     * @param tempboard the game board
     * @param motion    defend or attack
     * @return the column of the position which needs to defend or attack or not
     */
    public int getColLeftToRightDiagonal(Board tempboard,int motion)
    {
        if (DefendAndAttackLeftToRightDiagonal(tempboard, motion) != FALSE)
        {
            int col = 0;
            for (int row = 0; row < LENGTH; row++)
            {
                if (tempboard.gameBoard[row][col] == 0)
                {
                	return col;
                }
                col++;
            }
        }
        return FALSE;
    }

    /**
     * To boolean computer need to attack or defend for left to right diagonal or not
     * @param tempboard the game board
     * @param motion    defend or attack
     * @return needs to defend or attack or not
     */
    public boolean isDefendOrAttack(Board tempboard,int motion)
    {
        if(DefendAndAttackRow(tempboard,motion) !=FALSE || DefendAndAttackCol(tempboard,motion) != FALSE
           || DefendAndAttackRightToLeftDiagonal(tempboard,motion) != FALSE ||
              DefendAndAttackLeftToRightDiagonal(tempboard, motion) != FALSE)
        {
            return true;
        }
        return false;
    }

    /**
     *  Computer needs to defend
     */
    public void isDefined(Board tempBoard)
    {
        int motion = DEFEND;
        if (isDefendOrAttack(tempBoard, motion))
        {
            if (DefendAndAttackRow(tempBoard, motion) != FALSE)
            {
                setInputRow(DefendAndAttackRow(tempBoard, motion));
                setInputCol(getDefendAndAttackRowCol(tempBoard, motion));
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE)
            {
                setInputRow(getDefendAndAttackColRow(tempBoard, motion));
                setInputCol(DefendAndAttackCol(tempBoard, motion));
                super.inputPosition();
            }
            else if(DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                setInputRow(getRowRightToLeftDiagonal(tempBoard, motion));
                setInputCol(getColRightToLeftDiagonal(tempBoard, motion));
            }
            else if (DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                setInputRow(getRowLeftToRightDiagonal(tempBoard, motion));
                setInputCol(getColLeftToRightDiagonal(tempBoard, motion));
            }
            // both one row and one column need to defend in the same time
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE  && DefendAndAttackCol(tempBoard, motion) != FALSE)
            {
                // random choose one to defend
            	Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(DefendAndAttackRow(tempBoard, motion));
                    setInputCol(getDefendAndAttackRowCol(tempBoard, motion));
                }
                else
                {
                    setInputRow(getDefendAndAttackColRow(tempBoard, motion));
                    setInputCol(DefendAndAttackCol(tempBoard, motion));
                }
            }
           // both one row and one right to left Diagonal need to defend in the same time
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE
                    && DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(DefendAndAttackRow(tempBoard, motion));
                    setInputCol(getDefendAndAttackRowCol(tempBoard, motion));
                }
                else
                {
                    setInputRow(getRowRightToLeftDiagonal(tempBoard, motion));
                    setInputCol(getColRightToLeftDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(DefendAndAttackRow(tempBoard, motion));
                    setInputCol(getDefendAndAttackRowCol(tempBoard, motion));
                } else
                {
                    setInputRow(getRowLeftToRightDiagonal(tempBoard, motion));
                    setInputCol(getColLeftToRightDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE
                    && DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(getDefendAndAttackColRow(tempBoard, motion));
                    setInputCol(DefendAndAttackCol(tempBoard, motion));
                }
                else
                {
                    setInputRow(getRowRightToLeftDiagonal(tempBoard, motion));
                    setInputCol(getColRightToLeftDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(getDefendAndAttackColRow(tempBoard, motion));
                    setInputCol(DefendAndAttackCol(tempBoard, motion));
                } else
                {
                    setInputRow(getRowLeftToRightDiagonal(tempBoard, motion));
                    setInputCol(getColLeftToRightDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(getRowRightToLeftDiagonal(tempBoard, motion));
                    setInputCol(getColRightToLeftDiagonal(tempBoard, motion));
                }
                else
                {
                    setInputRow(getRowLeftToRightDiagonal(tempBoard, motion));
                    setInputCol(getColLeftToRightDiagonal(tempBoard, motion));
                }
            }
        }
    }

    /**
     * Computer needs to attack
     */
    public void isAttack(Board tempBoard)
    {
        int motion = ATTACK;
        if (isDefendOrAttack(tempBoard, motion))
        {
            if (DefendAndAttackRow(tempBoard, motion) != FALSE)
            {
                setInputRow(DefendAndAttackRow(tempBoard, motion));
                setInputCol(getDefendAndAttackRowCol(tempBoard, motion));
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE)
            {
                setInputRow(getDefendAndAttackColRow(tempBoard, motion));
                setInputCol(DefendAndAttackCol(tempBoard, motion));
            }
            else if(DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                setInputRow(getRowRightToLeftDiagonal(tempBoard, motion));
                setInputCol(getColRightToLeftDiagonal(tempBoard, motion));
            }
            else if (DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                setInputRow(getRowLeftToRightDiagonal(tempBoard, motion));
                setInputCol(getColLeftToRightDiagonal(tempBoard, motion));
            }
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE  && DefendAndAttackCol(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(DefendAndAttackRow(tempBoard, motion));
                    setInputCol(getDefendAndAttackRowCol(tempBoard, motion));
                }
                else
                {
                    setInputRow(getDefendAndAttackColRow(tempBoard, motion));
                    setInputCol(DefendAndAttackCol(tempBoard, motion));
                }
            }
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE
                    && DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(DefendAndAttackRow(tempBoard, motion));
                    setInputCol(getDefendAndAttackRowCol(tempBoard, motion));
                }
                else
                {
                    setInputRow(getRowRightToLeftDiagonal(tempBoard, motion));
                    setInputCol(getColRightToLeftDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(DefendAndAttackRow(tempBoard, motion));
                    setInputCol(getDefendAndAttackRowCol(tempBoard, motion));
                } else
                {
                    setInputRow(getRowLeftToRightDiagonal(tempBoard, motion));
                    setInputCol(getColLeftToRightDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE
                    && DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(getDefendAndAttackColRow(tempBoard, motion));
                    setInputCol(DefendAndAttackCol(tempBoard, motion));
                    super.inputPosition();
                }
                else
                {
                    setInputRow(getRowRightToLeftDiagonal(tempBoard, motion));
                    setInputCol(getColRightToLeftDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(getDefendAndAttackColRow(tempBoard, motion));
                    setInputCol(DefendAndAttackCol(tempBoard, motion));
                } else
                {
                    setInputRow(getRowLeftToRightDiagonal(tempBoard, motion));
                    setInputCol(getColLeftToRightDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(RANDOMRANGE-1);
                if (randomChoice == 1)
                {
                    setInputRow(getRowRightToLeftDiagonal(tempBoard, motion));
                    setInputCol(getColRightToLeftDiagonal(tempBoard, motion));
                }
                else
                {
                    setInputRow(getRowLeftToRightDiagonal(tempBoard, motion));
                    setInputCol(getColLeftToRightDiagonal(tempBoard, motion));
                }
            }
        }
    }

}
