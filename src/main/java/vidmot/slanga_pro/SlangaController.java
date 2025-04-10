package vidmot.slanga_pro;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import vinnsla.Game;
import vinnsla.View;
import vinnsla.ViewSwitcher;

public class SlangaController {
    private Game game;
    private boolean gameOver = false;

    static IntegerProperty players = new SimpleIntegerProperty();
    int rowsNCols = 5;

    public void initialize() {}


    public void diceHandler(MouseEvent mouseEvent) {
        if (game == null || gameOver) {
            nyrHandler(null);
            return;
        }
        if (game.round()){
            gameOver = true;
            ViewSwitcher.switchTo(View.END_VIEW);
        };
    }

    //handlerar fyrir menu takka
    public void nyrHandler(ActionEvent actionEvent) {
        System.out.println("Nýr");
        gameOver = false;
        if (players.getValue() == 0){
            game = new Game(rowsNCols, 1);
            return;
        }
        game = new Game(rowsNCols, players.get());
    }
    public void umHandler(ActionEvent actionEvent) {
        System.out.println("Um");
    }
    public void stillaHandler(ActionEvent actionEvent) {
        System.out.println("Stillingar");
        ViewSwitcher.switchTo(View.SETTING_VIEW);
    }

    public void helpHandler(ActionEvent actionEvent) {
        System.out.println("Um leikinn");
    }
    public void closeHandler(ActionEvent actionEvent) {
        System.out.println("Hætta");
        Platform.exit();
        System.exit(0);
    }
}
