package andres.flights_v31;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class FlightApp {

    public static void main(String[] args) {
        SpringApplication.run(FlightApp.class, args);
    }
}
