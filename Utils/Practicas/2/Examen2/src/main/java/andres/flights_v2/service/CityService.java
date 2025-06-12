package andres.flights_v2.service;

import andres.flights_v2.models.dao.ICityEntityDAO;
import andres.flights_v2.models.entities.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    public ICityEntityDAO cityEntity;

    public CityEntity getCityWithCode(String code){
        return cityEntity.getCityWithCode(code);
    }
    public List<CityEntity> getAllCities(){return cityEntity.getAllCities();}
}
