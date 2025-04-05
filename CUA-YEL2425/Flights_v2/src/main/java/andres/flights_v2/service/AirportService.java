package andres.flights_v2.service;

import andres.flights_v2.models.dao.IAirportEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    @Autowired
    private IAirportEntityDAO airportDAO;
//
//    public Optional<AirportDTO> findAirportByCode(String code) {
//        Optional<AirportEntity> airportEntity = airportDAO.findById(code);
//
//        return airportEntity.map(entity ->
//                new AirportDTO(entity.getCode(), entity.getName(), entity.getCity())
//        );
//    }
}

