package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import vidmot.slanga_pro.PlayerDialog;

public class Game{

    private int max;

    private final Dice dice = new Dice();
    private final PlayerDialog playerDialog = new PlayerDialog();
    private SimpleStringProperty message1 = new SimpleStringProperty("Hægt er að finna stillingar í menu");
    private SimpleStringProperty message2 = new SimpleStringProperty("");
    private SnakesNLadders snakesNLadders;

    // hér er allt sem kemur að spilurum
    private Player[] players;
    private int playerAmount;
    private int indexOfPlayer = 0;
    private int i = 0;
    private Player nextPlayer;

    // sé til hvort ég nota þetta
    public static String winner;


    public Player getNextPlayer() { // eyði ef ég nota ekkert
        return nextPlayer;
    }



    public Game(int size, int playerAmount){
        System.out.println("Leikur hefst");
        max = size * size;
        snakesNLadders = new SnakesNLadders(max);
        this.playerAmount = playerAmount;
        players = new Player[playerAmount];
        for (int i = 0; i < playerAmount; i++){
            Player p = createPlayer();
            if (p == null) return;
            players[i] = p;
            System.out.println("Created player " + (i+1) + ": " + players[i].getName());
        }
        nextPlayer = players[indexOfPlayer];
        message1.set("Leikur hefst");
        message2.set("Ýttu á teninginn til að halda áfram");
    }

    private Player createPlayer() {
        return playerDialog.open();
    }

    /**
     *
     * @return skilar true ef leikurinn er búinn
     */
    public boolean round(){
        System.out.println("\nRound " + ++i + "\n");
        message1.set("Umferð " + i);
        if (nextPlayer == null) {
            System.out.println("Next player is null");
            return true;
        }
        dice.roll();
        int result = dice.getRollResult();
        System.out.println("Result: " + result);
        int landing = snakesNLadders.getLending(dice.getRollResult() + nextPlayer.getTile());
        if (nextPlayer.move(landing, max)) {
            System.out.println(nextPlayer.getName() + " vinnur leikinn");
            message1.set(nextPlayer.getName() + " vinnur leikinn");
            message2.set("");
            winner = nextPlayer.getName();
            return true;
        }
        System.out.println(nextPlayer.getName() + " færðist á reit " + nextPlayer.getTile());
        message2.set(nextPlayer.getName() + " færðist á reit " + nextPlayer.getTile());

        // setur næsta leikmann
        indexOfPlayer = ++indexOfPlayer % playerAmount;
        nextPlayer = players[indexOfPlayer];
        System.out.println("Next player: " + nextPlayer.getName());
        return false;
    }

    public static void main(String[] args) {
    }

    public Player[] getPlayers() {
        return players;
    }

    public Dice getDice() {
        return dice;
    }

    public int getMax() {
        return max;
    }

    public SimpleStringProperty getMessage1Property() { return message1; }

    public SimpleStringProperty getMessage2Property() { return message2; }
}
