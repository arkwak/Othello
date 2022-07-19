package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.controller.ControllerMenu;
import g52167.Othello.model.Game;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class will manage the inofrmations of the introdution
 *
 * @author Laurent
 */
public class IntroView extends VBox {

    private IntroInfo introInfo;
    private Button valid;
    private Game game;
    private FxView fxView;

    /**
     * Constructor the introview
     *
     * @param secondaryStage the secondary Stage
     * @param scene the scene
     * @param game the actoal game
     * @param fxView the fxView
     */
    public IntroView(Stage secondaryStage, Scene scene, Game game, FxView fxView) {

        /*--------------------initialisation--------------------*/
        this.introInfo = new IntroInfo();
        this.valid = new Button("Valider");
        this.game = game;
        this.fxView = fxView;

        /*--------------------bouton de changement de scene (Intro --> Jeu )--------------------*/
        this.addEventHandler(ActionEvent.ACTION, new ControllerMenu(this, secondaryStage, scene, game));

        /*--------------------ajout aux enfants--------------------*/
        this.getChildren().addAll(introInfo, valid);

        /*--------------------Style--------------------*/
        this.setMinSize(1000, 250);
        this.setAlignment(Pos.CENTER);

    }

    ;

   

    /**
     *getter of introView
     * @return introView
     */
    public IntroInfo getIntroInfo() {
        return introInfo;
    }

    /**
     * getter of valid
     *
     * @return valid
     */
    public Button getValid() {
        return valid;
    }

    /**
     * getter of game
     *
     * @return game
     */
    public Game getGame() {
        return game;
    }

    /**
     * getter of fxView
     *
     * @return FxView
     */
    public FxView getFxView() {
        return fxView;
    }

}
