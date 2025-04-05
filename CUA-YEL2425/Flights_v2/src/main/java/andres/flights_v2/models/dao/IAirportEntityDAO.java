package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.AirportEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAirportEntityDAO extends CrudRepository<AirportEntity,String> {
    @Query("SELECT DISTINCT f.source FROM FlightEntity f")
    List<AirportEntity> findAllOrigins();

    @Query("SELECT DISTINCT f.destination FROM FlightEntity f WHERE f.source.code = :originCode")
    List<AirportEntity> findDestinationsByOrigin(String originCode);

    @Query("SELECT f.flightCode FROM FlightEntity f WHERE f.source.code = :origin AND f.destination.code = :destination")
    Optional<String> findFlightCodeByRoute(String origin, String destination);
}
