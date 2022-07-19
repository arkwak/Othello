package g52167.Othello.model;

import java.util.List;

/**
 * Model of Othello
 *
 * @author Laurent
 */
public interface Model {

    /**
     * Initializes the Othello game with a default board.
     */
    void initialize();

    /**
     * Checks if a match can start.
     *
     * @throws IllegalStateException if no board is set.
     * @throws IllegalStateException if the board set is incomplete.
     */
    void start();

    /**
     * Declares if it's the end of the game.
     *
     * @return true if it's the end of the game.
     */
    boolean isOver();

    /**
     * Returns the board.
     *
     * @return the board.
     */
    Square[][] getBoard();

    /**
     * the list of possible moves
     *
     * @return the list of possible moves
     */
    Player getCurrent();

    /**
     * get the winner of the game
     *
     * @return the winner of the game
     */
    List<Player> getWinner();

    /**
     * count the points of the player we want
     *
     * @param color the color of the player
     * @return his points
     */
    int countPoints(PlayerColor color);

    /**
     * make a move putting a piece on the board at the position we want
     *
     * @param position the position where we want to put a piece
     */
    void move(Position position);
}
