package vinnsla;

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

    /**
     * aðferð sem keyrir eina umferð í leiknum
     * @return skilar true ef leikurinn klárast
     */
    public boolean round(){

        setRoundMessage();
        if (nextPlayer == null) {
            System.out.println("Next player is null");
            return true;
        }

        int landing = getLanding();
        if (nextPlayer.move(landing, max)) {
            winHandler();
            return true;
        }
        setLandingMessage();
        setNextPlayerMessage();
        return false;
    }

    /**
     * uppfærir skilaboð í viðmóti til að sýna stöðu leikmanns
     */
    private void setLandingMessage() {
        System.out.println(nextPlayer.getName() + " færðist á reit " + nextPlayer.getTile());
        message2.set(nextPlayer.getName() + " færðist á reit " + nextPlayer.getTile());
    }

    /**
     * uppfærir skilaboð í viðmóti til að sýna næsta leikmann
     */
    private void setNextPlayerMessage() {
        indexOfPlayer = ++indexOfPlayer % playerAmount;
        nextPlayer = players[indexOfPlayer];
        System.out.println("Next player: " + nextPlayer.getName());
    }

    /**
     * uppfærir skilaboð í viðmóti til að sýna umferð
     */
    private void setRoundMessage() {
        System.out.println("\nRound " + ++i + "\n");
        message1.set("Umferð " + i);
    }

    /**
     * kastar tening og sækir lendingu leikmanns
     * @return skilar reit sem leikmaður hefur færst á
     */
    private int getLanding() {
        dice.roll();
        int result = dice.getRollResult();
        System.out.println("Result: " + result);
        int landing = snakesNLadders.getLending(dice.getRollResult() + nextPlayer.getTile());
        return landing;
    }

    /**
     * bregst við því ef leikmaður vinnur leikinn.
     */
    private void winHandler() {
        System.out.println(nextPlayer.getName() + " vinnur leikinn");
        message1.set(nextPlayer.getName() + " vinnur leikinn");
        message2.set("");
        winner = nextPlayer.getName();
    }

    /**
     * getter fyrir lista af leikmönnum
     * @return skilar lista af leikmönnum
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * skilar tenings hlutnum
     * @return teningur
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * skilar property á skilaboð í viðmóti
     * @return skilar property á skilaboð1
     */
    public SimpleStringProperty getMessage1Property() { return message1; }

    /**
     * skilar property á skilaboð í viðmóti
     * @return skilar property á skilaboð2
     */
    public SimpleStringProperty getMessage2Property() { return message2; }

    /**
     * býr til nýjan leikmann með því að opna dialog
     * @return skilar leikmanninum sem er smíðaður
     */
    private Player createPlayer() {
        return playerDialog.open();
    }

    /**
     * aðferð sem skilar næsta leikmann
     * @return skilar næsta leikmann
     */
    public Player getNextPlayer() {
        return nextPlayer;
    }
}
