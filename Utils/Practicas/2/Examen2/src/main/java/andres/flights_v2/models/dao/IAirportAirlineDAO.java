package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.AirlineEntity;
import andres.flights_v2.models.entities.AirportAirline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAirportAirlineDAO extends CrudRepository<AirportAirline, Integer> {
    List<String> getAirlineCodeWithAirportCode(@Param("airportCode") String airportCode);
}
