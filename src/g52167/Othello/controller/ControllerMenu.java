/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.Othello.controller;

import g52167.Othello.model.Game;
import g52167.Othello.view.BlackPlayer;
import g52167.Othello.view.FxView;
import g52167.Othello.view.InfoPerso;
import g52167.Othello.view.IntroView;
import g52167.Othello.view.ScoreView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Laurent
 */
public class ControllerMenu implements EventHandler<ActionEvent> {

    private IntroView introView;
    private Stage stage;
    private Scene scene;
    private Game game;
    

    public ControllerMenu(IntroView intro, Stage stage, Scene scene, Game game) {
        this.introView = intro;
        this.stage = stage;
        this.scene = scene;
        this.game = game;

    }

    @Override
    public void handle(ActionEvent event) {
        String p1 = introView.getIntroInfo().getP1().getText();
        String p2 = introView.getIntroInfo().getP2().getText();
        if (!p1.isEmpty() && !p2.isEmpty()) {

            introView.getFxView().getScoreView().getInfoPerso().getBlackPlayer().setNomSave(p1);
            introView.getFxView().getScoreView().getInfoPerso().getWhitePlayer().setNomSave(p2);
                    
            
            
            game.getCurrent().setName(p1);
            game.getOpponent().setName(p2);
            
            

            stage.setScene(scene);

        }

    }

}
