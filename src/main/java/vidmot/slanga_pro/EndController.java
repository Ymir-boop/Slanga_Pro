package vidmot.slanga_pro;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import vinnsla.Game;
import vinnsla.View;
import vinnsla.ViewSwitcher;

public class EndController {

    public Label fxWinner;

    public Label fxWinnerImg;
    public AnchorPane fxAnchor;

    public void initialize() {
        fxWinner.setText(Game.winner + " er sigurvegari leiksins!");
        // bý kannski til binding eða listener sem uppfærir fxWinner ef Game.winner breytist
    }

    public void onAftur(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.START_VIEW);
    }
}
