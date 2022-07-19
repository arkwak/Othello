/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.Othello.view;

import g52167.Othello.model.Game;
import g52167.Othello.model.PlayerColor;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Laurent
 */
public class InfoNoir extends GridPane implements g52167.Othello.model.Observer{
    
    
private Label nom;
private Label score;
private Label nbJetons;
private Label nomSave;
private Label scorePoint;
private Label jetonSave;
private Game game;

    public InfoNoir(Game game) {
        
        
        game.registerObservers(this);
        this.game = game;
        this.nom= new Label("nom");
        this.score= new Label("score");
        this.nbJetons= new Label("nbJetons");
        this.nomSave= new Label(game.getCurrent().getName());
        this.scorePoint= new Label("-");
        this.jetonSave= new Label("2");
        this.add(nom, 0, 0);
        this.add(score, 1, 0);
        this.add(nbJetons, 2, 0);
        this.add(nomSave, 0, 1);
        this.add(scorePoint, 1, 1);
        this.add(jetonSave, 2, 1);
        
        this.nom.setFont(Font.font("System", FontWeight.BOLD, 20));
        this.score.setFont(Font.font("System", FontWeight.BOLD, 20));
        this.nbJetons.setFont(Font.font("System", FontWeight.BOLD, 20));

        this.setPadding(new Insets(10));
        this.setHgap(30);
        this.setVgap(30);
        this.setBackground(new Background(new BackgroundFill(Color.DIMGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMinSize(200, 200);
    }

    public Label getNomSave() {
        return nomSave;
    }

    public Label getNom() {
        return nom;
    }

    public Label getScore() {
        return score;
    }

    public Label getNbJetons() {
        return nbJetons;
    }

    public Label getScorePoint() {
        return scorePoint;
    }

    public Label getJetonSave() {
        return jetonSave;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public void update() {
        if(game.getCurrent().getColor() == PlayerColor.BLACK){
            nomSave.setText(game.getCurrent().getName());
        }
        
    }

    public void setNomSave(Label nomSave) {
        this.nomSave = nomSave;
    }

    public void setScorePoint(Label scorePoint) {
        this.scorePoint = scorePoint;
    }

    public void setJetonSave(Label jetonSave) {
        this.jetonSave = jetonSave;
    }




}
