
package g52167.Othello.controller;

import g52167.Othello.model.Game;
import g52167.Othello.model.PlayerColor;
import g52167.Othello.model.Position;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;



/**
 *
 * @author Laurent
 */
public class ControllerPutPiece implements EventHandler<MouseEvent>{
   

     private final Game game;
    private final Position position;

    public ControllerPutPiece(Game game, Position position) {
        this.game = game;
        this.position = position;
    }

    @Override
    public void handle(MouseEvent event) {
try{
        if (game.getCurrent().getColor() == PlayerColor.BLACK && game.getBoard()[position.getRow()][position.getColumn()].isFree()) {
            game.move(position);
            
            
        } else if (game.getCurrent().getColor() == PlayerColor.WHITE && game.getBoard()[position.getRow()][position.getColumn()].isFree()) {
            game.move(position);
        }
        
}
catch(Exception e){
    
    System.out.println("mauvais move");
}

    }

    
}
