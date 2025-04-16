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
        // frumstillir combobox og spinner
        fxDifficulty.getItems().addAll(Difficulty.getValues());
        fxPlayers.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 3));
        fxTheme.getItems().addAll(Theme.getValues());

        // binding fyrir fjölda leikmanna
        fxPlayers.getValueFactory().valueProperty().bindBidirectional(SlangaController.players.asObject()); // kannski einhver villa í þessu?? gæti verið því að initialize keyrir bar einusinni?
    }

    public void onSpila(ActionEvent actionEvent) {

        // velur þema
        if (fxTheme.getValue() == null) {
            SlangaController.styleSheet = "/css/classic.css";
        }
        else if (fxTheme.getValue().equals(Theme.CLASSIC.getMessage())) {
            SlangaController.styleSheet = "/css/classic.css";
        }
        else if (fxTheme.getValue().equals(Theme.FOOTBALL.getMessage())) {
            SlangaController.styleSheet = "/css/football.css";
        }
//        auka ef ég vil gera fleiri - þarf að taka úr comboboxinu líka
//        else if (fxTheme.getValue().equals(Theme.MONOPOLY.getMessage())) {
//            SlangaController.styleSheet = "/css/monopoly.css";
//        }
//        else if (fxTheme.getValue().equals(Theme.RANDOM.getMessage())) {
//            SlangaController.styleSheet = "/css/random.css";
//        }

        // velur erfiðleikastig
        if (fxDifficulty.getValue() == null) {
            System.out.println("Default difficulty selected");
            ViewSwitcher.switchTo(SlangaController.view);
            return;
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
