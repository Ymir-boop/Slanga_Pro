package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;



public class Player {
    private final SimpleIntegerProperty tile = new SimpleIntegerProperty();
    private final String name;

    public Player(String name) {
        this.name = name;
        tile.set(1);
    }

    /**
     * aðferð sem færir leikmann á þann reit sem hann á að fara
     * skilar true ef leikurinn klárast
     * @param landing lending leikmannsins
     * @param max númer síðasta reits í leiknum
     * @return skilar true ef leikurinn klárast.
     */
    public boolean move(int landing, int max) {
        if (landing >= max){
            this.tile.set(max);
            return true;
        }
        this.tile.set(landing);
        return false;
    }

    /**
     * getter fyrir reit leikmanns
     * @return reit leikmanns
     */
    public int getTile() {
        return tile.get();
    }

    /**
     * getter fyrir reit leikmanns sem property
     * hentugt að nota fyrir bindings í viðmóti
     * @return reit leikmanns sem property
     */
    public IntegerProperty getTileProperty() {
        return tile;
    }

    /**
     * getter fyri nafn leikmanns
     * @return nafn leikmanns
     */
    public String getName() {
        return name;
    }

    /**
     * hjálparaðferð fyrir testing
     * @param rollResult tekur inn kast
     * @return skilar landing
     */
    public int getLanding(int rollResult) {
        return tile.get() + rollResult;
    }

    /**
     * main aðferð sem prófar leikmann klasann
     * @param args ónotað
     */
    public static void main(String[] args) {
        Player player = new Player("Hans");
        Dice dice = new Dice();
        int max = 25;
        dice.roll();
        int rollResult = dice.getRollResult();
        player.move(rollResult, max);
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
        player.move(5, max);
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
    }
}
