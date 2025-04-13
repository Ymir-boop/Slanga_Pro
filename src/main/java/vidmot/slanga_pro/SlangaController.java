package vidmot.slanga_pro;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import vinnsla.Game;
import vinnsla.Player;
import vinnsla.View;
import vinnsla.ViewSwitcher;

import java.util.List;

public class SlangaController {

    @FXML
    public Button fxDice;
    @FXML
    public GridPane fxTable;
    @FXML
    public Label fxNextPlayerLabel;
    @FXML
    public ImageView fxNextPlayerImg;

    private Game game;
    private boolean gameOver = true;

    // lélegar static breytur en þægilegar. breyti þeim ef ég nenni
    static IntegerProperty players = new SimpleIntegerProperty();
    static View view = View.MEDIUM_VIEW;
    static int rowsNCols = 5;
    static String styleSheet = "/css/classic.css";


    public void initialize() {}

    private void makeBindings() {
        if (players != null) {
        // bindur myndir leikmanna við reitina
            String[] plaeyerStyles = {"player1", "player2", "player3", "player4", "player5"};
            Player[] players = game.getPlayers();
            for (int i = 0; i < players.length; i++) {
                Player player = players[i];
                final int numberOfPlayer = i;
                player.getTileProperty().addListener((obs, gamlaGildi, nyttGildi) -> {
                    fxTable.getChildren().get(gamlaGildi.intValue() - 1).getStyleClass().remove(plaeyerStyles[numberOfPlayer]);
                    fxTable.getChildren().get(nyttGildi.intValue() - 1).getStyleClass().add(plaeyerStyles[numberOfPlayer]);
                });
            }
        }

        if (fxDice != null) {
            String[] diceStyles = {"dice-1", "dice-2", "dice-3", "dice-4", "dice-5", "dice-6"};
            game.getDice().getRollResultProperty().addListener((obs, oldVal, newVal) -> {
                //fxDice.getImage().getUrl().replaceFirst("images/dice/[1-6].png ", diceImg[newVal.intValue()-1]);
                fxDice.getStyleClass().remove(diceStyles[oldVal.intValue() - 1]);
                fxDice.getStyleClass().add(diceStyles[newVal.intValue() - 1]);
            });
        }

        // bindings fyrir mynd af þeim sem á að gera næst og nafn
//        fxNextPlayerLabel.textProperty().bind(game.nextPlayerProperty().asString());
//        fxNextPlayerImg.imageProperty().bind(game.nextPlayerProperty().asString().concat(".png"));


    }


    public void diceHandler(MouseEvent mouseEvent) {
        if (game == null || gameOver) {
            nyrHandler(null);
            return;
        }
        if (game.round()){
            gameOver = true;
            ViewSwitcher.switchTo(View.END_VIEW);
        };
    }

    //handlerar fyrir menu takka
    public void nyrHandler(ActionEvent actionEvent) {
        System.out.println("Nýr");
        gameOver = false;
        if (game != null) resetImg();
        switchStyle();
        if (players.getValue() == 0){
            game = new Game(rowsNCols, 1);
            makeBindings();
            return;
        }
        game = new Game(rowsNCols, players.get());
        makeBindings();
    }

    private void resetImg() {
        System.out.println("reset");
        List<Node> tiles = fxTable.getChildren();
        for (Node tile : tiles) {
            tile.getStyleClass().remove("player1");
            tile.getStyleClass().remove("player2");
            tile.getStyleClass().remove("player3");
            tile.getStyleClass().remove("player4");
            tile.getStyleClass().remove("player5");
        }
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

    @FXML
    private void switchStyle() {
        fxTable.getStylesheets().clear();
        fxTable.getStylesheets().add(getClass().getResource(styleSheet).toExternalForm());
    }
}
