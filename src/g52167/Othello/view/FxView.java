package g52167.Othello.view;


/*--------------------imports utiles--------------------*/
import g52167.Othello.controller.ControllerRemake;
import g52167.Othello.model.Game;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;

/**
 * This class is the global view (causes issue between observer frome java and
 * observer of javafx if an other implements is used)
 *
 * @author Laurent
 */
public class FxView extends HBox implements g52167.Othello.model.Observer {

    GameView gameView;
    ScoreView scoreView;
    Game game;
    

    

    
    
    
    
    
    /**
     * getter of gameView
     *
     * @return gameView
     */
    public GameView getGameView() {
        return gameView;
    }

    /**
     * Getter of ScoreView
     *
     * @return scoreView
     */
    public ScoreView getScoreView() {
        return scoreView;
    }

    /**
     * When a update is done, update the childrens and permit to use button
     */
    @Override
    public void update() {

        /*--------------------gere le bouton recommencer--------------------*/
        gameView.getUnderBoard().getButtonView().getRecommencer().setOnAction(new ControllerRemake(game, this));

        /*------------------------update les enfants------------------------*/
        gameView.update(game);
        scoreView.update(game);

    }

    /**
     * initialise the game
     *
     * @param game the actual game
     */
    public void initialiser(Game game) {

        
        /*--------------------réinitialise les enfants(utile lorsque le jeu redémarre)--------------------*/
        this.getChildren().clear();

        /*--------------------initialisation et ajout aux enfants des attributs+ sécurité------------------*/
        if (game == null) {
            throw new IllegalArgumentException("game est null");
        }
        this.game = game;
        game.registerObservers(this);

        this.gameView = new GameView();
        this.scoreView = new ScoreView(game);
        this.getChildren().add(this.gameView);
        this.getChildren().add(this.scoreView);
        /*--------------------Style--------------------*/
        this.setMinSize(1000, 750);
        this.setMaxSize(1000, 750);
        
        

        update();
    }

    /**
     * Setter of Game
     *
     * @param game the game
     */
    public void setGame(Game game) {
        this.game = game;
    }

}
