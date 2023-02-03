import javax.swing.*;
import java.awt.*;

/**
 * A class written to paint the TicTacToe game.
 *
 * This class contains information regarding the window size, images, and
 * the back-end TicTacToe class.
 * It is responsible for painting the screen.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */
public class TicTacToeViewer extends JFrame {
    private Image[] images;
    /** Window information **/
    private final int WINDOW_WIDTH = 750;
    private final int WINDOW_HEIGHT = 750;
    /** Instance of backend **/
    private TicTacToe t;

    /**
     * Constructor which initializes the TicTacToe object passed in.
     * Also initializes images in Resources folder in an array of Images.
     * Sets window information (size, visibility, close operation, title).
     * @param t
     */
    public TicTacToeViewer(TicTacToe t)
    {
        // Initializes instantiation of the TicTacToe class
        this.t = t;
        // Initializes X and O images in Images array images
        images = new Image[2];
        images[0] = new ImageIcon("Resources/O.png").getImage();
        images[1] = new ImageIcon("Resources/X.png").getImage();

        // Sets title, size, visibility, and close operation of new window created
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    /**
     * Method to paint the entire board.
     * Loops through each square and calls function to draw itself.
     * If there is a winner in the game, paints who the winner is on the screen.
     * @param g the specified Graphics window
     */
    public void paint(Graphics g)
    {
        // Sets numbers indicating the identification of each column (0 - 2)
        for (int i = 0; i < 3; i++)
        {
            g.drawString(String.valueOf(i), 150 + 100 * i, 50);
        }
        // Sets numbers indicating the identification of each row (0 - 2)
        for (int i = 0; i < 3; i++)
        {
            g.drawString(String.valueOf(i), 50, 150 + 100 * i);
        }
        Square[][] board = t.getBoard();
        // Loops through each square in the board and calls its draw methof
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j].draw(g, images, this);
            }
        }
        String winner = t.getWinner();
        // If there is a winner in the game, prints the winner of the game (X or O)
        if (!winner.equals("-"))
        {
            // Sets font size and style to serif, bold, and italics, as well as bigger size
            g.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 50));
            g.drawString(winner + " wins!", 375, 600);
        }
    }
}
