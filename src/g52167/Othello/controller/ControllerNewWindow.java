/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.Othello.controller;

import g52167.Othello.model.Game;
import g52167.Othello.view.NewWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Laurent
 */
public class ControllerNewWindow implements EventHandler<ActionEvent>{
    private Game game;

    public ControllerNewWindow(Game game) {
        this.game=game;
    }
    
    
    
    @Override
    public void handle(ActionEvent t) {

        NewWindow root = new NewWindow(game);
        
        Stage stage = new Stage();
        stage.setTitle("Score");
        stage.setScene(new Scene(root,1000,1000));
        stage.show();
        
        
        

    }
    
    
}
