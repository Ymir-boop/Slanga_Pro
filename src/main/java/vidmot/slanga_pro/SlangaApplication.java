package vidmot.slanga_pro;

import javafx.fxml.FXMLLoader;
import vinnsla.View;
import vinnsla.ViewSwitcher;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SlangaApplication extends Application {

    /**
     * start aðferð sem keyrir forritið
     * @param stage gluggi
     * @throws IOException villa
     */
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane(), 500, 700);
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.START_VIEW);
        stage.setTitle("Slönguspil Pro");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main aðferð sem keyrir forritið
     * @param args ónotað
     */
    public static void main(String[] args) {
        launch();
    }
}