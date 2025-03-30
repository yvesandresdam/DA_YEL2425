package andres.flights_v2.models;

import andres.flights_v2.entities.CityEntity;
import andres.flights_v2.entities.PassengerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerEntityDAO extends CrudRepository<PassengerEntity, String> {
    Optional<PassengerEntity> findByPassportno(String passport);
    Optional<PassengerEntity> findByFirstname(String name);
    Optional<PassengerEntity> findByPhone(String phone);
}
