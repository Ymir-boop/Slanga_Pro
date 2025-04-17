package vinnsla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnakesNLaddersTest {

    private SnakesNLadders small;
    private SnakesNLadders medium;
    private SnakesNLadders large;

    @Before
    public void constructStackTestObject() {
        small = new SnakesNLadders(16);
        medium = new SnakesNLadders(25);
        large = new SnakesNLadders(36);
    }

    @Test
    public void testGetLendingSmall() {


        // prófar litla borðið
        assertEquals(1, small.getLending(1));
        assertEquals(2, small.getLending(2));
        assertEquals(16, small.getLending(16));

        //stigar
        assertEquals(9, small.getLending(3));
        assertEquals(12, small.getLending(7));

        //slöngur
        assertEquals(2, small.getLending(11));
        assertEquals(1, small.getLending(13));
        assertEquals(4, small.getLending(8));
    }

    @Test
    public void testGetLendingMedium() {

        //prófar medium borðið
        assertEquals(1, medium.getLending(1));
        assertEquals(2, medium.getLending(2));
        assertEquals(25, medium.getLending(25));
        //stigar
        assertEquals(10, medium.getLending(3));
        assertEquals(21, medium.getLending(14));
        assertEquals(16, medium.getLending(9));

        //slöngur
        assertEquals(2, medium.getLending(11));
        assertEquals(5, medium.getLending(24));
        assertEquals(7, medium.getLending(18));

    }

    @Test
    public void testGetLendingLarge() {

        //prófar stóra borðið
        assertEquals(1, large.getLending(1));
        assertEquals(2, large.getLending(2));
        assertEquals(36, large.getLending(36));
        //stigar
        assertEquals(20, large.getLending(3));
        assertEquals(25, large.getLending(14));
        assertEquals(33, large.getLending(29));

        //slöngur
        assertEquals(4, large.getLending(8));
        assertEquals(11, large.getLending(16));
        assertEquals(2, large.getLending(24));
        assertEquals(22, large.getLending(30));
        assertEquals(15, large.getLending(34));
    }
}
