package vinnsla;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;
    private  Dice dice;
    private int max;

    @Before
    public void constructStackTestObject() {
        player = new Player("Hans");
        dice = new Dice();
        max = 25;
    }

    @Test
    public void testGetName() {
        assertEquals("Hans", player.getName());
    }

    @Test
    public void testNoMove() {
        assertEquals(1, player.getTile());
    }

    @Test
    public void testMove() {
        dice.roll();
        int initialTile = player.getTile();
        int rollResult = dice.getRollResult();
        int landing = player.getLanding(rollResult);
        player.move(landing, max);

        assertEquals(rollResult + initialTile, player.getTile());
    }

    @Test
    public void testMoveTillMax() {
        int allRolls = 0;

        while (player.getTile() < max) {
            assertEquals(allRolls + 1, player.getTile());
            dice.roll();
            int rollResult = dice.getRollResult();
            allRolls += rollResult;
            int landing = player.getLanding(rollResult);
            player.move(landing, max);
        }
        assertEquals(max, player.getTile());
    }
}
