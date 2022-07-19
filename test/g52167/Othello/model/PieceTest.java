package g52167.Othello.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurent
 */
public class PieceTest {

    public PieceTest() {
    }

    /**
     *
     */
    @Test
    public void testGetColorWhite() {
        System.out.println("testGetColorWhite");
        Piece instance = new Piece(PlayerColor.WHITE);
        PlayerColor expResult = PlayerColor.WHITE;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testGetColorBlack() {
        System.out.println("testGetColorBlack");
        Piece instance = new Piece(PlayerColor.BLACK);
        PlayerColor expResult = PlayerColor.BLACK;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testFlip() {
        System.out.println("testFlip");
        Piece instance = new Piece(PlayerColor.BLACK);
        instance.flip();
        PlayerColor result = PlayerColor.WHITE;
        assertEquals(instance.getColor(), result);
    }

}
