package g52167.Othello.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurent
 */
public class SquareTest {

    public SquareTest() {
    }

    @Test
    public void testGetPiece() {
        System.out.println("testGetPiece");
        Square instance = new Square();
        instance.put(new Piece(PlayerColor.BLACK));
        Piece expResult = new Piece(PlayerColor.BLACK);
        Piece result = instance.getPiece();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFreeWhenTrue() {
        System.out.println("testIsFreeWhenTrue");
        Square instance = new Square();
        boolean result = instance.isFree();
        assertTrue(result);
    }

    @Test
    public void testIsFreeWhenFalse() {
        System.out.println("testIsFreeWhenFalse");
        Square instance = new Square();
        instance.put(new Piece(PlayerColor.BLACK));
        boolean result = instance.isFree();
        assertFalse(result);
    }

    @Test
    public void testHasColorWhenTrue() {
        System.out.println("testHasColorWhenTrue");

        PlayerColor color = PlayerColor.BLACK;
        Square instance = new Square();
        instance.put(new Piece(PlayerColor.BLACK));
        boolean result = instance.hasColor(color);
        assertTrue(result);
    }

    @Test
    public void testHasColorWhenFalse() {
        System.out.println("testHasColorWhenFalse");

        PlayerColor color = PlayerColor.BLACK;
        Square instance = new Square();
        instance.put(new Piece(PlayerColor.WHITE));
        boolean result = instance.hasColor(color);
        assertFalse(result);
    }

    @Test(expected = IllegalStateException.class)
    public void testPutWhenSquareIsNotEmpty() {
        System.out.println("testPutWhenSquareIsNotEmpty");
        Piece disc = new Piece(PlayerColor.BLACK);
        Square instance = new Square();
        instance.put(new Piece(PlayerColor.BLACK));
        instance.put(disc);

    }

    @Test
    public void testPutWhenSquareIsEmpty() {
        System.out.println("testPutWhenSquareIsEmpty");
        Piece disc = new Piece(PlayerColor.WHITE);
        Square instance = new Square();
        instance.put(disc);
        assertEquals(disc, instance.getPiece());
    }

    @Test(expected = NullPointerException.class)
    public void testPutWhenDiscIsNull() {
        System.out.println("testPutWhenDiscIsNull");
        Piece disc = null;
        Square instance = new Square();
        instance.put(disc);
    }
}
