package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.FlightEntity;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ITicketEntityDAO extends CrudRepository<TicketEntity, Integer> {

    // Funcion que cancela un ticket
    // Requiere un parametro de PASAPORTE y de FECHA
    TicketEntity cancelSingleTicket(@Param("cancelPassport") String passportNo,
                                  @Param("dateTravel") LocalDate travelDate);

    // Funciones JPA
    TicketEntity getTicketEntityById(Integer id);
    // PostgreSQL Functions -
    Boolean checkTicketExists(@Param("travelDate") LocalDate travelDate,
                              @Param("passportNo") String passportNo);
    PassengerEntity findPassengerByPassportno(String passportno);
    FlightEntity findFlightByFlightCode(String flightCode);
}
