package g52167.Othello.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurent
 */
public class GameTest {

    public GameTest() {
    }
    private final Square[][] defaultBoard = {
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()}};

    @Test
    public void testInitialize() {
        System.out.println("testInitialize");
        Game instance = new Game();
        instance.initialize();
        Square[][] expResult = defaultBoard;
        expResult[3][4].put(new Piece(PlayerColor.BLACK));
        expResult[4][3].put(new Piece(PlayerColor.BLACK));
        expResult[3][3].put(new Piece(PlayerColor.WHITE));
        expResult[4][4].put(new Piece(PlayerColor.WHITE));
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testStartWhenBoardIsNull() {
        System.out.println("testStartWhenBoardIsNull");
        Game instance = new Game();
        instance.start();
    }

    @Test
    public void testIsOverWhenFalse() {
        System.out.println("testIsOverWhenFalse");

        Game instance = new Game();
        instance.initialize();
        boolean result = instance.isOver();
        assertFalse(result);
    }

    @Test
    public void testIsOverWhenTrue() {
        System.out.println("testIsOverWhenTrue");

        Game instance = new Game();
        instance.initialize();
        instance.move(new Position(2, 3));
        instance.move(new Position(4, 2));
        instance.move(new Position(5, 3));
        instance.move(new Position(2, 4));
        instance.move(new Position(3, 1));
        instance.move(new Position(2, 2));
        instance.move(new Position(1, 3));
        instance.move(new Position(3, 2));
        instance.move(new Position(3, 5));

        boolean result = instance.isOver();
        assertTrue(result);
    }

    @Test
    public void testHasMovesWhenTrue() {
        System.out.println("testHasMovesWhenTrue");

        Player player = new Player(PlayerColor.BLACK);
        Game instance = new Game();
        instance.initialize();
        boolean result = instance.hasMoves(player);
        assertTrue(result);
    }

    @Test
    public void testHasMovesWhenFalse() {
        System.out.println("testHasMovesWhenFalse");

        Player player = new Player(PlayerColor.WHITE);
        Game instance = new Game();
        instance.initialize();

        instance.move(new Position(2, 3));
        instance.move(new Position(4, 2));
        instance.move(new Position(5, 3));
        instance.move(new Position(2, 4));
        instance.move(new Position(3, 1));
        instance.move(new Position(2, 2));
        instance.move(new Position(1, 3));
        instance.move(new Position(3, 2));
        instance.move(new Position(3, 5));

        boolean result = instance.hasMoves(player);
        assertFalse(result);
    }

    @Test
    public void testCheckPosition() {
        System.out.println("testCheckPosition");

        Game instance = new Game();
        instance.initialize();

        Position position = new Position(2, 3);
        Player player = new Player(PlayerColor.BLACK);

        List<Position> expResult = new ArrayList<Position>();
        expResult.add((new Position(3, 3)));

        List<Position> result = instance.checkPosition(position, player);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove() {
        System.out.println("testMove");
        Position position = new Position(2, 3);
        Game instance = new Game();
        instance.initialize();
        instance.move(position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveWhenPositionNotOnBoard() {
        System.out.println("testMoveWhenPositionNotOnBoard");

        Position position = new Position(-1, 5);
        Game instance = new Game();
        instance.initialize();
        instance.move(position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveWhenPositionNotFree() {
        System.out.println("testMoveWhenPositionNotFree");

        Position position = new Position(3, 3);
        Game instance = new Game();
        instance.initialize();
        instance.move(position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveWhenError() {
        System.out.println("testMoveWhenError");
        Position position = new Position(0, 0);;
        Game instance = new Game();
        instance.initialize();
        instance.move(position);
    }

    @Test
    public void testSwapPlayers() {
        System.out.println("testSwapPlayers");
        Game instance = new Game();
        instance.initialize();
        instance.swapPlayers();
        Player whitePlayer = new Player(PlayerColor.WHITE);
        Player currentPlayer = instance.getCurrent();
        assertEquals(whitePlayer, currentPlayer);
    }

    @Test
    public void testGetCurrent() {
        System.out.println("testGetCurrent");
        Game instance = new Game();
        Player expResult = new Player(PlayerColor.BLACK);
        Player result = instance.getCurrent();
        assertEquals(expResult, result);
    }

}
