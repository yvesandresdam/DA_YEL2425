package andres.flights_v2.controllers;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Controller showing data info about entity 'Flights'.
// The endpoints are managed with the 'flightService' object.

@RestController
@RequestMapping("/Flights")
public class FlightsController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/Origins")
    public List<AirportEntity> findAllFlights() {
        return flightService.findAllOrigins();
    }

    @GetMapping("/Destinations/{originId}")
    public ResponseEntity<?> findDestinationsByOrigin(@PathVariable String originId) {
        try {
            List<AirportEntity> flightDestinations = flightService.findDestinationsByOrigin(originId);
            return ResponseEntity.ok(flightDestinations);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }

    @GetMapping("/{originId}/{destinationId}")
    public ResponseEntity<?> findFlightCodeByRoute(@PathVariable String originId,
                                                   @PathVariable String destinationId) {
        try {
            Optional<List<String>> flightCode = flightService.findFlightCodeByRoute(originId, destinationId);
            return ResponseEntity.ok(flightCode.orElse(new ArrayList<String>()));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }

    @GetMapping("/Available/{flight_code}/{flight_date}")
    public ResponseEntity<?> checkSeatAvailability(@PathVariable String flight_code, @PathVariable LocalDate flight_date) {
        try {
            boolean seatsAvailable = flightService.areSeatsAvailable(flight_code, flight_date);
            return ResponseEntity.ok(seatsAvailable);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}

