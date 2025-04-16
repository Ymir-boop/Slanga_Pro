module vidmot.slanga_pro {
    requires javafx.controls;
    requires javafx.fxml;


    opens vidmot.slanga_pro to javafx.fxml;
    exports vidmot.slanga_pro;
    exports vinnsla;
}