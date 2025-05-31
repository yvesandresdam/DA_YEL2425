package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.FlightEntity;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Interfaz para acceder a los vuelos en la base de datos.
 *
 * Esta interfaz extiende CrudRepository y permite realizar operaciones básicas
 * como guardar, buscar, actualizar y eliminar tickets (TicketEntity).
 *
 */
@Repository
public interface ITicketEntityDAO extends CrudRepository<TicketEntity, Integer> {
    TicketEntity getTicketEntityById(Integer id);

    // PostgreSQL Functions -
    Boolean checkTicketExists(@Param("travelDate") LocalDate travelDate,
                              @Param("passportNo") String passportNo);
    PassengerEntity findPassengerByPassportno(String passportno);
    FlightEntity findFlightByFlightCode(String flightCode);
}
