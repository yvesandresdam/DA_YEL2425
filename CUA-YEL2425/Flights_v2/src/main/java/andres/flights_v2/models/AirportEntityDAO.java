package andres.flights_v2.models;

import andres.flights_v2.entities.AirportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportEntityDAO extends CrudRepository<AirportEntity,String> {
    Optional<AirportEntity> findAirportByCode(String code);
    Optional<AirportEntity> findAirportByCity(String city);
}
