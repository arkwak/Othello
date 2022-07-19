/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.Othello.model;

/**
 *
 * @author Laurent
 */
public class Move {
    private Position position;
    private String nomPlayer;
    private String action;
    private int qteDisc;

    public Move(Position position, String nomPlayer, String action, int qteDisc) {
        this.position = position;
        this.nomPlayer = nomPlayer;
        this.action = action;
        this.qteDisc = qteDisc;
        
    }

    
    
    
    
    
    
    
    public Position getPosition() {
        return position;
    }

    public String getNomPlayer() {
        return nomPlayer;
    }

    public String getAction() {
        return action;
    }

    public int getQteDisc() {
        return qteDisc;
    }
    
    
    
}
