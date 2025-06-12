package andres.flights_v2.service;

import andres.flights_v2.models.dao.IFlightsEntityDAO;
import andres.flights_v2.models.entities.AirportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private IFlightsEntityDAO flightDAO;


    // @Navegar desde Aqui
    public List<AirportEntity> findAllOrigins() {
        return flightDAO.findAllOrigins();
    }
    public List<AirportEntity> findDestinationsByOrigin(String originCode) {
        return flightDAO.findDestinationsByOrigin(originCode);
    }
    public List<String> findFlightCodeByRoute(String origin, String destination) {
        return flightDAO.findFlightCodeByRoute(origin, destination);
    }

    // VALIDATING FUNCTIONS - SERVICE LAYER -
    private void validateAirportCode(String code, String fieldName) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is mandatory.");
        }
        if (code.length() > 4) {
            throw new IllegalArgumentException(fieldName + " must be less than 4 characters.");
        }
    }
    private void validateFlightCode(String flightCode) {
        if (flightCode == null || flightCode.trim().isEmpty()) {
            throw new IllegalArgumentException("FlightCode is mandatory.");
        }
        if (flightCode.length() > 10) {
            throw new IllegalArgumentException("FlightCode must be less than 10 characters.");
        }
    }

    // STORED PROCEDURES - SERVICE LAYER -
    // Number of available seats
    public Integer countSeatsAvailable(String flightCode) {
        validateFlightCode(flightCode);
        return flightDAO.countSeatNumber(flightCode);
    }

    // @Navegar hasta aqui
    // Boolean if there are available seats
    public boolean areSeatsAvailable(String flightCode, LocalDate flightDate) {
        validateFlightCode(flightCode);
        return flightDAO.checkSeatAvailability(flightCode, flightDate);
    }
}
