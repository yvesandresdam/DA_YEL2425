package andres.flights_v2.controllers;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.models.dao.IFlightsEntityDAO;
import andres.flights_v2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// Controller showing data info about entity 'Flights'.
// The endpoints are managed with the 'flightService' class.

@RestController
@RequestMapping("/Flights")
public class FlightsController {
    @Autowired
    private FlightService flightService;

    // Endpoint para verificar la disponibilidad de asientos en un vuelo
    @GetMapping("/{flight_code}/Available")
    public ResponseEntity<Boolean> checkSeatAvailability(@PathVariable String flight_code) {
        boolean seatsAvailable = flightService.areSeatsAvailable(flight_code);
        return ResponseEntity.ok(seatsAvailable);
    }

    // Devuelve todos los aeropuertos de ORIGEN
    @GetMapping("/Origin")
    public List<AirportEntity> findAllFlights() {
        return flightService.findAllOrigins();
    }

    // Obtiene los DESTINOS disponibles desde un ORIGEN específico
    @GetMapping("/Destinations/{originId}")
    public List<AirportEntity> findDestinationsByOrigin(@PathVariable String originId) {
        return flightService.findDestinationsByOrigin(originId);
    }

    // Obtiene el CODIGO de un vuelo con un ORIGEN y un DESTINO
    @GetMapping("/{originId}/{destinationId}")
    public ResponseEntity<String> findFlightCodeByRoute(
            @PathVariable String originId,
            @PathVariable String destinationId) {
        Optional<String> flightCode = flightService.findFlightCodeByRoute(originId, destinationId);
        return ResponseEntity.ok(flightCode.get());
    }
}


/*

package andres.flights_v2.controllers;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.models.dao.IFlightsEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// Controlador que muestra los datos de la Entidad 'Flights'
// Se gestiona mediante un objeto 'flightsDAO'

@RestController
@RequestMapping("/Flights")
public class FlightsController {
    @Autowired
    private IFlightsEntityDAO flightsDAO;

    // Devuelve todos los aeropuertos de ORIGEN
    @GetMapping("/Origin")
    public List<AirportEntity> findAllFlights() {
        return (List<AirportEntity>) flightsDAO.findAll();
    }

    // Obtiene los DESTINOS disponibles desde un ORIGEN específico
    @GetMapping("/Destinations/{originId}")
    public List<AirportEntity> findDestinationsByOrigin(@PathVariable String originId) {
        return flightsDAO.findDestinationsByOrigin(originId);
    }

    // Obtiene el CODIGO de un vuelo con un ORIGEN y un DESTINO
    @GetMapping("/{originId}/{destinationId}")
    public ResponseEntity<String> findFlightCodeByRoute(
            @PathVariable String originId,
            @PathVariable String destinationId) {
        Optional<String> flightCode = flightsDAO.findFlightCodeByRoute(originId, destinationId);
        return ResponseEntity.ok(flightCode.get());
    }
}


 */

