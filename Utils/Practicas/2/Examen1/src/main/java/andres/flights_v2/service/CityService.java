package andres.flights_v2.service;

import andres.flights_v2.models.dao.ICitiesEntityDAO;
import andres.flights_v2.models.entities.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    ICitiesEntityDAO cityDAO;

    public List<CityEntity> getAllCities() {
        return cityDAO.findAll();
    }

    public List<CityEntity> getCityWithCode(String codigo) {
        return cityDAO.getCityWithCode(codigo);
    }

    public List<String> getAllCodes() {
        return cityDAO.getAllCodes();
    }

    public List<String> getParcialCityWithCode(String ciudadCodigo) {
        return cityDAO.getParcialCityWithCode(ciudadCodigo);
    }
}
