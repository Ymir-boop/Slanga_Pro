package vidmot.slanga_pro;

import javafx.application.Platform;
import javafx.event.ActionEvent;


public class MenuController  {


    //handlerar fyrir menu takka
    public void nyrHandler(ActionEvent actionEvent) {
        System.out.println("Nýr");
    }
    public void opnaHandler(ActionEvent actionEvent) {
        System.out.println("Opna");
    }
    public void vistaHandler(ActionEvent actionEvent) {
        System.out.println("Vista");
    }
    public void closeHandler(ActionEvent actionEvent) {
        System.out.println("Hætta");
        Platform.exit();
        System.exit(0);
    }
    public void eydaHandler(ActionEvent actionEvent) {
        System.out.println("Eyða");
    }
    public void umHandler(ActionEvent actionEvent) {
        System.out.println("Um");
    }

}
