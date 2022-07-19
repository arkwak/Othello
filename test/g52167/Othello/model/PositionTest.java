package g52167.Othello.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurent
 */
public class PositionTest {

    public PositionTest() {
    }

    /**
     *
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Position instance = new Position(67, 42);
        int expResult = 67;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Position instance = new Position(34, -5);
        int expResult = -5;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }

    @Test
    public void testNextWhenUp() {
        System.out.println("testNextWhenUp");
        Direction direction = Direction.UP;
        Position instance = new Position(1, 1);
        Position expResult = new Position(0, 1);
        Position result = instance.nextPosition(direction);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextWhenDown() {
        System.out.println("testNextWhenDown");
        Direction direction = Direction.DOWN;
        Position instance = new Position(1, 1);
        Position expResult = new Position(2, 1);
        Position result = instance.nextPosition(direction);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextWhenLeft() {
        System.out.println("testNextWhenLEFT");
        Direction direction = Direction.LEFT;
        Position instance = new Position(1, 1);
        Position expResult = new Position(1, 0);
        Position result = instance.nextPosition(direction);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextWhenRight() {
        System.out.println("testNextWhenRight");
        Direction direction = Direction.RIGHT;
        Position instance = new Position(1, 1);
        Position expResult = new Position(1, 2);
        Position result = instance.nextPosition(direction);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextWhenUpLeft() {
        System.out.println("testNextWhenUpLeft");
        Direction direction = Direction.UPlEFT;
        Position instance = new Position(1, 1);
        Position expResult = new Position(0, 0);
        Position result = instance.nextPosition(direction);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextWhenUpRight() {
        System.out.println("testNextWhenUpRight");
        Direction direction = Direction.UPRIGHT;
        Position instance = new Position(1, 1);
        Position expResult = new Position(0, 2);
        Position result = instance.nextPosition(direction);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextWhenDownLeft() {
        System.out.println("testNextWhenownLeft");
        Direction direction = Direction.DOWNLEFT;
        Position instance = new Position(1, 1);
        Position expResult = new Position(2, 0);
        Position result = instance.nextPosition(direction);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextWhenDownRight() {
        System.out.println("testNextWhenDownRight");
        Direction direction = Direction.DOWNRIGHT;
        Position instance = new Position(1, 1);
        Position expResult = new Position(2, 2);
        Position result = instance.nextPosition(direction);
        assertEquals(expResult, result);
    }

}
