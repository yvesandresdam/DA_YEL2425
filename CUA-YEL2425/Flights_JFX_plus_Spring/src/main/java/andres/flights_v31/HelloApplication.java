package andres.flights_v31;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import javafx.application.Application;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class HelloApplication extends Application {


    private ApplicationContext springContext;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("flights-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        FlightController controller = springContext.getBean(FlightController.class);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        // Inicia Spring
        springContext = SpringApplication.run(FlightApp.class);
    }

    public static void main(String[] args) {
        launch();
    }
}