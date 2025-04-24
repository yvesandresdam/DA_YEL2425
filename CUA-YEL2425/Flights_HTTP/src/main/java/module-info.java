module andres.testing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens andres.testing to javafx.fxml;
    exports andres.testing;
}