/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.Othello.controller;

import g52167.Othello.model.Game;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Laurent
 */
public class ControllerPass implements EventHandler{
    
    private Game game;
    
    public ControllerPass(Game game){
        this.game = game;
    }

    @Override
    public void handle(Event t) {
       game.skip();
    }
}
