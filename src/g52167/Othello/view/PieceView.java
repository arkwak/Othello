package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * This Class permit to create Circles as a piece
 *
 * @author Laurent
 */
public class PieceView extends Circle {

    /**
     * Constrcutor of Piece view
     *
     * @param color the color of the circle (of the piece)
     */
    public PieceView(Color color) {

        super(30, color);

    }

}
