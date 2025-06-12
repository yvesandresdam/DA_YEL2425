package andres.flights_v3.services;

import andres.flights_v3.entities.AirportEntity;
import andres.flights_v3.entities.CityEntity;
import andres.flights_v3.repositories.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    public IFlightRepository flightRepository;

    public List<AirportEntity> getAllSources(){
        return flightRepository.getAllSources();
    }

    public CityEntity getCityWithCode(String code){
        return flightRepository.getCityWithCode(code);
    }

}
