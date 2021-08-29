module ch.bbw.td {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires com.google.gson;

    //opens ch.bbw.td to javafx.fxml;
    opens ch.bbw.td to com.google.gson, javafx.fxml;
    exports ch.bbw.td;
}