package vinnsla;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiceTest {
    private Dice dice;

    @Before
    public void constructStackTestObject() {
        dice = new Dice();
    }

    @Test
    public void testRoll() {
        dice.roll();
        assertTrue (dice.getRollResult() > 0 && dice.getRollResult() <= 6);
    }

    @Test
    public void testRollResult() {
        dice.roll();
        int result = dice.getRollResult();

        assertTrue (result > 0 && result <= 6);

        int oldResult = result;
        dice.roll();
        result += dice.getRollResult();

        assertTrue (result > oldResult);
    }

    @Test
    public void testEmpty() {
        assertTrue (true);
    }

}
