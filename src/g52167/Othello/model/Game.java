package g52167.Othello.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is an assembly of all the mechanics, it is a facade pattern
 *
 * @author Laurent
 */
public class Game implements Model, Observable {

    private Board board;
    private Player current;
    private Player opponent;
    private Position position;
    private final List<Observer> observers;
    private List<Move> move;

    /**
     * constructor og Game
     *
     * @param current the current player
     * @param opponent the opponent player
     */
    public Game(Player current, Player opponent) {
        this.current = current;
        this.opponent = opponent;
        board = new Board();
        observers = new ArrayList<>();

    }

    /**
     * the main sconstructor of game. The player Black plays first
     */
    public Game() {
        this.current = new Player(PlayerColor.BLACK, "-", "Roger");
        this.opponent = new Player(PlayerColor.WHITE, "Roger", "Bernard");
        board = new Board();
        observers = new ArrayList<>();

    }
//reset la liste des moves

    @Override
    public void initialize() {
        board = new Board();
        this.move = new ArrayList<>();

        board.put(new Piece(PlayerColor.WHITE), new Position(4, 4));
        board.put(new Piece(PlayerColor.WHITE), new Position(3, 3));
        board.put(new Piece(PlayerColor.BLACK), new Position(3, 4));
        board.put(new Piece(PlayerColor.BLACK), new Position(4, 3));

        move.add(new Move(null, "-", "Début de la partie", 0));
    }

    @Override
    public void start() {
        if (isOver() || board == null) {
            throw new IllegalStateException("the game is over or the board doesn't exist");
        }
    }

    @Override
    public boolean isOver() {
        return board.isFull() || (!hasMoves(current) && !hasMoves(opponent));
    }

    @Override
    public Square[][] getBoard() {
        return board.getSquares();
    }

    //  public Board getRealBoard()
    /**
     * send a message when the player quit the game
     */
    public void quit() {
        System.out.println("Bye Bye");
    }

    @Override
    public Player getCurrent() {
        return current;
    }

    @Override
    public List<Player> getWinner() {
        if (!isOver()) {
            throw new IllegalArgumentException("the game is over");

        }
        int nbPieceCurrent = countPoints(current.getColor());
        int nbPieceOpponent = countPoints(opponent.getColor());

        List<Player> winner = new ArrayList<>();
        if (nbPieceCurrent > nbPieceOpponent) {
            winner.add(current);
        } else if (nbPieceOpponent > nbPieceCurrent) {
            winner.add(opponent);
        } else {
            winner.add(current);
            winner.add(opponent);
        }
        return winner;

    }

    /**
     * Check if the player can make a movement
     *
     * @param player the current player.
     * @return true if the player can make a move, false if he can't
     */
    boolean hasMoves(Player player) {
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[i].length; j++) {
                Position DiscPosition = new Position(i, j);
                if (!checkPosition(DiscPosition, player).isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check if the piece can be placed
     *
     * @param position the position
     * @param player the player
     * @return all the piece that can be flip
     */
    public List<Position> checkPosition(Position position, Player player) {
        List<Position> pieces = new ArrayList<>();
        List<Position> temp = new ArrayList<>();

        if (board.isInside(position) && board.isFree(position)) {
            for (Direction direction : Direction.values()) {
                Position nextPos = position.nextPosition(direction);
                if (board.isInside(nextPos)) {
                    Square square = board.getSquare(nextPos);
                    while (board.isInside(nextPos) && !board.isFree(nextPos) && !square.hasColor(player.getColor())) {
                        temp.add(nextPos);
                        nextPos = nextPos.nextPosition(direction);
                        if (board.isInside(nextPos)) {
                            square = board.getSquare(nextPos);
                        }
                    }
                    if (board.isInside(nextPos) && square.hasColor(player.getColor())) {
                        pieces.addAll(temp);
                    }
                }
                temp.clear();
            }
        }
        return pieces;
    }

    @Override
    public int countPoints(PlayerColor color) {
        int cpt = 0;
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[i].length; j++) {
                if (board.hasColor(new Position(i, j), color)) {
                    cpt++;
                }
            }
        }
        return cpt;
    }

    @Override
    public void move(Position position) {
        if (!board.isInside(position)) {
            throw new IllegalArgumentException("this position is not on the board");
        }

        if (!board.isFree(position)) {
            throw new IllegalArgumentException("there is already a piece in this position");
        }

        List<Position> flip = checkPosition(position, current);
        if (!flip.isEmpty()) {
            board.put(new Piece(current.getColor()), position);
            for (Position pos : flip) {
                board.flip(pos);
            }
            this.move.add(new Move(position, current.getName(), "a posé une piece", flip.size()));
            swapPlayers();
            notifyObservers();
        } else {
            throw new IllegalArgumentException("you can't do this, try again");
        }
    }

    /**
     * swap the player when his turn is ended
     */
    public void swapPlayers() {
        if (!isOver() && hasMoves(opponent)) {
            Player swap = current;
            current = opponent;
            opponent = swap;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.board);
        hash = 67 * hash + Objects.hashCode(this.current);
        hash = 67 * hash + Objects.hashCode(this.opponent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.board, other.board)) {
            return false;
        }
        if (!Objects.equals(this.current, other.current)) {
            return false;
        }
        if (!Objects.equals(this.opponent, other.opponent)) {
            return false;
        }
        return true;
    }

    @Override
    public void registerObservers(Observer obs) {
        if (!observers.contains(obs)) {
            observers.add(obs);
        }
    }

    @Override
    public void removeObserver(Observer obs) {
        if (observers.contains(obs)) {
            observers.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }

    public int countSquare() {

        return board.getColumnmax() * board.getRowmax();

    }

    public void skip() {
        if (current.getColor() == PlayerColor.BLACK) {

            this.move.add(new Move(null, current.getName(), "a passé son tour", 0));
        }
        if (current.getColor() == PlayerColor.WHITE) {
            this.move.add(new Move(null, current.getName(), "a passé son tour", 0));

        }
        swapPlayers();
        notifyObservers();
    }

    public List<Move> getMove() {
        return move;
    }

    public Player getOpponent() {
        return opponent;
    }

}
