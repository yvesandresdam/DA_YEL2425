package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketEntityDAO extends CrudRepository<TicketEntity,Integer> {
}
