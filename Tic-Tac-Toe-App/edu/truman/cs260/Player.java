/**
 * Jingbo wang
 */
package edu.truman.cs260;

public abstract class Player
{
	final int SIZE = 1;
	protected final int LENGTH = 9;
	private int playerPosition;
	// To store the choice of player
	public int [] position = new int[SIZE];

	public int getPlayerPosition()
	{ return playerPosition;}

	public void setPlayerPosition(int playerPosition)
	{this.playerPosition = playerPosition;}

	/* To store the choice of player into the game board */
	public abstract void setInput(Board tempboard,boolean whoseTurnFlag);

	/* To check the input position works or not */
	public abstract void Test(Board tempboard);

	/**
	 *  To store the choice of player into the position array
	 */
	public void inputPosition()
	{
		position[0] = getPlayerPosition();
	}

	/**
	 *  To check the position is chosen or not
	 * @param position an array to store the choice of player
	 * @param temBoard the game board
	 * @return the position is chosen or not
	 */
	public boolean checkInputPosition(int position[], Board temBoard)
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
