/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.othello.Application;
import g52167.Othello.model.Game;
import g52167.Othello.view.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *Main method for the Othello
 * @author Laurent
 */


public class Othello extends Application{
    public static void main(String[] args) {
      
        launch (args);
    }
    @Override
    public void start(Stage primaryStage)throws Exception{
        
        Game game = new Game();
        game.initialize();
        
       MenuBar menuBar = new MenuBar();
       Menu menu1 = new Menu("menu1");
       menuBar.getMenus().add(menu1);
        
        
        
        
       
        
        
        
        
        
        FxView fxView = new FxView();
        fxView.initialiser(game);
        Scene scene = new Scene(fxView,1000,750);
        
        
        
       IntroView intro = new IntroView(primaryStage, scene,game,fxView);
       Scene secondScene = new Scene(intro, 1000, 750);
        
        
        primaryStage.setTitle("Othello");
        primaryStage.setScene(secondScene);
        primaryStage.show();
    
    }
}
 