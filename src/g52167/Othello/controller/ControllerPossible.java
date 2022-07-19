package g52167.Othello.controller;

import g52167.Othello.model.Game;
import g52167.Othello.model.Position;
import g52167.Othello.view.SquareView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author Laurent
 */
public class ControllerPossible implements EventHandler<MouseEvent> {

    private Game game;
    private final Position position;
    private final SquareView sv;

    public ControllerPossible(Game game, Position position, SquareView sv) {
        this.game = game;
        this.position = position;
        this.sv = sv;
    }

    @Override
    public void handle(MouseEvent t) {

        if (!game.checkPosition(this.position, game.getCurrent()).isEmpty()) {

            sv.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        } else {
            sv.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        }

    }
}
