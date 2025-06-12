package andres.flights_v3.repositories;

import andres.flights_v3.entities.AirportEntity;
import andres.flights_v3.entities.CityEntity;
import andres.flights_v3.entities.FlightEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightRepository extends CrudRepository<FlightEntity, String> {
    List<AirportEntity> getAllSources();
    CityEntity getCityWithCode(@Param("cityCode") String code);
}
