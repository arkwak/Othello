package g52167.Othello.view;


/*--------------------imports utiles--------------------*/
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * This classshow the introduction
 *
 * @author Laurent
 */
public class IntroInfo extends HBox {

    private Label blackPlayer;
    private Label whitePlayer;
    private TextField p1;
    private TextField p2;

    /**
     * Constructor of introInfo
     */
    public IntroInfo() {
        /*--------------------crée 2 emplacements ou les joueurs rentrerons leur nom--------------------*/

        this.blackPlayer = new Label("Joueur Noir, entrez votre Nom");
        this.p1 = new TextField();
        this.whitePlayer = new Label("Joueur Blanc, entrez votre Nom");
        this.p2 = new TextField();
        this.p2.setPromptText("Votre Nom...");
        this.p1.setPromptText("Votre Nom...");

        /*--------------------Style--------------------*/
        this.getChildren().addAll(blackPlayer, p1, whitePlayer, p2);
        this.setMinSize(1000, 500);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * getter of p1
     *
     * @return p1
     */
    public TextField getP1() {
        return p1;
    }

    /**
     * getter of p2
     *
     * @return p2
     */
    public TextField getP2() {
        return p2;
    }

}
