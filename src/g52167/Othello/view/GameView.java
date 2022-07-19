package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.model.Game;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * This class manage the view of the game
 *
 * @author Laurent
 */
public class GameView extends VBox {

    BoardView boardView;
    UnderBoard underBoard;

    /**
     * Constructor for GameView
     */
    public GameView() {

        /*--------------------initialisation et ajout aux enfants--------------------*/
        this.boardView = new BoardView();
        this.underBoard = new UnderBoard();
        this.getChildren().add(this.boardView);
        this.getChildren().add(this.underBoard);

        /*--------------------Style--------------------*/
        this.setMinSize(500, 750);
        this.setMaxSize(500, 750);
        this.underBoard.setAlignment(Pos.TOP_CENTER);

    }

    /**
     * getter of boardView
     *
     * @return boardview
     */
    public BoardView getBoardView() {
        return boardView;
    }

    /**
     * getter of underboard
     *
     * @return underboard
     */
    public UnderBoard getUnderBoard() {
        return underBoard;
    }

    /**
     * update the children when updated
     *
     * @param game the actual game
     */
    public void update(Game game) {

        boardView.update(game);
        underBoard.update(game);
    }

}
