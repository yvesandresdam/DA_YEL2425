package andres.flights_v2.controllers;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador REST para gestionar las operaciones relacionadas con vuelos.
 * Proporciona endpoints para obtener orígenes, destinos, códigos de vuelo
 * y disponibilidad de asientos.
 */
@RestController
@RequestMapping("/Flights")
public class FlightsController {

    @Autowired
    private FlightService flightService;

    /**
     * Endpoint: Devuelve todos los orígenes.
     *
     * @return Lista de AirportEntity con todos los aeropuertos de origen.
     */
    @GetMapping("/Origins")
    public List<AirportEntity> findAllFlights() {
        return flightService.findAllOrigins();
    }

    /**
     * Endpoint: Devuelve todos los destinos para un origen.
     *
     * @param originId Código del aeropuerto de origen.
     * @return Lista de AirportEntity con destinos disponibles desde el origen.
     */
    @GetMapping("/Destinations/{originId}")
    public List<AirportEntity> findDestinationsByOrigin(@PathVariable String originId) {
        return flightService.findDestinationsByOrigin(originId);
    }

    /**
     * Endpoint: Devuelve todos los códigos de vuelo para una ruta específica (origen y destino).
     *
     * @param originId Código del aeropuerto de origen.
     * @param destinationId Código del aeropuerto de destino.
     * @return Lista de cadenas con los códigos de vuelo disponibles.
     */
    @GetMapping("/{originId}/{destinationId}")
    public List<String> findFlightCodeByRoute(@PathVariable String originId,
                                              @PathVariable String destinationId) {
        return flightService.findFlightCodeByRoute(originId, destinationId);
    }

    /**
     * Endpoint: Devuelve un booleano indicando si hay asientos disponibles
     * para un vuelo en una fecha determinada.
     *
     * @param flight_code Código del vuelo.
     * @param flight_date Fecha del vuelo.
     * @return true si hay asientos disponibles; false en caso contrario.
     */
    @GetMapping("/Available/{flight_code}/{flight_date}")
    public Boolean checkSeatAvailability(@PathVariable String flight_code, @PathVariable LocalDate flight_date) {
        return flightService.areSeatsAvailable(flight_code, flight_date);
    }
}
