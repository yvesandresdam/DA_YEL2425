module andres.flights_v3jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;


    opens andres.flights_v3jfx to javafx.fxml;
    exports andres.flights_v3jfx;
    exports andres.flights_v3jfx.controller;
    opens andres.flights_v3jfx.controller to javafx.fxml;
}