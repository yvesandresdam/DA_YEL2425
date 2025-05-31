package andres.flights_v2.service;

import andres.flights_v2.models.dao.IFlightsEntityDAO;
import andres.flights_v2.models.entities.AirportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio que gestiona la lógica relacionada con los vuelos.
 *
 * Esta clase actúa como intermediaria entre el controlador y la capa de acceso a datos (DAO).
 * Se encarga de validar los datos y ejecutar métodos específicos como buscar rutas y consultar disponibilidad de asientos.
 */
@Service
public class FlightService {

    @Autowired
    private IFlightsEntityDAO flightDAO;

    /**
     * Obtiene una lista de todos los aeropuertos de origen disponibles.
     *
     * @return lista de aeropuertos de origen.
     */
    public List<AirportEntity> findAllOrigins() {
        return flightDAO.findAllOrigins();
    }

    /**
     * Busca los destinos posibles desde un aeropuerto de origen.
     *
     * @param originCode código del aeropuerto de origen.
     * @return lista de aeropuertos destino.
     */
    public List<AirportEntity> findDestinationsByOrigin(String originCode) {
        return flightDAO.findDestinationsByOrigin(originCode);
    }

    /**
     * Obtiene los códigos de vuelo disponibles entre dos aeropuertos.
     *
     * @param origin código del aeropuerto de origen.
     * @param destination código del aeropuerto de destino.
     * @return lista de códigos de vuelo.
     */
    public List<String> findFlightCodeByRoute(String origin, String destination) {
        return flightDAO.findFlightCodeByRoute(origin, destination);
    }

    /**
     * Valida el código de aeropuerto recibido.
     *
     * @param code código a validar.
     * @param fieldName nombre del campo para mostrar en errores.
     */
    private void validateAirportCode(String code, String fieldName) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is mandatory.");
        }
        if (code.length() > 4) {
            throw new IllegalArgumentException(fieldName + " must be less than 4 characters.");
        }
    }

    /**
     * Valida el código de vuelo recibido.
     *
     * @param flightCode código de vuelo a validar.
     */
    private void validateFlightCode(String flightCode) {
        if (flightCode == null || flightCode.trim().isEmpty()) {
            throw new IllegalArgumentException("FlightCode is mandatory.");
        }
        if (flightCode.length() > 10) {
            throw new IllegalArgumentException("FlightCode must be less than 10 characters.");
        }
    }

    /**
     * Consulta el número de asientos disponibles para un vuelo.
     *
     * @param flightCode código del vuelo.
     * @return número de asientos disponibles.
     */
    public Integer countSeatsAvailable(String flightCode) {
        validateFlightCode(flightCode);
        return flightDAO.countSeatNumber(flightCode);
    }

    /**
     * Verifica si hay asientos disponibles para un vuelo en una fecha específica.
     *
     * @param flightCode código del vuelo.
     * @param flightDate fecha del vuelo.
     * @return true si hay asientos disponibles, false si no.
     */
    public boolean areSeatsAvailable(String flightCode, LocalDate flightDate) {
        validateFlightCode(flightCode);
        return flightDAO.checkSeatAvailability(flightCode, flightDate);
    }
}
