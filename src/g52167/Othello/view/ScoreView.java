package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.model.Game;

import javafx.geometry.Pos;
import javafx.scene.layout.*;

/**
 * This score manage both the historic and the Informations of the 2 Players
 *
 * @author Laurent
 */
public class ScoreView extends VBox {

    private InfoPerso infoPerso;
    private InfoTab infoTab;

    /**
     * Constructor of scoreView
     *
     * @param game the actual game
     */
    public ScoreView(Game game) {
        /*--------------------initialisation et ajout aux enfants--------------------*/

        this.infoPerso = new InfoPerso(game);
        this.infoTab = new InfoTab();
        this.getChildren().addAll(infoPerso, infoTab);

        /*--------------------Style--------------------*/
        this.setAlignment(Pos.TOP_RIGHT);
        this.setMinSize(500, 750);
        this.setMaxSize(1000, 750);

    }

    /**
     * getter of infoPerso
     *
     * @return infoPerso
     */
    public InfoPerso getInfoPerso() {
        return infoPerso;
    }

    /**
     * update the children when Updated
     *
     * @param game the actual game
     */
    public void update(Game game) {
        infoTab.update(game);
        infoPerso.update(game);
    }

}
