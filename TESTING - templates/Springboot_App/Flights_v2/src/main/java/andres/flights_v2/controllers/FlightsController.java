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

@RestController
@RequestMapping("/Flights")
public class FlightsController {
    @Autowired
    private FlightService flightService;

    // Endpoint: Devuelve todos los origenes
    @GetMapping("/Origins")
    public List<AirportEntity> findAllFlights() {
        return flightService.findAllOrigins();
    }

    // Endpoint: Devuelve todos los destinos para un origen
    @GetMapping("/Destinations/{originId}")
    public List<AirportEntity> findDestinationsByOrigin(@PathVariable String originId) {
        return flightService.findDestinationsByOrigin(originId);
    }

    // Endpoint: Devuelve todos los vuelos para un origen y un destino
    @GetMapping("/{originId}/{destinationId}")
    public List<String> findFlightCodeByRoute(@PathVariable String originId,
                                                   @PathVariable String destinationId) {
        return flightService.findFlightCodeByRoute(originId, destinationId);
    }

    // Endpoint: Devuelve un booleano si hay asientos disponibles
    @GetMapping("/Available/{flight_code}/{flight_date}")
    public Boolean checkSeatAvailability(@PathVariable String flight_code, @PathVariable LocalDate flight_date) {
        return flightService.areSeatsAvailable(flight_code, flight_date);
    }
}

