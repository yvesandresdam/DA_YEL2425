package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.AirlineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirlineEntityDAO extends CrudRepository<AirlineEntity, String> {
}
