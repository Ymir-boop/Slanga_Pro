package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.Pane;


public class Player extends Pane {
    private SimpleIntegerProperty tile = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty(); // kannski óþarfi að hafa þetta sem property

    public Player(String name) {
        this.name.set(name);
        tile.set(1);
    }

    /**
     * @param landing kast
     * @param max
     * @return skilar true ef leikurinn klárast.
     */
    public boolean move(int landing, int max) { // þarf að breyta tests núna FIXME
        if (landing >= max){
            this.tile.set(max);
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

    public IntegerProperty getTileProperty() {
        return tile;
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
        int max = 25;
        dice.roll();
        int rollResult = dice.getRollResult();
        player.move(rollResult, max);
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
        player.move(5, max);
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
        player.reset();
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
    }
}
