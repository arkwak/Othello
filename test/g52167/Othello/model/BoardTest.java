package g52167.Othello.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurent
 */
public class BoardTest {

    private final Square[][] defaultBoard = {
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()}};

    public BoardTest() {
    }

    /**
     *
     */
    @Test
    public void testGetSquaresWhenPieceAdded() {
        System.out.println("testGetSquareWhenPieceAdded");
        Board instance = new Board();
        instance.put(new Piece(PlayerColor.BLACK), new Position(1, 1));
        Square[][] expResult = defaultBoard;
        defaultBoard[1][1].put(new Piece(PlayerColor.BLACK));
        Square[][] result = instance.getSquares();
        assertArrayEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testGetSquareWhenSquareIsEmpty() {
        System.out.println("testGetSquareWhenSquareIsEmpty");
        Position position = new Position(0, 1);
        Board instance = new Board();
        Square expResult = new Square();
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSquareWhenPositionOutside() {
        System.out.println("testGetSquareWhenPositionOutside");
        Position position = new Position(-1, 2);
        Board instance = new Board();
        instance.getSquare(position);
    }

    /**
     *
     */
    @Test
    public void testGetSquaresWhenDefaultBoard() {
        System.out.println("testGetSquaresWhenDefaultBoard");
        Board instance = new Board();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getSquares();
        assertArrayEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testGetSquaresWhen2PiecesAdded() {
        System.out.println("testGetSquaresWhen2PiecesAdded");
        Board instance = new Board();
        instance.put(new Piece(PlayerColor.WHITE), new Position(1, 2));
        instance.put(new Piece(PlayerColor.BLACK), new Position(4, 3));
        Square[][] expResult = defaultBoard;
        defaultBoard[1][2].put(new Piece(PlayerColor.WHITE));
        defaultBoard[4][3].put(new Piece(PlayerColor.BLACK));
        Square[][] result = instance.getSquares();
        assertArrayEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testPutOnePiece() {
        System.out.println("testPutOnePiece");
        Piece piece = new Piece(PlayerColor.WHITE);
        Position position = new Position(0, 0);
        Board instance = new Board();
        instance.put(piece, position);
        Square expResult = new Square();
        expResult.put(piece);
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test(expected = NullPointerException.class)
    public void testPutWhenPieceIsNull() {
        System.out.println("testPutWhenPieceIsNull");
        Piece piece = null;
        Position position = new Position(2, 2);
        Board instance = new Board();
        instance.put(piece, position);
    }

    /**
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPuWhenPositionIsOutside() {
        System.out.println("testPuWhenPositionIsOutside");
        Piece piece = new Piece(PlayerColor.WHITE);
        Position position = new Position(26, 2);
        Board instance = new Board();
        instance.put(piece, position);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenCornerUpLeft() {
        System.out.println("testIsInsideWhenCornerUpLeft");
        Position position = new Position(0, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenCornerUpRight() {
        System.out.println("testIsInsideWhenCornerUpRight");
        Position position = new Position(0, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenCornerDownleft() {
        System.out.println("testIsInsideWhenCornerDownleft");
        Position position = new Position(4, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenCornerDownRight() {
        System.out.println("testIsInsideWhenCornerDownRight");
        Position position = new Position(4, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenBoundaryUp() {
        System.out.println("testIsInsideWhenBoundaryUp");
        Position position = new Position(0, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenBoundaryDown() {
        System.out.println("testIsInsideWhenBoundaryDown");
        Position position = new Position(4, 2);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenBoundaryLeft() {
        System.out.println("testIsInsideWhenBoundaryLeft");
        Position position = new Position(1, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenBoundaryRight() {
        System.out.println("testIsInsideWhenBoundaryRight");
        Position position = new Position(3, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenOutsideBoundaryUp() {
        System.out.println("testIsInsideWhenOutsideBoundaryUp");
        Position position = new Position(-1, 1);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenOutsideBoundaryDown() {
        System.out.println("testIsInsideWhenOutsideBoundaryDown");
        Position position = new Position(100, 2);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenOutsideBoundaryLeft() {
        System.out.println("testIsInsideWhenOutsideBoundaryLeft");
        Position position = new Position(1, -1);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenOutsideBoundaryRight() {
        System.out.println("testIsInsideWhenOutsideBoundaryRight");
        Position position = new Position(3, 100);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testIsInsideWhenInside() {
        System.out.println("testIsInsideWhenInside");
        Position position = new Position(2, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test(expected = NullPointerException.class)
    public void testIsInsideWhenPositionIsNull() {
        System.out.println("testIsInsideWhenPositionIsNull");
        Board instance = new Board();
        instance.isInside(null);

    }

    @Test
    public void testIsFreeTrue() {
        System.out.println("testIsFreeTrue");
        Position position = new Position(2, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isFree(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFreeFalse() {
        System.out.println("testIsFreeFalse");
        Position position = new Position(2, 1);
        Board instance = new Board();
        instance.put(new Piece(PlayerColor.WHITE), position);
        boolean expResult = false;
        boolean result = instance.isFree(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPiece() {
        System.out.println("testGetPiece");
        Position position = new Position(2, 1);
        Board instance = new Board();
        Piece piece = new Piece(PlayerColor.WHITE);
        instance.put(piece, position);
        Piece expResult = piece;
        Piece result = instance.getPiece(position);

    }

    @Test
    public void testPut() {
        System.out.println("testPut");
        Piece piece = new Piece(PlayerColor.BLACK);
        Position position = new Position(1, 1);
        Board instance = new Board();
        instance.put(piece, position);
        Square expResult = new Square();
        expResult.put(piece);
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testHasColorTrue() {
        System.out.println("testHasColorTrue");
        Position position = new Position(1, 1);
        PlayerColor color = PlayerColor.BLACK;
        Board instance = new Board();
        instance.put(new Piece(PlayerColor.BLACK), position);
        boolean result = instance.hasColor(position, color);
        assertTrue(result);
    }

    @Test
    public void testHasColorFalse() {
        System.out.println("testHasColorFalse");
        Position position = new Position(1, 1);
        PlayerColor color = PlayerColor.WHITE;
        Board instance = new Board();
        instance.put(new Piece(PlayerColor.BLACK), position);
        boolean result = instance.hasColor(position, color);
        assertFalse(result);
    }

    @Test
    public void testIsFullFalse() {
        System.out.println("testIsFullTrue");
        Board instance = new Board();
        boolean result = instance.isFull();
        assertFalse(result);
    }

    @Test
    public void testIsFullTrue() {
        System.out.println("testIsFullTrue");
        Board instance = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                instance.getSquare(new Position(i, j)).put(new Piece(PlayerColor.BLACK));
            }
        }
        boolean result = instance.isFull();
        assertTrue(result);
    }

    @Test
    public void testFlip() {
        System.out.println("testFlip");
        Position position = new Position(1, 1);
        Board instance = new Board();
        instance.put(new Piece(PlayerColor.BLACK), position);
        instance.flip(position);
        assertEquals(instance.getPiece(position).getColor(), PlayerColor.WHITE);
    }

    @Test(expected = IllegalStateException.class)
    public void testFlipWhenNoPiece() {
        System.out.println("testFlipWhenNoPiece");
        Position position = new Position(1, 1);
        Board instance = new Board();
        instance.flip(position);
    }
}
