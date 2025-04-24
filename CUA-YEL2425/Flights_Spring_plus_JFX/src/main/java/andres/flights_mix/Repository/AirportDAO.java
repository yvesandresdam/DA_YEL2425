package andres.flights_mix.Repository;

import andres.flights_mix.Models.AirportEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirportDAO extends CrudRepository<AirportEntity, String> {
    List<String> findAllNames();
}
