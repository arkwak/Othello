package g52167.Othello.model;

import java.util.Objects;

/**
 *
 * @author Laurent
 */
public class Square {

    private Piece piece;

    /**
     * the constructor of Square
     */
    public Square() {
        piece = null;
    }

    /**
     * the getter of piece
     *
     * @return the piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * it puts a piece on the board
     *
     * @param piece the pece we want to put in
     */
    public void put(Piece piece) {
        if (piece == null) {
            throw new NullPointerException("there is no piece");
        }

        if (this.piece != null) {
            throw new IllegalStateException("there is a piece on this square");
        }
        this.piece = piece;
    }

    /**
     * show if there is a piece on the square
     *
     * @return true if there is a piece on the square, false if it is not
     */
    public boolean isFree() {
        return piece == null;
    }

    /**
     * flip a piece
     */
    public void flip() {
        if (isFree()) {
            throw new IllegalStateException("there is piece");
        } else {
            piece.flip();
        }
    }

    /**
     * check if the piece has the right color
     *
     * @param color the color we want
     * @return true if the piece has the good color, false if it is not
     */
    public boolean hasColor(PlayerColor color) {
        return !isFree() && piece.getColor() == color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.piece);
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
        final Square other = (Square) obj;
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        return true;
    }

}
