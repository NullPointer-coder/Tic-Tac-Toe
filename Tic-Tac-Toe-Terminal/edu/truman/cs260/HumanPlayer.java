/**
* @author Jingbo Wang
*  To store the step of human choice
*/

package edu.truman.cs260;
import java.util.Scanner;

public class HumanPlayer extends Player
{
  /**
   * To input the human's choice
   * @param cin the input character
   */
  public void inputHumPosition(Scanner cin)
  {
	  System.out.println("It is your turn to play.");
	  /*To make sure that the input row and col is valid */
      do
	  {
		  System.out.println("Please enter the row and col:");

	  	  String input=cin.nextLine();

	  	  /* To get the character of row and col */
	  	  char rowString=input.charAt(0);
	  	  char colString=input.charAt(input.length()-1);

	  	  /* change the character number of row and column to integer value */
	      setInputRow(Character.getNumericValue(rowString));
	      setInputCol(Character.getNumericValue(colString));

	      /*To test the input row and col is valid or not */
	      if(getInputRow() > LENGTH-1 || getInputRow() < 0 )
	      {
	    	  System.out.println("Invalid input row number. Please enter a "
	    	  		              + "number between 0 and 2.");
	      }
	      if(getInputCol() > LENGTH-1 || getInputCol() < 0)
	      {
	    	  System.out.println("Invalid input col number. Please enter a "
	    	  		              + "number between 0 and 2");
	      }
      }while((getInputRow() > LENGTH-1 || getInputRow() < 0 )||
    		 (getInputCol() > LENGTH-1 || getInputCol() < 0));
  }

  @Override
  public void setInput(Board tempboard,int whoseTurn)
  {
	  Test(tempboard);
	  tempboard.setPostion(position, whoseTurn);
  }

  @Override
  public void Test(Board tempboard)
  {
	  Scanner cin = new Scanner(System.in);
	  do
	  {
		  inputHumPosition(cin);
		  super.inputPosition();

		  if(!checkInputPosition(position, tempboard))
		  {
			  System.out.println("This Position is already marked. Please try again.");
		  }
	  }while(!checkInputPosition(position, tempboard));
	  super.inputPosition();
  }

}
