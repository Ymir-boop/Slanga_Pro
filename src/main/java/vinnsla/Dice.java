package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Dice {

    private static final SimpleIntegerProperty rollResult = new SimpleIntegerProperty(1);
    private static final int MAX = 6;

    /**
     * kastar teningnum og gefur rollResult gildi
     * @return random tala milli 1 og 6
     */
    public void roll() {
        rollResult.set((int) (Math.random() * MAX) + 1);
    }


    /**
     * @return skilar gildi í rollResult sem er kastið á teningnum
     */
    public int getRollResult() {
        return rollResult.get();
    }

    /**
     * aðferð til að sækja gildin í rollResult sem property til þess að geta notað bindings
     * @return kasti teningsins sem property
     */
    public IntegerProperty getRollResultProperty() {
        return rollResult;
    }

    /**
     * main aðferð sem prófar teninginn
     * @param args ónotað
     */
    public static void main (String[] args) {
        Dice t = new Dice();
        System.out.println(t.getRollResult());
        t.roll();
        System.out.println(t.getRollResult());
    }

}
