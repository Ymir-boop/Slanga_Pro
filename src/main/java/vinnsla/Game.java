package vinnsla;

import vidmot.slanga_pro.PlayerDialog;

public class Game{

    private int max;

    private final Dice dice = new Dice();
    private final PlayerDialog playerDialog = new PlayerDialog();

    // hér er allt sem kemur að spilurum
    private Player[] players;
    private int playerAmount;
    private int indexOfPlayer = 0;
    private Player nextPlayer;

    public Game(int size, int playerAmount){
        System.out.println("Leikur hefst");
        max = size * size;
        this.playerAmount = playerAmount;
        players = new Player[playerAmount];
        for (int i = 0; i < playerAmount; i++){
            // frumstilla alla spilarana...opnar dialog sem biður um nafn og mynd??
            Player p = createPlayer();
            if (p == null) return;
            players[i] = p;
            //System.out.println("Created player: " + players[i].getName() + i);
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
        System.out.println("Round" + indexOfPlayer);
        if (nextPlayer == null) return true;
        dice.roll();
        int result = dice.getRollResult();
        System.out.println(nextPlayer.getName() + " færðist á reit " + nextPlayer.getTile());
        if (nextPlayer.move(dice.getRollResult())) return true;

        // setur næsta leikmann
        indexOfPlayer = ++indexOfPlayer % playerAmount;
        nextPlayer = players[indexOfPlayer];
        return false;
    }

    public static void main(String[] args) {
    }
}
