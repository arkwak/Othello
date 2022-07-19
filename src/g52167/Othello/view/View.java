package g52167.Othello.view;

import java.util.Scanner;
import g52167.Othello.model.*;
import java.util.List;

/**
 *
 * @author Laurent
 */
public class View {

    Scanner in;

    /**
     * initialisation of the Scanner
     *
     * @param in what the player write
     */
    public View(Scanner in) {
        this.in = in;
    }

    /**
     * say hello to the player
     */
    public void initialize() {
        System.out.println("Bienvenue au Othello\n");
    }

    /**
     * say goodbye to the player
     */
    public void quit() {
        System.out.println("Bye Bye");
    }

    /**
     * print a message of error
     *
     * @param message message of error
     */
    public void displayError(String message) {
        System.out.println(message);
    }

    /**
     * display wich command the player can use
     */
    public void displayHelp() {
        System.out.println("Usage:\n");
        System.out.println("tapez \u001B[1m help \u001B[0m pour afficher les commandes");
        System.out.println("tapez \u001B[1m show \u001B[0m pour afficher le plateau de jeu");
        System.out.println("tapez \u001B[1m score \u001B[0m pour afficher le score actuel");
        System.out.println("tapez \u001B[1m apply ligne colonne \u001B[0m pour placer le pion sur l'endroit désigné");
        System.out.println("tapez \u001B[1m quit\u001B[0m  pour arreter le programme\n");

    }

    /**
     * ask a comand to the player
     *
     * @return the command he wrote
     */
    public String askCommand() {
        System.out.println("Entrez votre commande");
        String command = in.nextLine();
        return command;
    }

    /**
     *
     * @param squares
     */
    public void displayBoard(Square[][] squares) {
        //sepa
        for (int i = 0; i < 49; i++) {
            System.out.print("=");
        }
        System.out.println("");

        //head
        System.out.print(" col# ||  ");
        for (int i = 0; i < squares[0].length; i++) {
            System.out.print(" | " + "0" + i + " | ");
        }
        System.out.println("");

        //sepa
        for (int i = 0; i < 49; i++) {
            System.out.print("=");
        }
        System.out.println("");

        //body
        for (int i = 0; i < squares.length; i++) {
            System.out.print("row#" + i + " ||  ");
            for (Square square : squares[i]) {
                if (square.isFree()) {
                    System.out.print(" | " + "\u001B[47m" + "  " + "\u001B[0m" + " | ");
                } else if (square.getPiece().getColor() == PlayerColor.WHITE) {
                    System.out.print(" | " + "\u001B[47m" + "\u001B[31m" + "W " + "\u001B[0m" + " | ");

                } else {

                    System.out.print(" | " + "\u001B[47m" + "\u001B[34m" + "B " + "\u001B[0m" + " | ");

                }
            }
            System.out.println("");
        }
    }

    /**
     * show the current player
     *
     * @param player the current player
     */
    public void displayCurrentPlayer(Player player) {
        if (player.getColor() == PlayerColor.WHITE) {
            System.out.println("c'est a votre tour joueur Blanc ");
        }

        if (player.getColor() == PlayerColor.BLACK) {
            System.out.println("c'est a votre tour joueur Noir ");

        }
    }

    /**
     * tell to the player that the game ended
     *
     * @param winner the winner
     */
    public void displayIsOver(List<Player> winner) {
        if (winner.isEmpty()) {
            System.out.println("le jeu est terminé");
        } else if (winner.size() == 1) {
            System.out.println("le joueur " + winner.get(0).getColor() + " a gagné la partie");
        } else {
            System.out.println("égalité");
        }
    }

    /**
     *
     * @param winners
     * @param blackDiscs
     * @param whiteDiscs
     * @param boardRow
     * @param boardColumn
     */
    public void displayOver(List<Player> winners, int blackDiscs, int whiteDiscs, int boardRow, int boardColumn) {
        System.out.println("Félicitation");

        int finalScore;
        if (winners.size() == 2) {
            finalScore = blackDiscs;
            System.out.println("au joueur Noir et au joueur blanc! Leur score est de  : " + finalScore + "\n");
        } else {
            for (Player winner : winners) {
                if (winner.getColor() == PlayerColor.BLACK) {
                    finalScore = blackDiscs + ((boardRow * boardColumn) - blackDiscs - whiteDiscs);
                    System.out.println("au joueur Noir! Son score est de  : " + finalScore + "\n");
                } else if (winner.getColor() == PlayerColor.WHITE) {
                    finalScore = whiteDiscs + ((boardRow * boardColumn) - whiteDiscs - blackDiscs);
                    System.out.println("au joueur Blanc dont core est de  : " + finalScore + "\n");
                }
            }
        }

    }

    /**
     *
     * @param game
     */
    public void displayScore(Model game) {
        System.out.println("le score est de  : ");
        System.out.println("Pieces noires : " + game.countPoints(PlayerColor.BLACK));
        System.out.println("Pieces blanches : " + game.countPoints(PlayerColor.WHITE));
        System.out.println("\n");
    }

}
