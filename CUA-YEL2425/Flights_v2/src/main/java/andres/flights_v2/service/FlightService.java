package andres.flights_v2.service;

import andres.flights_v2.models.dao.IFlightsEntityDAO;
import andres.flights_v2.models.entities.AirportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private IFlightsEntityDAO flightDAO;

    public List<AirportEntity> findAllOrigins() {
        return flightDAO.findAllOrigins();
    }
    public List<AirportEntity> findDestinationsByOrigin(String originCode) {
        //validateAirportCode(originCode, "OriginId");
        return flightDAO.findDestinationsByOrigin(originCode);
    }
    public List<String> findFlightCodeByRoute(String origin, String destination) {
        //validateAirportCode(origin, "OriginId");
        //validateAirportCode(destination, "DestinationId");
        return flightDAO.findFlightCodeByRoute(origin, destination);
    }

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
        Integer number = flightDAO.countSeatNumber(flightCode);
        return number;
    }
    // Boolean with available seats
    public boolean areSeatsAvailable(String flightCode, LocalDate dateOfFlight) {
        validateFlightCode(flightCode);
        Boolean available = flightDAO.checkSeatAvailability(flightCode, dateOfFlight);
        return available != null && available;
    }
}
