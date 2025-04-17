package vidmot.slanga_pro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import vinnsla.Player;

import java.io.IOException;

public class PlayerDialog {

    @FXML
    private TextField nameField;
    @FXML
    private Dialog<Player> dialog;

    /**
     * smiður fyrir PlayerDialog sem frumstillir takkana
     * býr til leikmann eftir að dialog er lokað
     */
    public PlayerDialog() {
        dialog = new Dialog<Player>();
        dialog.setTitle("Bættu inn leikmanni");
        loadFXML();

        // setur upp takkana í dialog
        dialog.getDialogPane().getButtonTypes().addAll(
                new javafx.scene.control.ButtonType("Create", javafx.scene.control.ButtonBar.ButtonData.OK_DONE),
                javafx.scene.control.ButtonType.CANCEL
        );

        dialog.setResultConverter(button -> {
            if (button.getButtonData() == javafx.scene.control.ButtonBar.ButtonData.OK_DONE) {
                String name = nameField.getText().trim();
                if (name.isEmpty()) name = "Ónefndur leikmaður";
                return new Player(name);
            }
            return null;
        });

    }

    /**
     * aðferð sem opnar dialoginn og tekur inn nafn sem String
     * leikmaður verður til út frá nafninu
     * @return skilar leikmanninum sem hefur orðið til
     */
    public Player open() {
        resetFields();
        return dialog.showAndWait().orElse(null);
    }

    /**
     * aðferð sem frumstillir dialoginn með fxml skrá
     */
    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dialog-view.fxml"));
            loader.setController(this);
            dialog.getDialogPane().setContent(loader.load());
        } catch (IOException e) {
            throw new RuntimeException("Unable to load dialog-view.fxml", e);
        }
    }

    /**
     * aðferð sem núllstillir dialoginn í upphafi
     */
    private void resetFields() {
        nameField.setText("");
    }


}
