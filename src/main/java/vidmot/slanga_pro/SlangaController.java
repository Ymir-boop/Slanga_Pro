package vidmot.slanga_pro;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    public ImageView fxDice;
    @FXML
    public GridPane fxTable;

    private Game game;
    private boolean gameOver = true;

    static IntegerProperty players = new SimpleIntegerProperty();
    int rowsNCols = 5;


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
            String[] diceImg= {"images/dice/1.png ", "images/dice/2.png ", "images/dice/3.png ", "images/dice/4.png ", "images/dice/5.png ", "images/dice/6.png "};
            game.getDice().getRollResultProperty().addListener((obs, oldVal, newVal) -> {
                fxDice.getImage().getUrl().replaceFirst("images/dice/[1-6].png ", diceImg[newVal.intValue()-1]);

            });
            //                        fxTeningur.getStyleClass().remove(teningaMyndir[gamlaGildi.intValue() - 1]);
            //                        fxTeningur.getStyleClass().add(teningaMyndir[nyttGildi.intValue() - 1]);
        }
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
        if (players.getValue() == 0){
            game = new Game(rowsNCols, 1);
            makeBindings();
            return;
        }
        game = new Game(rowsNCols, players.get());
        makeBindings();
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
}
