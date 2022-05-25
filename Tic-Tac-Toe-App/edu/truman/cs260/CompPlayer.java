/**
 * Jingbo wang
 */

package edu.truman.cs260;

import java.util.Random;

public class CompPlayer extends Player
{
    private final int DEFEND = -2;
    private final int ATTACK = 2;
    private final int FALSE = -1;

    public int [] spaciaPposition = {0, 2, 6, 8};

    // The range of random number
    private final int RANDOMRANGE = 9;

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
    public void setInput(Board tempboard, boolean whoseTurnFlag)
    {
        Test(tempboard);
        tempboard.setCompPostion(position, whoseTurnFlag);
    }

    @Override
    public void Test(Board tempBoard)
    {
        do
        {
			Random generatorPosition = new Random();
	        int randomPosition = generatorPosition.nextInt(RANDOMRANGE);
	        setPlayerPosition(randomPosition);

	        if(tempBoard.gameBoard[4]== 0)
	        {
	        	setPlayerPosition(4);
	        }

	        if(tempBoard.gameBoard[4] == -1 &&(tempBoard.gameBoard[0]==0 ||
	 	           tempBoard.gameBoard[2]==0 || tempBoard.gameBoard[6]==0 ||tempBoard.gameBoard[8]==0))
	        {
	        	Random generator = new Random();
		        int random = generator.nextInt(3);
	        	setPlayerPosition(spaciaPposition[random]);
	        }

            if((isDefendOrAttack(tempBoard, ATTACK)) || (isDefendOrAttack(tempBoard, DEFEND)))
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
        int sum = 0;
        int tempPosition = 0;

        //  Check 0-2
        for (int i = 0; i <(LENGTH / 3); i++)
        {
            sum += tempBoard.gameBoard[i];
        }
        if (sum == motion)
        {
        	for (int i = 0; i <(LENGTH/3); i++)
            {
                if(tempBoard.gameBoard[i] == 0)
                {
                	tempPosition = i;
                }
            }
            return tempPosition;
        }

        sum = 0;
        // Check 3-5
        for (int i = 3; i <((LENGTH / 3) * 2); i++)
        {
            sum += tempBoard.gameBoard[i];
        }
        if (sum == motion)
        {
        	for (int i = 3; i <((LENGTH / 3) * 2); i++)
            {
                if(tempBoard.gameBoard[i] == 0)
                {
                	tempPosition = i;
                }
            }
            return tempPosition;
        }

        sum = 0;
        // Check 6-8
        for (int i = 6; i <LENGTH; i++)
        {
            sum += tempBoard.gameBoard[i];
        }
        if (sum == motion)
        {
        	for (int i = 6; i <LENGTH; i++)
            {
                if(tempBoard.gameBoard[i] == 0)
                {
                	tempPosition = i;
                }
            }
            return tempPosition;
        }
        return FALSE;
    }

    /**
     * To check computer need to attack or defend for each column
     * @param tempBoard the game board
     * @param motion    defend or attack
     * @return if needs to defend or attack, return the column or not
     */
    public int DefendAndAttackCol(Board tempBoard, int motion)
    {
    	 int sum = 0;
         int tempPosition = 0;

         //  Check 0, 3, 6
         int i = 0;
         while (i < 7)
         {
             sum += tempBoard.gameBoard[i];
             i += 3;
         }
         if (sum == motion)
         {
        	i = 0;
        	 while (i < 7)
             {
        		 if(tempBoard.gameBoard[i] == 0)
                 {
                 	tempPosition = i;
                 }
                 i += 3;
             }
             return tempPosition;
         }

         sum = 0;
         // Check 1, 4, 7
         i = 1;
         while (i < 8)
         {
             sum += tempBoard.gameBoard[i];
             i += 3;
         }
         if (sum == motion)
         {
        	i = 1;
        	 while (i < 8)
             {
        		 if(tempBoard.gameBoard[i] == 0)
                 {
                 	tempPosition = i;
                 }
                 i += 3;
             }
             return tempPosition;
         }

         sum = 0;
         // Check 2, 5, 8
         i = 2;
         while (i < 9)
         {
             sum += tempBoard.gameBoard[i];
             i += 3;
         }
         if (sum == motion)
         {
        	i = 2;
        	while (i < 9)
            {
        		 if(tempBoard.gameBoard[i] == 0)
                 {
                 	tempPosition = i;
                 }
                 i += 3;
            }
            return tempPosition;
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
        int tempPosition = 0;
        int i = 2;
        while (i < 7)
        {
            RightToLeftDiagonal_sum += tempboard.gameBoard[i];
            i += 2;
        }
        i = 2;
        if(RightToLeftDiagonal_sum == motion)
        {
        	while (i < 7)
            {
        		if(tempboard.gameBoard[i] == 0)
                {
                	tempPosition = i;
                }
                i += 2;
            }
        	return tempPosition;
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
    	 int RightToLeftDiagonal_sum = 0;
         int tempPosition = 0;
         int i = 0;
         while (i < 9)
         {
             RightToLeftDiagonal_sum += tempboard.gameBoard[i];
             i += 4;
         }
         i = 0;
         if(RightToLeftDiagonal_sum == motion)
         {
         	while (i < 9)
             {
         		if(tempboard.gameBoard[i] == 0)
                 {
                 	tempPosition = i;
                 }
                 i += 4;
             }
         	return tempPosition;
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
            	setPlayerPosition(DefendAndAttackRow(tempBoard, motion));
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE)
            {
            	setPlayerPosition(DefendAndAttackCol(tempBoard, motion));
            }
            else if(DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
            	setPlayerPosition(DefendAndAttackRightToLeftDiagonal(tempBoard, motion));
            }
            else if (DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
            	setPlayerPosition(DefendAndAttackLeftToRightDiagonal(tempBoard, motion));
            }
            // both one row and one column need to defend in the same time
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE  && DefendAndAttackCol(tempBoard, motion) != FALSE)
            {
                // random choose one to defend
            	Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackRow(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackCol(tempBoard, motion));
                }
            }
           // both one row and one right to left Diagonal need to defend in the same time
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE
                    && DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackRow(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackRightToLeftDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackRow(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackLeftToRightDiagonal(tempBoard, motion));;
                }
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE
                    && DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackCol(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackRightToLeftDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackCol(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackLeftToRightDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackRightToLeftDiagonal(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackLeftToRightDiagonal(tempBoard, motion));
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
            	setPlayerPosition(DefendAndAttackRow(tempBoard, motion));
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE)
            {
            	setPlayerPosition(DefendAndAttackCol(tempBoard, motion));
            }
            else if(DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
            	setPlayerPosition(DefendAndAttackRightToLeftDiagonal(tempBoard, motion));
            }
            else if (DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
            	setPlayerPosition(DefendAndAttackLeftToRightDiagonal(tempBoard, motion));
            }
            // both one row and one column need to attck in the same time
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE  && DefendAndAttackCol(tempBoard, motion) != FALSE)
            {
                // random choose one to defend
            	Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackRow(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackCol(tempBoard, motion));
                }
            }
           // both one row and one right to left Diagonal need to attck in the same time
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE
                    && DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackRow(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackRightToLeftDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackRow(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackRow(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackLeftToRightDiagonal(tempBoard, motion));;
                }
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE
                    && DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackCol(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackRightToLeftDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackCol(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackCol(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackLeftToRightDiagonal(tempBoard, motion));
                }
            }
            else if (DefendAndAttackRightToLeftDiagonal(tempBoard, motion) != FALSE
                    && DefendAndAttackLeftToRightDiagonal(tempBoard, motion) != FALSE)
            {
                Random generator = new Random();
                int randomChoice = 1 + generator.nextInt(2);
                if (randomChoice == 1)
                {
                	setPlayerPosition(DefendAndAttackRightToLeftDiagonal(tempBoard, motion));
                }
                else
                {
                	setPlayerPosition(DefendAndAttackLeftToRightDiagonal(tempBoard, motion));
                }
            }
        }
    }
}
