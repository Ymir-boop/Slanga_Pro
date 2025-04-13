package vidmot.slanga_pro;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import vinnsla.Game;
import vinnsla.View;
import vinnsla.ViewSwitcher;

public class EndController {

    public Label fxWinner;
    public ImageView fxImage;

    public void initialize() {
        fxWinner.setText(Game.winner + " er sigurvegari leiksins!");
    }

    public void onAftur(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.START_VIEW);
    }
}
