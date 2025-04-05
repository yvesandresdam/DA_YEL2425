package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.PassengerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPassengerEntityDAO extends CrudRepository<PassengerEntity, String> {
    Optional<PassengerEntity> findByPassportno(String passport);
}
