package vinnsla;

import vidmot.slanga_pro.PlayerDialog;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Game{

    private int max;

    private final Dice dice = new Dice();
    private final PlayerDialog playerDialog = new PlayerDialog();

    // hér er allt sem kemur að spilurum
    private Player[] players;
    private int playerAmount;
    private int indexOfPlayer = 0;
    private int i = 0;

    public Game() {
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    private Player nextPlayer;

    public Game(int size, int playerAmount){
        System.out.println("Leikur hefst");
        max = size * size;
        this.playerAmount = playerAmount;
        players = new Player[playerAmount];
        for (int i = 0; i < playerAmount; i++){
            Player p = createPlayer();
            if (p == null) return;
            players[i] = p;
            System.out.println("Created player " + (i+1) + ": " + players[i].getName());
        }
        nextPlayer = players[indexOfPlayer];
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
        if (nextPlayer == null) {
            System.out.println("Next player is null");
            return true;
        }
        dice.roll();
        int result = dice.getRollResult();
        System.out.println("Result: " + result);
        if (nextPlayer.move(dice.getRollResult(), max)) {
            System.out.println(nextPlayer.getName() + " vinnur leikinn");
            return true;
        }
        System.out.println(nextPlayer.getName() + " færðist á reit " + nextPlayer.getTile());

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
}
