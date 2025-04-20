package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.FlightEntity;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ITicketEntityDAO extends CrudRepository<TicketEntity, Integer> {
    TicketEntity getTicketEntityById(Integer id);

    // PostgreSQL Functions calls
    // Function that check if user has bought a ticket already
    Boolean checkTicketExists(@Param("travelDate") LocalDate travelDate,
                              @Param("passportNo") String passportNo);

    PassengerEntity findPassengerByPassportno(String passportno);
    FlightEntity findFlightByFlightCode(String flightCode);
}
