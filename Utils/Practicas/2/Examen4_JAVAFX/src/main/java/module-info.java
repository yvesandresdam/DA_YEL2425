module andres.flights_jfxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens andres.flights_jfxtemplate to javafx.fxml;
    exports andres.flights_jfxtemplate;
}