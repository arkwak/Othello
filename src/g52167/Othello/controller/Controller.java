/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52167.Othello.controller;

import g52167.Othello.model.*;
import g52167.Othello.view.*;
import java.util.List;

/**
 *
 * @author Laurent
 */
public class Controller {

    private Model game;
    private View view;

    /**
     * constructor for the class Controller.java
     *
     * @param game the game class
     * @param view the view class
     */
    public Controller(Model game, View view) {
        if (game == null || view == null) {
            throw new IllegalArgumentException("");
        }

        this.game = game;
        this.view = view;
    }

    /**
     * initialize the game and the view
     */
    public void initialize() {
        game.initialize();
        view.initialize();

    }

    /**
     * start the game
     */
    public void startGame() {
        game.start();
        view.displayHelp();

        boolean isOver = game.isOver();

        while (!isOver) {
            boolean goodCommand = false;
            view.displayBoard(game.getBoard());
            view.displayCurrentPlayer(game.getCurrent());

            String answer = view.askCommand();
            String[] command = answer.split(" ");

            if (command[0].equals("quit")) {
                view.quit();
                break;
            }

            if (command[0].equals("help")) {
                goodCommand = true;
                view.displayHelp();
            }
            if (command[0].equals("show")) {
                goodCommand = true;
                view.displayCurrentPlayer(game.getCurrent());
                view.displayBoard(game.getBoard());
            }
            if (command[0].equals("score")) {
                goodCommand = true;
                score();
            }

            if (command.length == 3 || command[0].equals("apply") && command[1].matches("-?\\d+") && command[2].matches("-?\\d+")) {
                goodCommand = true;
                try {
                    apply(command);
                    
                    isOver = game.isOver();
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }

            }

            if (isOver) {
                view.displayBoard(game.getBoard());
                List<Player> winner = game.getWinner();
                view.displayIsOver(winner);
            }

            if (goodCommand == false) {
                System.out.println("vous n'avez pas entré la bonne commande");
            }

        }

    }

    private void score() {
        try {
            view.displayScore(game);
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }
     private void apply(String[] answerArguments) {
         try{
        int row = Integer.parseInt(answerArguments[1]);
        int column = Integer.parseInt(answerArguments[2]);
        game.move(new Position(row, column));
         }
         catch(Exception e){
              System.out.println(e.getMessage());
         }
    }
}
