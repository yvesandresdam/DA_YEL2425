package andres.flights_v2.service;

import andres.flights_v2.models.dao.IFlightsEntityDAO;
import andres.flights_v2.models.dto.FlightDTO;
import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.models.entities.FlightEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private IFlightsEntityDAO flightDAO;
    private JdbcTemplate jdbcTemplate;

    public FlightService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean areSeatsAvailable(String flightCode) {
        // Llamamos a la función PL/pgSQL y obtenemos el resultado
        String sql = "SELECT yveeli_02_available_seats_bool(?)";

        Boolean available = jdbcTemplate.queryForObject(sql, Boolean.class, flightCode);
        return available != null && available;
    }

    public List<AirportEntity> findAllOrigins() {
        return flightDAO.findAllOrigins();
    }

    public List<AirportEntity> findDestinationsByOrigin(String originCode) {
        return flightDAO.findDestinationsByOrigin(originCode);
    }

    public Optional<String> findFlightCodeByRoute(String origin, String destination) {
        return flightDAO.findFlightCodeByRoute(origin, destination);
    }
}
/*
    private FlightDTO mapToDTO(FlightEntity entity) {
        return new FlightDTO(
                entity.getFlightCode(),
                entity.getSource().getCode(),
                entity.getDestination().getCode(),
                entity.getArrival(),
                entity.getDeparture(),
                entity.getStatus(),
                entity.getDuration(),
                entity.getFlightType(),
                entity.getLayoverTime(),
                entity.getNoOfStops(),
                entity.getSeats()
        );
    }
}


//    public Optional<FlightDTO> findFlightByCode(String flightCode) {
//        return flightDAO.findById(flightCode).map(this::mapToDTO);
//    }

//    public List<AirportEntity> findAllOrigins() {
//        return flightDAO.findAll();
//    }

    @Autowired
    private JdbcTemplate jdbcTemplate; // Usamos JdbcTemplate para llamar a la función

    // Método para llamar a la función PL/pgSQL y verificar la disponibilidad de asientos

     */

