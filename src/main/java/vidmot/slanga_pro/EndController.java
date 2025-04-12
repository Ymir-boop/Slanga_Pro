package vidmot.slanga_pro;

import javafx.event.ActionEvent;
import vinnsla.View;
import vinnsla.ViewSwitcher;

public class EndController {
    public void onAftur(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(SlangaController.view);
    }
}
