package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.models.entities.FlightEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirportsEntityDAO extends CrudRepository<FlightEntity, String> {

}

