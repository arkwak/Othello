/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.Othello.controller;

import g52167.Othello.view.SquareView;
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
public class ControllerExit implements EventHandler<MouseEvent> {

    private SquareView squareView;

    public ControllerExit(SquareView squareView) {

        this.squareView = squareView;

    }

    @Override
    public void handle(MouseEvent t) {

              this.squareView.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
