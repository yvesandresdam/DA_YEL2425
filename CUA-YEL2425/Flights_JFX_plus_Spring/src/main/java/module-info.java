module andres.flights_v31 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires spring.data.commons;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;


    opens andres.flights_v31 to javafx.fxml;
    exports andres.flights_v31;
}