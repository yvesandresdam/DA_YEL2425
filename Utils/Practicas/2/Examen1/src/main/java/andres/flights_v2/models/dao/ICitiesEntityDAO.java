package andres.flights_v2.models.dao;

import andres.flights_v2.models.entities.CityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICitiesEntityDAO extends CrudRepository<CityEntity, String> {
    List<CityEntity> findAll();
    List<CityEntity> getCityWithCode(@Param("codigo") String codigo);
    List<String> getAllCodes();
    List<String> getParcialCityWithCode(@Param("ciudadCodigo") String ciudadCodigo);
}
