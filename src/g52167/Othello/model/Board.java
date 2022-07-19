package g52167.Othello.model;

import java.util.Arrays;

/**
 * This class represent the board of the Othello
 *
 * @author Laurent
 */
public class Board {

    private final Square[][] squares;
    private  final int rowmax = 8;
    private  final int columnmax = 8;

    /**
     * Constructor of Board
     */
    public Board() {
        squares = new Square[rowmax][columnmax];
        for (Square[] square : squares) {
            for (int j = 0; j < square.length; j++) {
                square[j] = new Square();
            }
        }
    }

    /**
     * Getter of squares.
     *
     * @return the squares.
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * check if the position is inside the board
     *
     * @param position the position we want to check
     * @return true if the position is in the board, false if it is not
     */
    public boolean isInside(Position position) {
        int row = position.getRow();
        int column = position.getColumn();

        if (row < 0 || row >= rowmax) {
            return false;
        }

        if (column < 0 || column >= columnmax) {
            return false;
        }

        return true;
    }

    /**
     * get square at the position we want
     *
     * @param position the position where we want to get the square
     * @return the square at the position
     */
    public Square getSquare(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("This square is not on the board");
        }
        return squares[position.getRow()][position.getColumn()];

    }

    /**
     * put the piece on the position we want
     *
     * @param piece a piece
     * @param position a position
     */
    public void put(Piece piece, Position position) {
        getSquare(position).put(piece);
    }

    /**
     * check if the square is free at the position we want
     *
     * @param position the position we want to check
     * @return True if the square is free, False if it is not
     */
    public boolean isFree(Position position) {
        return getSquare(position).isFree();

    }

    /**
     * get the piece at a position
     *
     * @param position the position we want
     * @return the piece at this position
     */
    public Piece getPiece(Position position) {
        return getSquare(position).getPiece();

    }

    /**
     * Flip the pieces at a position.
     *
     * @param position the position we want.
     */
    public void flip(Position position) {
        getSquare(position).flip();
    }

    /**
     * check if the board is full.
     *
     * @return true if it's full, false if it is not.
     */
    public boolean isFull() {
        for (Square[] square : squares) {
            for (Square square1 : square) {
                if (square1.isFree()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * check if the piece at the position has the good color
     *
     * @param position the position we want
     * @param color the color we want
     * @return true if the piece at this position has the right color, false if
     * it is not
     */
    boolean hasColor(Position position, PlayerColor color) {
        return getSquare(position).hasColor(color);
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
        final Board other = (Board) obj;
        if (!Arrays.deepEquals(this.squares, other.squares)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Arrays.deepHashCode(this.squares);
        return hash;
    }

    public  int getRowmax() {
        return rowmax;
    }

    public  int getColumnmax() {
        return columnmax;
    }
       
    

}
