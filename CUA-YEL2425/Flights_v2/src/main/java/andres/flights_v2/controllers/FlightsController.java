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
    public List<AirportEntity> findDestinationsByOrigin(@PathVariable String originId) {
        return flightService.findDestinationsByOrigin(originId);
    }

    @GetMapping("/{originId}/{destinationId}")
    public List<String> findFlightCodeByRoute(@PathVariable String originId,
                                                   @PathVariable String destinationId) {
        return flightService.findFlightCodeByRoute(originId, destinationId);
    }

    // DB functions call
    @GetMapping("/Available/{flight_code}/{flight_date}")
    public Boolean checkSeatAvailability(@PathVariable String flight_code, @PathVariable LocalDate flight_date) {
        return flightService.areSeatsAvailable(flight_code, flight_date);
    }
}

