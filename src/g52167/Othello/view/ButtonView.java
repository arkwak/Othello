package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.controller.ControllerNewWindow;
import g52167.Othello.controller.ControllerPass;
import g52167.Othello.controller.ControllerRemake;
import g52167.Othello.model.Game;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * this class will build the view of the buttons
 *
 * @author Laurent
 */
public class ButtonView extends HBox {

    private ButtonBase abandonner;
    private ButtonBase passer;
    private ButtonBase recommencer;
    private ButtonBase menu;

    /**
     * Contructor of buttonView
     */
    public ButtonView() {

        /*--------------------crée les boutons avec un titre et les ajoute aux enfants--------------------*/
        this.abandonner = new ButtonBase("abandonner");
        this.passer = new ButtonBase("passer");
        this.recommencer = new ButtonBase("recommencer");
        this.menu = new ButtonBase("Menu");
        this.getChildren().addAll(abandonner, passer, recommencer, menu);


        /*--------------------Style--------------------*/
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);

    }

    /**
     * Permit to use buttons
     *
     * @param game the actual game
     */
    public void update(Game game) {
        passer.setOnAction(new ControllerPass(game));
        // recommencer.setOnAction(new ControllerGiveUp(game));
        menu.setOnAction(new ControllerNewWindow(game));
        

    }

    /**
     * getter of abandonner
     *
     * @return abandonner
     */
    public ButtonBase getAbandonner() {
        return abandonner;
    }

    /**
     * getter of passer
     *
     * @return passer
     */
    public ButtonBase getPasser() {
        return passer;
    }

    /**
     * getter of recommencer
     *
     * @return recommencer
     */
    public ButtonBase getRecommencer() {
        return recommencer;
    }

}
