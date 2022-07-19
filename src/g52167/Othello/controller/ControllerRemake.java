/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.Othello.controller;

import g52167.Othello.model.Game;
import static g52167.Othello.model.PlayerColor.WHITE;
import g52167.Othello.view.FxView;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Laurent
 */
public class ControllerRemake implements EventHandler {

    private Game game;
    private FxView fxView;

    public ControllerRemake(Game game, FxView fx) {
        this.game = game;
        this.fxView = fx;
    }

    @Override
    public void handle(Event event) {
        game.initialize();

        if (game.getCurrent().getColor() == WHITE) {
            game.swapPlayers();
        }
        fxView.initialiser(game);

    }
}
