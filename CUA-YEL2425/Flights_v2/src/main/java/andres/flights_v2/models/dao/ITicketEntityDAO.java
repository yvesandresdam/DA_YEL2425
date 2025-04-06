package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ITicketEntityDAO extends CrudRepository<TicketEntity,Integer> {
    // Named Query_ function returns true if passenger has already bought a ticket
    @Query(value = "SELECT yveeli_03_ticket_already_exists(:travelDate, :passportNo)", nativeQuery = true)
    Boolean checkTicketExists(@Param("travelDate") LocalDate travelDate,
                              @Param("passportNo") String passportNo);
}
