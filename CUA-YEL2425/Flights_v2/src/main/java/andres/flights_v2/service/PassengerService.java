package andres.flights_v2.service;

import andres.flights_v2.models.dao.IPassengerEntityDAO;
import andres.flights_v2.models.dto.PassengerDTO;
import andres.flights_v2.models.entities.PassengerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private IPassengerEntityDAO passengerDAO;

    public Optional<PassengerDTO> findPassengerByPassport(String passport) {
        Optional<PassengerEntity> passengerEntity = passengerDAO.findByPassportno(passport);
        return passengerEntity
                .map(entity ->
                new PassengerDTO(entity.getPassportno(), entity.getFirstname(), entity.getLastname(), entity.getPhone(),entity.getSex())
        );
    }
}

