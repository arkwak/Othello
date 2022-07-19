package g52167.Othello.view;

/*--------------------imports utiles--------------------*/
import g52167.Othello.model.Game;
import g52167.Othello.model.PlayerColor;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 * This class manage the 2 bars and the buttonView
 *
 * @author Laurent
 */
public class UnderBoard extends VBox {

    private ButtonView buttonView;
    private final ProgressIndicator progressInd;
    private final ProgressBar progressBar;
    private final Label labelBar;
    private final Label labelInd;

    /**
     * Constructor of the underboard
     */
    public UnderBoard() {

        /*--------------------initiation et ajout aux enfants--------------------*/
        this.buttonView = new ButtonView();
        this.progressBar = new ProgressBar();
        this.progressInd = new ProgressIndicator();
        this.labelBar = new Label("Noir/Blanc");
        this.labelInd = new Label("Partie complétée a ");
        this.getChildren().addAll(labelBar, progressBar, labelInd, progressInd, buttonView);

        /*--------------------Style--------------------*/
        this.setMinSize(500, 250);
        this.setMaxSize(500, 250);
        this.setPadding(new Insets(50));
        progressBar.setStyle("-fx-accent: black;");

    }

    /**
     * getter of ButtonView
     *
     * @return buttonView
     */
    public ButtonView getButtonView() {
        return buttonView;
    }

    /**
     * getter of LabelBar
     *
     * @return LabelBar
     */
    public Label getLabelBar() {
        return labelBar;
    }

    /**
     * getter of LabelInd
     *
     * @return labelInd
     */
    public Label getLabelInd() {
        return labelInd;
    }

    /**
     * update the children and the 2 bars
     *
     * @param game the actual game
     */
    public void update(Game game) {
        buttonView.update(game);

        int total = game.countPoints(PlayerColor.BLACK) + game.countPoints(PlayerColor.WHITE);
        double score = (double) game.countPoints(PlayerColor.BLACK) / total;

        progressBar.setProgress(score);

        double indication = (double) total / game.countSquare();
        progressInd.setProgress(indication);

    }
}
