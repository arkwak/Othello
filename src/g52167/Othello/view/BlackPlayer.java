package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.model.Game;
import g52167.Othello.model.PlayerColor;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



/**
 * This class represents all the informations of the blackPlayer
 *
 * @author Laurent
 */
public class BlackPlayer extends GridPane {

    private final Label nom;
    private final Label pion;
    private final Label score;
    private final Circle circle;
    private final Label nomSave;
    private Game game;
    private Label scorePoint;

    /**
     * the consructor of the BlackPlayer using his name, his score and the look
     * of his piece
     *
     * @param game the actual game
     */
    public BlackPlayer(Game game) {

        /*--------------------Construction des attributs--------------------*/
        this.circle = new Circle(10, Color.BLACK);
        this.nom = new Label("nom ");
        this.pion = new Label("Pion");
        this.score = new Label("Score");
        this.nomSave = new Label(game.getCurrent().getName());
        this.scorePoint = new Label("2");

        /*-------------------- ajout aux bonnes cases du grid---------------*/
        this.add(this.nom, 0, 0);
        this.add(this.pion, 1, 0);
        this.add(this.score, 2, 0);
        this.add(this.circle, 1, 1);
        this.add(this.nomSave, 0, 1);
        this.add(this.scorePoint, 2, 1);
        
        
        
        /*-------------------------Style------------------------------------*/
        this.nom.setFont(Font.font("System", FontWeight.BOLD, 20));
        this.score.setFont(Font.font("System", FontWeight.BOLD, 20));
        this.pion.setFont(Font.font("System", FontWeight.BOLD, 20));

        this.setPadding(new Insets(10));
        this.setHgap(30);
        this.setVgap(30);
        this.setBackground(new Background(new BackgroundFill(Color.DIMGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMinSize(245, 100);

    }

    
    
    /**
     *Setter of NomSave,
     * @param nomSave the new nomSave
         */
    public void setNomSave(String nomSave) {
        this.nomSave.setText(nomSave);
    }

    /**
     *Getter of NomSave
     * @return nomSave
     */
    public Label getNomSave() {
        return nomSave;
    }

    /**
     *when a update of the game is done,reset the nomSave (only a security )
     * @param game the actual game
     */
    public void update(Game game) {
        if (game.getCurrent().getColor() == PlayerColor.BLACK) {
            nomSave.setText(game.getCurrent().getName());

        }
    }

    /**
     *Getter of nom
     * @return the nom
     */
    public Label getNom() {
        return nom;
    }

    /**
     *getter of pion
     * @return the pion
     */
    public Label getPion() {
        return pion;
    }

    /**
     *getter of score
     * @return the score
     */
    public Label getScore() {
        return score;
    }

    /**
     *getter of circle
     * @return the circle
     */
    public Circle getCircle() {
        return circle;
    }

    /**
     *getter of game
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     *getter of scorePoint  
     * @return the scorePoint
     */
    public Label getScorePoint() {
        return scorePoint;
    }

    /**
     *setter of scorepoint
     * @param scorePoint the new scorePoint
     */
    public void setScorePoint(Label scorePoint) {
        this.scorePoint = scorePoint;
    }

}
