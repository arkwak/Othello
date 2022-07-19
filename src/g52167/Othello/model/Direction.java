package g52167.Othello.model;

/**
 *
 * @author Laurent
 */
public enum Direction {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1), UPlEFT(-1, -1), DOWNLEFT(1, -1), UPRIGHT(-1, 1), DOWNRIGHT(1, 1);
    ;
     
     private final int row;
    private final int column;

    /**
     * constructor of the enum Direction
     *
     * @param row a row
     * @param column a column
     */
    private Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * getter of row
     *
     * @return row the row
     */
    public int getRow() {
        return row;
    }

    /**
     * getter of column
     *
     * @return column the column
     */
    public int getColumn() {
        return column;
    }

}
