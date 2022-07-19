package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * This class manage a square
 *
 * @author Laurent
 */
public class SquareView extends StackPane {

    PieceView pieceView;

    /**
     *
     */
    public SquareView() {

        /*--------------------Style--------------------*/
        this.setStyle("-fx-background-color: lightgrey");
        this.setMinSize(62, 62);
        this.setMaxSize(62, 62);
        this.setAlignment(Pos.CENTER);
        this.setBorder(new Border(new BorderStroke(Color.DIMGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

    }

    /**
     * getter of PieceView
     *
     * @return PieceView
     */
    public PieceView getPieceView() {
        return pieceView;
    }

    /**
     * it adds a circle in the square
     *
     * @param color the color of the circle (of the Player)
     */
    public void addCircle(Color color) {

        this.getChildren().add(new PieceView(color));

    }

}
