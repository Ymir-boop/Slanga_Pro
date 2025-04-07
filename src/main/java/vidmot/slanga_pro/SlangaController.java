package vidmot.slanga_pro;

import javafx.scene.input.MouseEvent;
import vinnsla.Game;

public class SlangaController {
    Game game;

    int players = 2;
    int rowsNCols = 5;

    public void initialize() {
        game = new Game(rowsNCols, players); // TODO laga smiðinn??
    }

    public void diceHandler(MouseEvent mouseEvent) {
        game.round();
    }

    //reset aðferð
}
