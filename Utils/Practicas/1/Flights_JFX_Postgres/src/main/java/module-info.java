module andres.flights_jfxtemplate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens andres.flights_jfxtemplate to javafx.fxml;
    exports andres.flights_jfxtemplate;
}