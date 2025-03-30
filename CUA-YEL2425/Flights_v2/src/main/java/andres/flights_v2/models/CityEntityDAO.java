package andres.flights_v2.models;

import andres.flights_v2.entities.CityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityEntityDAO extends CrudRepository<CityEntity, String> {
    List<CityEntity> findByCountry(String country);
    Optional<CityEntity> findByName(String name);
    List<CityEntity> findByState(String state);
}



