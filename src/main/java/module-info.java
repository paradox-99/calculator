module sourcefile {
    requires javafx.controls;
    requires javafx.fxml;

    opens sourcefile to javafx.fxml;
    opens sourcefile2 to javafx.fxml;
    opens sourcefile3 to javafx.fxml;
    exports sourcefile;
    exports sourcefile2;
    exports sourcefile3;
}
