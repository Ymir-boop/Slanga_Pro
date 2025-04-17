package vinnsla;

import java.util.HashMap;

public class SnakesNLadders {

    private final HashMap<Integer, Integer> laddersNSnakes = new HashMap<Integer, Integer>();

    /**
     * klasi sem geymir stiga og slöngur á leikborði
     * mismunandi borð hafa mismunandi stiga og slöngur
     *
     * @author Ýmir
     * @param max tekur inn stærð borðs
     */
    public SnakesNLadders(int max) {
        switch (max) {
            case 16:
                // stigar
                laddersNSnakes.put(3, 9);
                laddersNSnakes.put(7, 12);

                // slöngur
                laddersNSnakes.put(11, 2);
                laddersNSnakes.put(13, 1);
                laddersNSnakes.put(8, 4);
                break;
            case 25:
                // stigar
                laddersNSnakes.put(3, 10);
                laddersNSnakes.put(14, 21);
                laddersNSnakes.put(9, 16);

                // slöngur
                laddersNSnakes.put(11, 2);
                laddersNSnakes.put(24, 5);
                laddersNSnakes.put(18, 7);

                break;
            case 36:
                //stigar
                laddersNSnakes.put(3, 20);
                laddersNSnakes.put(14, 25);
                laddersNSnakes.put(29, 33);

                //slöngur
                laddersNSnakes.put(8, 4);
                laddersNSnakes.put(16, 11);
                laddersNSnakes.put(24, 2);
                laddersNSnakes.put(30, 22);
                laddersNSnakes.put(34, 15);
                break;
        }
    }

    /**
     * skoðar hvort reitur er stigi eða slanga og skilar nýjum reit ef svo er.
     * skilar annars gamla reitnum aftur
     * @param reitur reitur sem lent er á
     * @return reitur sem endanlega er á
     */
    public int getLending(int reitur){
        return laddersNSnakes.getOrDefault(reitur, reitur);
    }

    /**
     * main aðferð til að prófa
     * @param args ónotað
     */
    public static void main(String[] args) {
        int max = 25;
        SnakesNLadders s = new SnakesNLadders(max);
        System.out.println(s.getLending(3));
        System.out.println(s.getLending(11));
    }
}
