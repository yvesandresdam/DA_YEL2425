package andres.flights_v2.controllers;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.models.dao.IFlightsEntityDAO;
import andres.flights_v2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    // Gets all Airport 'origins'
    @GetMapping("/Origins")
    public List<AirportEntity> findAllFlights() {
        return flightService.findAllOrigins();
    }

    // Gets all 'destinations' with an airport 'origin'
    @GetMapping("/Destinations/{originId}")
    public ResponseEntity<?> findDestinationsByOrigin(@PathVariable String originId) {
        // VALIDATION - CONTROLLER LAYER
        // is originID valid_
        if (originId == null || originId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "OriginId is mandatory."));
        }
        if (originId.length() > 4) {
            return ResponseEntity.badRequest().body(Map.of("error", "OriginId must be less than 4 characters."));
        }

        // return response
        List<AirportEntity> flightDestinations = flightService.findDestinationsByOrigin(originId);
        return ResponseEntity.ok(flightDestinations);
    }

    // Gets the 'flight_code' with an origin and destination
    @GetMapping("/{originId}/{destinationId}")
    public ResponseEntity<?> findFlightCodeByRoute(
            @PathVariable String originId,
            @PathVariable String destinationId) {
        // VALIDATION - CONTROLLER LAYER
        // is originID valid_
        if (originId == null || originId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "OriginId is mandatory."));
        }
        if (originId.length() > 4) {
            return ResponseEntity.badRequest().body(Map.of("error", "OriginId must be less than 4 characters."));
        }
        // is destinationId valid_
        if (destinationId == null || destinationId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "DestinationId is mandatory."));
        }
        if (destinationId.length() > 4) {
            return ResponseEntity.badRequest().body(Map.of("error", "DestinationId must be less than 4 characters."));
        }

        // return response
        Optional<String> flightCode = flightService.findFlightCodeByRoute(originId, destinationId);
        return ResponseEntity.ok(flightCode.get());
    }

    // Same functionality with query parameters
    @GetMapping("/FlightCode-for")
    public ResponseEntity<?> findFlightCodeByRouteALT(
            @RequestParam("originId") String originId,
            @RequestParam("destinationId") String destinationId) {
        // VALIDATION - CONTROLLER LAYER
        // is originID valid_
        if (originId == null || originId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "OriginId is mandatory."));
        }
        if (originId.length() > 4) {
            return ResponseEntity.badRequest().body(Map.of("error", "OriginId must be less than 4 characters."));
        }
        // is destinationId valid_
        if (destinationId == null || destinationId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "DestinationId is mandatory."));
        }
        if (destinationId.length() > 4) {
            return ResponseEntity.badRequest().body(Map.of("error", "DestinationId must be less than 4 characters."));
        }

        // return response
        Optional<String> flightCode = flightService.findFlightCodeByRoute(originId, destinationId);
        return ResponseEntity.ok(flightCode.get());
    }

    // Endpoint to verify seats availability for a flight
    @GetMapping("/Available/{flight_code}")
    public ResponseEntity<?> checkSeatAvailability(@PathVariable String flight_code) {
        // VALIDATION - CONTROLLER LAYER
        // is flight_code valid_
        if (flight_code == null || flight_code.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "FlightCode is mandatory."));
        }
        if (flight_code.length() > 10) {
            return ResponseEntity.badRequest().body(Map.of("error", "FlightCode must be less than 10 characters."));
        }

        // return response
        boolean seatsAvailable = flightService.areSeatsAvailable(flight_code);
        return ResponseEntity.ok(seatsAvailable);
    }

    // Same functionality with query parameters
    @GetMapping("/Available-for")
    public ResponseEntity<?> checkSeatAvailabilityALT(@RequestParam("code") String flight_code) {
        // VALIDATION - CONTROLLER LAYER
        // is code valid_
        if (flight_code == null || flight_code.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "FlightCode is mandatory."));
        }
        if (flight_code.length() > 10) {
            return ResponseEntity.badRequest().body(Map.of("error", "FlightCode must be less than 10 characters."));
        }

        // return response
        boolean seatsAvailable = flightService.areSeatsAvailable(flight_code);
        return ResponseEntity.ok(seatsAvailable);
    }
}

