package andres.flights_v3.repositories;

import andres.flights_v3.entities.AirportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAirportRepository extends CrudRepository<AirportEntity, String> {

}
