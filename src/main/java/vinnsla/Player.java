package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import static vinnsla.Dice.getRollResult;

public class Player {
    private SimpleIntegerProperty tile = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty(); // kannski óþarfi að hafa þetta sem property

    public Player(String name) {
        this.name.set(name);
        tile.set(1);
    }

    public void move(int roll) {
        this.tile.set(this.tile.get() + roll);
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
        int rollResult = getRollResult();
        player.move(rollResult);
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
        player.move(5);
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
        player.reset();
        System.out.println(player.getName() + " færðist á reit " + player.getTile());
    }
}
