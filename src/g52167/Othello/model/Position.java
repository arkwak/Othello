package g52167.Othello.model;

/**
 *
 * @author Laurent
 */
public class Position {

    private int row;
    private int column;

    /**
     * Constructor for the class Position.java
     *
     * @param row a row
     * @param column a column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter of Row
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * getter of Column
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * give ne next position in the direction we want
     *
     * @param direction the direction we want
     * @return the next position
     */
    public Position nextPosition(Direction direction) {
        return new Position(row + direction.getRow(), column + direction.getColumn());
    }

    @Override
    public String toString() {
        return "(" + row + ";" + column + ")";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.row;
        hash = 83 * hash + this.column;
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
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

}
