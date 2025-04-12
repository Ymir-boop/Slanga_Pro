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
        fxPlayers.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 3));
        fxTheme.getItems().addAll(Theme.getValues());
        fxPlayers.getValueFactory().valueProperty().bindBidirectional(SlangaController.players.asObject());
    }

    public void onSpila(ActionEvent actionEvent) {
        if (fxDifficulty.getValue() == null) {
            System.out.println("Default difficulty selected");
            ViewSwitcher.switchTo(SlangaController.view);
        }
        String val = fxDifficulty.getValue();
        if (val.equals(Difficulty.EASY.getMessage())) {
            SlangaController.rowsNCols = 4;
            SlangaController.view = View.EASY_VIEW;
        }
        else if (val.equals(Difficulty.MEDIUM.getMessage())) {
            SlangaController.rowsNCols = 5;
            SlangaController.view = View.MEDIUM_VIEW;
        }
        else if (val.equals(Difficulty.HARD.getMessage())) {
            SlangaController.rowsNCols = 6;
            SlangaController.view = View.HARD_VIEW;
        }
        ViewSwitcher.switchTo(SlangaController.view);
    }
}
