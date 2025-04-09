package vidmot.slanga_pro;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import vinnsla.*;
import javafx.event.ActionEvent;

public class SettingController {

    @FXML
    public ComboBox<String> fxDifficulty;

    @FXML
    public Spinner<Integer> fxPlayers;

    @FXML
    public ComboBox<String> fxTheme;

    public void initialize() {
        fxDifficulty.getItems().addAll(Difficulty.getValues());
        fxPlayers.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 2));
        fxTheme.getItems().addAll(Theme.getValues());
        //fxPlayers.getValueFactory().setValue(Game.getTimi().get().getHour()); binding fyrir fjölda spilara valið og í game

    }

    public void onSpila(ActionEvent actionEvent) {
        if (fxDifficulty.getValue() == null) {
            System.out.println("Defaulting to medium");
            ViewSwitcher.switchTo(View.MEDIUM_VIEW);
            return;
        }
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
}
