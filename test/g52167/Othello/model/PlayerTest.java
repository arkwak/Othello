package g52167.Othello.model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import g52167.Othello.model.Piece.*;
import java.util.ArrayList;

/**
 *
 * @author Laurent
 */
public class PlayerTest {

    public PlayerTest() {
    }

    @Test(expected = NullPointerException.class)
    public void testConstructPlayerColorIsNull() {
        System.out.println("testConstructPlayerColorIsNull");
        Player instance = new Player(null);
    }

    /**
     *
     */
    @Test
    public void testGetColorWhite() {
        System.out.println("testGetColorWhite");
        Player instance = new Player(PlayerColor.WHITE);
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
        Player instance = new Player(PlayerColor.BLACK);
        PlayerColor expResult = PlayerColor.BLACK;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);
    }

}
