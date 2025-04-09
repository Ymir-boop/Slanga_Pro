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

//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(SlangaApplication.class.getResource("start-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
//        stage.setTitle("Slönguspil Pro");
//        stage.setScene(scene);
//        stage.show();
//    }

    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane(), 500, 700);
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.START_VIEW);
        stage.setTitle("Slönguspil Pro");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}