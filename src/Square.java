import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    /**
     * Paints the square onto the screen
     * Includes painting filled in green square and X or O image if necessary
     * @param g Graphics object for paint functions
     * @param images Images needed to be painted on the screen
     * @param t Frontend object for displaying the screen
     */
    public void draw(Graphics g, Image[] images, TicTacToeViewer t)
    {
        // Start locations for coordinates of top left of square
        int xStart = col * 100 + 100;
        int yStart = row * 100 + 100;

        // Paints a filled in green square if the square is winning
        if (isWinningSquare) {
            g.setColor(Color.green);
            g.fillRect(xStart, yStart, 100, 100);
        }

        // Paints the open square in black
        g.setColor(Color.black);
        g.drawRect(xStart, yStart, 100, 100);
        // If user puts an X on square, paints X image over the square
        if (marker.equals("X"))
        {
            g.drawImage(images[1], xStart, yStart, 100, 100, t);
        }
        // If user puts an O on square, paints X image over the square
        else if (marker.equals("O"))
        {
            g.drawImage(images[0], xStart, yStart, 100, 100, t);
        }
    }
}
