package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.Pane;


public class Player extends Pane {
    private SimpleIntegerProperty tile = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty(); // kannski óþarfi að hafa þetta sem property
    private int maxTiles;

    public Player(String name) {
        this.name.set(name);
        tile.set(1);
    }

    /**
     *
     * @param roll kast
     * @return skilar true ef leikurinn klárast.
     */
    public boolean move(int roll) { // þarf að breyta tests núna FIXME
        int landing = this.tile.get() + roll;
        if (landing >= maxTiles){
            this.tile.set(maxTiles);
            return true;
        }
        this.tile.set(landing);
        return false;
    }

    public void reset() {
        this.tile.set(1);
    }

    public int getTile() {
        return tile.get();
    }

    public String getName() {
        return name.get();
    }

//    public SimpleIntegerProperty stadaProperty() {  gæti verið hentugt í bindings fyrir leikmennina
//        return stada;
//    }

    public static void main(String[] args) {
        Player player = new Player("Hans");
        Dice dice = new Dice();
        dice.roll();
        int rollResult = dice.getRollResult();
        player.move(rollResult);
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
        player.move(5);
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
        player.reset();
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
    }
}
