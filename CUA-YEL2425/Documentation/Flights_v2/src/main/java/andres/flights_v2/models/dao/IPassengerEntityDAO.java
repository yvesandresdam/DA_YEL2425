package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.PassengerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interfaz para acceder a los vuelos en la base de datos.
 *
 * Esta interfaz extiende CrudRepository y permite realizar operaciones básicas
 * como guardar, buscar, actualizar y eliminar pasajeros (PassengerEntity).
 *
 */

@Repository
public interface IPassengerEntityDAO extends CrudRepository<PassengerEntity, String> {
    PassengerEntity findByPassportno(String passport);
}
