package vidmot.slanga_pro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import vinnsla.Game;
import vinnsla.View;
import vinnsla.ViewSwitcher;

public class EndController {

    @FXML
    public Label fxWinner;
    @FXML
    public AnchorPane fxAnchor;

    /**
     * sækir sigurvegara leiksins og birtir nafn hans
     */
    public void initialize() {
        fxWinner.setText(Game.winner + " er sigurvegari leiksins!");
        // bý kannski til binding eða listener sem uppfærir fxWinner ef Game.winner breytist
    }

    /**
     * handler fyrir takka "Aftur"
     * skiptir yfir í upphafsglugga
     * @param actionEvent event
     */
    public void onAftur(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.START_VIEW);
    }
}
