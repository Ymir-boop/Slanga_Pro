package vidmot.slanga_pro;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import vinnsla.Difficulty;
import vinnsla.Game;
import vinnsla.View;
import vinnsla.ViewSwitcher;
import javafx.event.ActionEvent;

public class SettingController {

    @FXML
    public ComboBox<String> fxDifficulty;

    public void onAftur(ActionEvent actionEvent) {
        String val = fxDifficulty.getValue();
        if (val.equals(Difficulty.EASY.getMessage())) {
            ViewSwitcher.switchTo(View.EASY_VIEW);
        }
        else if (val.equals(Difficulty.MEDIUM.getMessage())) {
            ViewSwitcher.switchTo(View.MEDIUM_VIEW);
        }
        else if (val.equals(Difficulty.HARD.getMessage())) {
            ViewSwitcher.switchTo(View.HARD_VIEW);
        }
        else {
            System.out.println("No difficulty selected");
            ViewSwitcher.switchTo(View.MEDIUM_VIEW);
        }
    }

    public void initialize() {
        fxDifficulty.getItems().addAll(Difficulty.getValues());
        fxDifficulty.setValue(Difficulty.MEDIUM.getMessage());
    }

}
