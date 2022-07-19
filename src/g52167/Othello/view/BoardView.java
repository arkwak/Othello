package g52167.Othello.view;


/*--------------------imports utiles--------------------*/
import g52167.Othello.controller.ControllerExit;
import g52167.Othello.model.Game;
import g52167.Othello.model.Position;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import g52167.Othello.controller.ControllerPutPiece;
import g52167.Othello.controller.ControllerPossible;
import static g52167.Othello.model.PlayerColor.*;
import java.util.Random;
import javafx.scene.paint.Color;

/**
 * This class build the board with squares
 *
 * @author Laurent
 */
public class BoardView extends GridPane {

    private SquareView[][] squareView;

    /**
     * Constructor of Board
     */
    public BoardView() {

        /*--------------------Style--------------------*/
        this.setAlignment(Pos.CENTER);
        this.setMinSize(500, 500);
        this.setMaxSize(500, 500);

    }

    /**
     * getter of SquareView
     *
     * @return the squareView
     */
    public SquareView[][] getSquareView() {
        return squareView;
    }

    /**
     * This will build correctly the board and put the pieces at the begining
     * and after a certain update
     *
     * @param game the actual game
     */
    public void update(Game game) {
        Random random = new Random();
        int a = random.nextInt(8);
        int b = random.nextInt(8);
        int c = random.nextInt(8);
        int d = random.nextInt(8);
        int e = random.nextInt(8);
        int f = random.nextInt(8);

        /*--------------------remplis le gridPane de StackPane(squareView) et gere le survol de la souris--------------------*/
        if (squareView == null) {
            this.squareView = new SquareView[game.getBoard().length][game.getBoard()[0].length];

            for (int i = 0; i < game.getBoard().length; i++) {
                for (int j = 0; j < game.getBoard()[0].length; j++) {

                    this.squareView[i][j] = new SquareView();

                    this.add(squareView[i][j], j, i);

                    this.squareView[i][j].setOnMouseClicked(new ControllerPutPiece(game, new Position(i, j)));
                    this.squareView[i][j].setOnMouseEntered(new ControllerPossible(game, new Position(i, j), this.squareView[i][j]));
                    this.squareView[i][j].setOnMouseExited(new ControllerExit(this.squareView[i][j]));

                    if (game.isOver()) {
                        if (game.getBoard()[a][b].getPiece().getColor() == BLACK) {
                            game.countPoints(BLACK);
                        }
                    }
                }

            }

        }
        

        /*--------------------Place les Pieces de départ--------------------*/
        for (int i = 0; i < game.getBoard().length; i++) {
            for (int j = 0; j < game.getBoard()[0].length; j++) {
                if (game.getBoard()[i][j].getPiece() != null) {
                    if (game.getBoard()[i][j].getPiece().getColor() == BLACK) {
                        this.squareView[i][j].addCircle(Color.BLACK);
                    } else if (game.getBoard()[i][j].getPiece().getColor() == WHITE) {
                        this.squareView[i][j].addCircle(Color.WHITE);
                    }
                    
                }
                if (a != c || a != e || e != c || b != d || b != f || d != f) {
                        this.squareView[a][b].setStyle("-fx-background-color: blue");
                        this.squareView[c][d].setStyle("-fx-background-color: blue");
                        this.squareView[e][f].setStyle("-fx-background-color: blue");

                    } else {
                        a = random.nextInt(8);
                        b = random.nextInt(8);
                        c = random.nextInt(8);
                        d = random.nextInt(8);
                        e = random.nextInt(8);
                        f = random.nextInt(8);

                    }

            }
        }
    }

}
