/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.Othello.view;

import g52167.Othello.model.Game;
import g52167.Othello.model.PlayerColor;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Laurent
 */
public class NewWindow extends VBox implements g52167.Othello.model.Observer {

    private InfoNoir infoNoir;
    private InfoBlanc infoBlanc;
    private Game game;
    private Label jb;
    private Label jn;

    public NewWindow(Game game) {
        this.game = game;
        game.registerObservers(this);

        this.jb = new Label("Joueur Blanc : ");
        this.infoBlanc = new InfoBlanc(game);
        this.jn = new Label("Joueur Noir : ");
        this.infoNoir = new InfoNoir(game);
        this.getChildren().addAll(jb, infoBlanc, jn, infoNoir);

    }

    @Override
    public void update() {
        String ptb = Integer.toString(game.countPoints(PlayerColor.BLACK));
        infoNoir.getJetonSave().setText(ptb);
        
        String ptw = Integer.toString(game.countPoints(PlayerColor.WHITE));
        infoBlanc.getJetonSave().setText(ptw);
        
        
        System.out.println("aaaa");
    }

}
