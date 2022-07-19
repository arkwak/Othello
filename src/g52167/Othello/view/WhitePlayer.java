package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.model.Game;
import g52167.Othello.model.PlayerColor;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * This class manage the informations of the white player
 *
 * @author Laurent
 */
public class WhitePlayer extends GridPane {

    private Label nom;
    private Label pion;
    private Label score;
    private Circle circle;
    private Label nomSave;
    private Label scorePoint;

    /**
     * Constructor of the WhitePlayer
     *
     * @param game the actual game
     */
    public WhitePlayer(Game game) {
        /*--------------------initialise les attributs--------------------*/

        this.circle = new Circle(10, Color.WHITE);
        this.nom = new Label("nom");
        this.pion = new Label("Pion");
        this.score = new Label("Score");
        this.nomSave = new Label(game.getOpponent().getName());
        this.scorePoint = new Label("2");

        /*--------------------ajout au gridPane--------------------*/
        this.add(this.nom, 0, 0);
        this.add(this.pion, 1, 0);
        this.add(this.score, 2, 0);
        this.add(this.circle, 1, 1);
        this.add(this.nomSave, 0, 1);
        this.add(this.scorePoint, 2, 1);

        /*--------------------Style--------------------*/
        this.nom.setFont(Font.font("System", FontWeight.BOLD, 20));
        this.score.setFont(Font.font("System", FontWeight.BOLD, 20));
        this.pion.setFont(Font.font("System", FontWeight.BOLD, 20));
        this.setPadding(new Insets(10));
        this.setHgap(30);
        this.setVgap(30);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMinSize(245, 100);
    }

    /**
     * setter of nomSave
     *
     * @param nomSavethe new nomSave
     */
    public void setNomSave(String nomSave) {
        this.nomSave.setText(nomSave);
    }

    /**
     * when updated reset the name of the player (only a security)
     *
     * @param game the actual game
     */
    public void update(Game game) {
        if (game.getCurrent().getColor() == PlayerColor.WHITE) {
            nomSave.setText(game.getOpponent().getName());

        }
    }

    /**
     * getter of nomsave
     *
     * @return nomsave
     */
    public Label getNomSave() {
        return nomSave;
    }

    /**
     * getter of nom
     *
     * @return nom
     */
    public Label getNom() {
        return nom;
    }

    /**
     * getter of pion
     *
     * @return pion
     */
    public Label getPion() {
        return pion;
    }

    /**
     * getter of score
     *
     * @return score
     */
    public Label getScore() {
        return score;
    }

    /**
     * getter of circle
     *
     * @return circle
     */
    public Circle getCircle() {
        return circle;
    }

    /**
     * getter of scorePiont
     *
     * @return scorePoint
     */
    public Label getScorePoint() {
        return scorePoint;
    }

    /**
     * setter of scorePoint
     *
     * @param scorePoint the new ScorePoint
     */
    public void setScorePoint(Label scorePoint) {
        this.scorePoint = scorePoint;
    }

}
