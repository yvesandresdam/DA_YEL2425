package andres.flights_v2.service;

import andres.flights_v2.models.dao.IAirportAirlineDAO;
import andres.flights_v2.models.entities.AirlineEntity;
import andres.flights_v2.models.entities.AirportAirline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportAirlineService {
    @Autowired
    public IAirportAirlineDAO airportAirline;

    public List<String> getAirlineWithCode(String code) {
        return airportAirline.getAirlineCodeWithAirportCode(code);
    }
}
