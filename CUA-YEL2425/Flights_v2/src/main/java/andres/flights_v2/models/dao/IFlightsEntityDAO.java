package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.models.entities.FlightEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IFlightsEntityDAO extends CrudRepository<FlightEntity, String> {

    List<AirportEntity> findAllOrigins();

    List<AirportEntity> findDestinationsByOrigin(@Param("originId") String originId);

    List<String> findFlightCodeByRoute(@Param("originId") String originId, @Param("destinationId") String destinationId);

    // PostgreSQL Function call
    Integer countSeatNumber(@Param("flightCode") String flightCode);

    Boolean checkSeatAvailability(@Param("flightCode") String flightCode, @Param("dateOfTravel") LocalDate dateOfTravel);
}

