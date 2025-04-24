package andres.flights_mix.Service;

import andres.flights_mix.Models.AirportEntity;
import andres.flights_mix.Repository.AirportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    AirportDAO airportDAO;

    public List<String> findAllNames() {
       return airportDAO.findAllNames();
    }
}
