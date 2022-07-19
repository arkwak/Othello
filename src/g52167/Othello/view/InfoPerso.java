package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.model.Game;
import g52167.Othello.model.PlayerColor;
import javafx.scene.layout.HBox;

/**
 * This class represent the view of the 2 players
 *
 * @author Laurent
 */
public class InfoPerso extends HBox {

    private BlackPlayer blackPlayer;
    private WhitePlayer whitePlayer;

    /**
     * Constructor of InfoPerso
     *
     * @param game the actual game
     */
    public InfoPerso(Game game) {

        /*--------------------Initialisation et ajout aux enfants--------------------*/
        this.blackPlayer = new BlackPlayer(game);
        this.whitePlayer = new WhitePlayer(game);
        this.getChildren().addAll(blackPlayer, whitePlayer);

    }

    /**
     * getter of BlackPlayer
     *
     * @return BlackPlayer
     */
    public BlackPlayer getBlackPlayer() {
        return blackPlayer;
    }

    /**
     * getter of WhitePlayer
     *
     * @return WhitePlayer
     */
    public WhitePlayer getWhitePlayer() {
        return whitePlayer;
    }

    /**
     * Update the Score of the Players
     *
     * @param game the actual game
     */
    public void update(Game game) {
        String ptb = Integer.toString(game.countPoints(PlayerColor.BLACK));
        blackPlayer.getScorePoint().setText(ptb);

        String ptw = Integer.toString(game.countPoints(PlayerColor.WHITE));
        whitePlayer.getScorePoint().setText(ptw);
    }
}
