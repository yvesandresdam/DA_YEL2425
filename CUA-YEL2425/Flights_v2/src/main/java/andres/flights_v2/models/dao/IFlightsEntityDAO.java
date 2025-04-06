package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.models.entities.FlightEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFlightsEntityDAO extends CrudRepository<FlightEntity, String> {

    @Query("SELECT DISTINCT f.source FROM FlightEntity f")
    List<AirportEntity> findAllOrigins();

    @Query("SELECT f.destination FROM FlightEntity f WHERE f.source.code = :originId")
    List<AirportEntity> findDestinationsByOrigin(@Param("originId") String originId);

    @Query("SELECT f.flightCode FROM FlightEntity f WHERE f.source.code = :originId AND f.destination.code = :destinationId")
    Optional<String> findFlightCodeByRoute(@Param("originId") String originId, @Param("destinationId") String destinationId);

    @Query(value = "SELECT yveeli_01_available_seats_int(:flightCode)", nativeQuery = true)
    Integer countSeatNumber(@Param("flightCode") String flightCode);

    @Query(value = "SELECT yveeli_02_available_seats_bool(:flightCode)", nativeQuery = true)
    Boolean checkSeatAvailability(@Param("flightCode") String flightCode);
}

