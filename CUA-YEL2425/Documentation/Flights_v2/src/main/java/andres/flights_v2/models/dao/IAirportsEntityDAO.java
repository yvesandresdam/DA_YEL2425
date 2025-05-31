package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.AirportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz para acceder a los vuelos en la base de datos.
 *
 * Esta interfaz extiende CrudRepository y permite realizar operaciones básicas
 * como guardar, buscar, actualizar y eliminar aeropuertos (AirportEntity).
 *
 */

@Repository
public interface IAirportsEntityDAO extends CrudRepository<AirportEntity, String> {
}

