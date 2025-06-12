package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.models.entities.FlightEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz para acceder a los vuelos en la base de datos.
 *
 * Esta interfaz extiende CrudRepository y permite realizar operaciones básicas
 * como guardar, buscar, actualizar y eliminar vuelo (FlightEntity).
 *
 */

@Repository
public interface IFlightsEntityDAO extends CrudRepository<FlightEntity, String> {

    List<AirportEntity> findAllOrigins();
    List<AirportEntity> findDestinationsByOrigin(@Param("originId") String originId);
    List<String> findFlightCodeByRoute(@Param("originId") String originId, @Param("destinationId") String destinationId);

    // PostgreSQL Functions -
    Integer countSeatNumber(@Param("flightCode") String flightCode);
    Boolean checkSeatAvailability(@Param("flightCode") String flightCode, @Param("dateOfTravel") LocalDate dateOfTravel);
}

