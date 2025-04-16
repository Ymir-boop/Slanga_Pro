package vinnsla;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Dice {
    private static final SimpleIntegerProperty rollResult = new SimpleIntegerProperty(1);
    private static final int MAX = 6;

    /**
     * @return a random number from 1 to 6
     */
    public void roll() {
        rollResult.set((int) (Math.random() * MAX) + 1);
    }


    /**
     * @return the value of kast
     */
    public int getRollResult() {
        return rollResult.get();
    }

    /**
     * @param args ónotað
     */
    public static void main (String[] args) {
        Dice t = new Dice();
        t.roll();
        System.out.println(t.getRollResult());
    }

    public IntegerProperty getRollResultProperty() {
        return rollResult;
    }
}
