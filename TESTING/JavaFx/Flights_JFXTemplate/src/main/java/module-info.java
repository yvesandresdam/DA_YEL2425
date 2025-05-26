module andres.flights_jfxtemplate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires org.json;


    opens andres.flights_jfxtemplate to javafx.fxml;
    opens andres.flights_jfxtemplate.Controller to javafx.fxml;
    exports andres.flights_jfxtemplate;
}