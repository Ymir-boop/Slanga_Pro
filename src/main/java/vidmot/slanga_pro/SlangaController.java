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
    Game game = null;

    static IntegerProperty players = new SimpleIntegerProperty(5); // gerði þetta að property ekki viss hvort það þurfi
    int rowsNCols = 5;

    public void initialize() {
     //   players.bind(SettingController.fxPlayers.valueProperty());
    }

    public void diceHandler(MouseEvent mouseEvent) {
        if (game == null) {
            System.out.println("Game is null");
            return;
        }
        game.round();
    }

    //reset aðferð

    //handlerar fyrir menu takka
    public void nyrHandler(ActionEvent actionEvent) {
        System.out.println("Nýr");
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
