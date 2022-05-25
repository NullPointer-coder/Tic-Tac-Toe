/**
*@author: Jingbo Wang
**/
import edu.truman.cs260.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeApp implements ActionListener
{
	final int SIZE = 9;
    final int HUMAN = -1;
    final int COMPUTER = 1;
	// Buttons to hold the selection values
	JButton boardButtons[]= new JButton[SIZE];

	CompPlayer computerPlayer = new CompPlayer();
    Board tempBoard = new Board();

	// buttons to restart or exit the game
	JButton bRestart;
	JButton bExit;

	// to provide status message
	JLabel gameStatusLabel;
	JFrame gWindow; // main window object

	boolean moveToggleFlag = false; // toggles computer/user move
	boolean gameOver = false;
	int gameMoveCount =0; // counts the number of moves to determine draw, etc

	// constructor
	public TicTacToeApp(String title) {

		// creating a JFrame window with the title
		gWindow = new JFrame(title);

		// The JPanel holds the buttons
		JPanel upperLayerPanel = new JPanel();
		upperLayerPanel.setLayout(new GridLayout(3, 3));
		// creating memory for the buttons
		for(int i=0;i<SIZE;i++){
			boardButtons[i] = new JButton();
			boardButtons[i].setText(Integer.toString(i+1));
			boardButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 20));
			boardButtons[i].addActionListener(this);

			// adding the button to the Panel
			upperLayerPanel.add(boardButtons[i]);
		}



		// Panel holding buttons at the south side
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2, 1));

		bRestart = new JButton("Restart Game");
		bRestart.setFont(new Font("SansSerif", Font.PLAIN, 16));
		bRestart.addActionListener(this);

		bExit = new JButton("Exit Game");
		bExit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		bExit.addActionListener(this);


		gameStatusLabel= new JLabel("   Welcome. Your Turn. Select any button above to begin ..");
		gameStatusLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		gameStatusLabel.setPreferredSize(new Dimension(100, 40));

		southPanel.add(gameStatusLabel, BorderLayout.CENTER);

		JPanel lowerButtonPanel =new JPanel();
		lowerButtonPanel.setLayout(new GridLayout(1, 2));
		lowerButtonPanel.add(bRestart, BorderLayout.WEST);
		lowerButtonPanel.add(bExit, BorderLayout.EAST);
		southPanel.add(lowerButtonPanel);


		// adding all the panels to the main window
		gWindow.setLayout(new BorderLayout());
		gWindow.add(upperLayerPanel, BorderLayout.CENTER);
		gWindow.add(southPanel, BorderLayout.SOUTH);


		gWindow.setSize(500, 500);
		gWindow.setVisible(true);
		gWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	// this resets the buttons text values
	public void resetGame()
	{
		// creating memory for the buttons
		for(int i=0;i<SIZE;i++){
			boardButtons[i].setText(Integer.toString(i+1));
			boardButtons[i].setForeground(Color.BLACK);

		}

		gameMoveCount = 0;

		// other actions can be taken here
	}


	// Handles clicks on Compute button by computing the BMI.
	public void actionPerformed(ActionEvent event)
	{
		// if the event source is the restart button then
		if(event.getSource().equals(bRestart)){
			resetGame();
			tempBoard.clearBoard();
			this.gameStatusLabel.setText("   Game has restarted. Select any button above to begin ..");
			gWindow.setTitle("TicTacToe [Your Turn]"); // this can be randomized
		}
		else if(event.getSource().equals(bExit))
		{
			System.exit(0);
		}
		else
		{
			// determine which cell button triggered the action event
			for(int i=0;i<SIZE;i++)
			{
				if(event.getSource().equals(boardButtons[i])){ // button found
					// if the cell has already been selected then do not do anything
					if(boardButtons[i].getText().equals("H") == false && boardButtons[i].getText().equals("C") == false)
					{
						if(tempBoard.hasWinner())
						{
							if(tempBoard.Winner() == HUMAN)
					        {
								gameStatusLabel.setText("    Congratulations! You are the winner! Restart the game to continue ...");
								gWindow.setTitle("TicTacToe [Game Over!]");
					        }
					        else if(tempBoard.Winner() == COMPUTER)
					        {
								gameStatusLabel.setText("    Sorry! You lost! Computer is the winner! Restart the game to continue ...");
								gWindow.setTitle("TicTacToe [Game Over!]");
					        }
						}
						else if(gameMoveCount == SIZE)
						{
						  // if this is the last move
						  gameStatusLabel.setText("    The Game Over! No Winner! Restart the game to continue ...");
						  gWindow.setTitle("TicTacToe [Game Over!]");

						}
						else
						{
						// this is the selected cell number
						gameStatusLabel.setText("  You have selected cell no " + (i+1) );

					    gWindow.setTitle("TicTacToe [Computers Turn]");
					    boardButtons[i].setText("H");
						boardButtons[i].setForeground(Color.BLUE);
						tempBoard.setHumanPostion(i);
						gameMoveCount ++; // keep counting the moves

						if(tempBoard.hasWinner())
						{
							if(tempBoard.Winner() == HUMAN)
					        {
								gameStatusLabel.setText("    Congratulations! You are the winner! Restart the game to continue ...");
								gWindow.setTitle("TicTacToe [Game Over!]");
					        }
					        else if(tempBoard.Winner() == COMPUTER)
					        {
								gameStatusLabel.setText("    Sorry! You lost! Computer is the winner! Restart the game to continue ...");
								gWindow.setTitle("TicTacToe [Game Over!]");
					        }

						}
						else if(gameMoveCount == SIZE)
						{
						  // if this is the last move
						  gameStatusLabel.setText("    The Game Over! No Winner! Restart the game to continue ...");
						  gWindow.setTitle("TicTacToe [Game Over!]");

						}
						else
						{
						  moveToggleFlag = !moveToggleFlag;
						  computerPlayer.setInput(tempBoard,moveToggleFlag);

						  gWindow.setTitle("TicTacToe [Your Turn]");
						  gameStatusLabel.setText("  Computer have selected cell no " + (computerPlayer.getPlayerPosition()+ 1));
						  boardButtons[ computerPlayer.getPlayerPosition()].setText("C");
						  boardButtons[ computerPlayer.getPlayerPosition()].setForeground(Color.RED);

   						  moveToggleFlag = !moveToggleFlag;
						  gameMoveCount ++; // keep counting the moves
						}
					  } // boolean have winner or not
					} // new move: if condition ends
				} // main if inside the loop ends
			  } // for loop ends
		} // else block ends
	} // actionPerformed function ends


	// main driver program
	public static void main(String[] args)
	{
		// create an object of the TikTakToe class
		@SuppressWarnings("unused")
		TicTacToeApp gameWindow = new TicTacToeApp("TikTakToe Game");
	}

}
