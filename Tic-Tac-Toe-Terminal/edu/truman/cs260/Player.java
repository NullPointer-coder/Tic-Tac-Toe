/**
* @author Jingbo Wang
*  To store the choice of player
*/

package edu.truman.cs260;

public abstract class Player
{
	protected final int LENGTH = 3;
	private int inputRow;
	private int inputCol;

	// To store the choice of player
	public int [] position = new int[2];

	public int getInputRow()
	{ return inputRow; }

	public void setInputRow(int inputRow)
	{this.inputRow = inputRow; }

	public  int getInputCol()
	{ return inputCol; }

	public void setInputCol(int inputCol)
	{ this.inputCol = inputCol; }

	/**
	 *  To store the choice of player into the position array
	 */
	public void inputPosition()
	{
		position[0] = getInputRow();
		position[1] = getInputCol();
	}

	/* To store the choice of player into the game board */
	public abstract void setInput(Board tempboard,int whoseTurn);

	/* To check the input position works or not */
	public abstract void Test(Board tempboard);

	/**
	 *  To check the position is chosen or not
	 * @param position an array to store the choice of player
	 * @param temBoard the game board
	 * @return the position is chosen or not
	 */
	public boolean checkInputPosition(int[] position, Board temBoard)
	{
		if(temBoard.getPostion(position) == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
