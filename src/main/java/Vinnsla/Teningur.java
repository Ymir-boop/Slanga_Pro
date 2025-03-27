package Vinnsla;

import javafx.beans.property.SimpleIntegerProperty;

public class Teningur {
    private static final SimpleIntegerProperty KAST = new SimpleIntegerProperty();
    private static final int MAX = 6;

    /**
     * @return a random number from 1 to 6
     */
    public void kasta() {
        KAST.set((int) (Math.random() * MAX) + 1);
    }


    /**
     * @return the value of kast
     */
    public static int getKast() {
        return KAST.get();
    }

    /**
     * @param args ónotað
     */
    public static void main (String[] args) {
        Teningur t = new Teningur();
        t.kasta();
        System.out.println(t.getKast());
    }

}
