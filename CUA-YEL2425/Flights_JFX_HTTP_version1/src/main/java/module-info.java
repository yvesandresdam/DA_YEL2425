module andres.flights_jfxtemplate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;


    opens andres.flights_jfxtemplate to javafx.fxml;
    exports andres.flights_jfxtemplate;
    exports andres.flights_jfxtemplate.Entity;
    opens andres.flights_jfxtemplate.Entity to javafx.fxml;
    exports andres.flights_jfxtemplate.Service;
    opens andres.flights_jfxtemplate.Service to javafx.fxml;
    exports andres.flights_jfxtemplate.Controller;
    opens andres.flights_jfxtemplate.Controller to javafx.fxml;
}