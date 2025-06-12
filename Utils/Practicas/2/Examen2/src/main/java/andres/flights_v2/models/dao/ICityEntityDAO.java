package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.CityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityEntityDAO extends CrudRepository<CityEntity, String> {
    CityEntity getCityWithCode(@Param ("codigoCiudad") String code);
    List<CityEntity> getAllCities();
}
