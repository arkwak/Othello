package g52167.Othello.model;

import java.util.Objects;

/**
 *
 * @author Laurent
 */
public class Piece {

    private PlayerColor color;

    /**
     * Constructor for the class Piece.java
     *
     * @param color color of the piece
     */
    public Piece(PlayerColor color) {
        this.color = color;
    }

    /**
     * Flip the pieces
     */
    public void flip() {
        if (color.equals(PlayerColor.BLACK)) {
            color = PlayerColor.WHITE;
        } else {
            color = PlayerColor.BLACK;
        }
    }

    /**
     * Getter of Color
     *
     * @return the color of the piece
     */
    public PlayerColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + " piece";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.color);
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
        final Piece other = (Piece) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

}
