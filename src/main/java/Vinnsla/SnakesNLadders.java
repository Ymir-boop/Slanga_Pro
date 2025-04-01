package Vinnsla;

import java.util.HashMap;

public class SnakesNLadders {
    private final HashMap<Integer, Integer> laddersNSnakes = new HashMap<Integer, Integer>();

    public SnakesNLadders() { // set svo upp system sem getur tekið inn stærð á borði og búið til mismunandi stiga eftir því
        laddersNSnakes.put(3, 10); // þetta er stigi sem fer frá 3 til 10
        laddersNSnakes.put(11, 2); // þetta er slanga sem fer frá 11 til 2
    }

    public int getLending(int reitur){
        return laddersNSnakes.getOrDefault(reitur, reitur);
    }

    public static void main(String[] args) {
        SnakesNLadders s = new SnakesNLadders();
        System.out.println(s.getLending(3));
        System.out.println(s.getLending(11));
    }
}
