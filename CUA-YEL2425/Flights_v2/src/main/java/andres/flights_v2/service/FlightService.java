package andres.flights_v2.service;

import andres.flights_v2.models.dao.IFlightsEntityDAO;
import andres.flights_v2.models.entities.AirportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return flightDAO.findDestinationsByOrigin(originCode);
    }
    public Optional<String> findFlightCodeByRoute(String origin, String destination) {
        return flightDAO.findFlightCodeByRoute(origin, destination);
    }

    // This Methods calls the stored procedures at the postrgesql DB
    // Number of available seats
    public Integer countSeatsAvailable(String flightCode) {
        Integer number = flightDAO.countSeatNumber(flightCode);
        return number;
    }
    // Boolean with available seats
    public boolean areSeatsAvailable(String flightCode) {
        Boolean available = flightDAO.checkSeatAvailability(flightCode);
        return available != null && available;
    }
}

