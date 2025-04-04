package vinnsla;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;
    private Dice dice;

    @Before
    public void constructStackTestObject() {
        player = new Player("Hans");
        dice = new Dice();
    }

    @Test
    public void testMove() {
        dice.roll();
        player.move(dice.getRollResult());
        assertTrue(player.getTile() > 0 && player.getTile() <= 6);
        dice.roll();
        player.move(dice.getRollResult());
        assertTrue(player.getTile() >= 2 && player.getTile() <= 12);
    }

    @Test
    public void testReset() {
        dice.roll();
        player.move(dice.getRollResult());
        assertTrue(player.getTile() > 0 && player.getTile() <= 6);
        player.reset();
        assertEquals(1, player.getTile());
    }

    @Test
    public void testGetName() {
        assertEquals("Hans", player.getName());
    }

    @Test
    public void testNoMove() {
        assertEquals(1, player.getTile());
    }



}
