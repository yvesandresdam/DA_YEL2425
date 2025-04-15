package andres.flights_v2.service;

import andres.flights_v2.models.dao.IPassengerEntityDAO;
import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.entities.PassengerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private IPassengerEntityDAO passengerDAO;

    // Functions at SERVICE LAYER -
    public PassengerDTO findPassengerByPassport(String passport) {
        PassengerEntity entity = passengerDAO.findByPassportno(passport);
        if (entity == null) {
            return null; // o lanzar una excepción si prefieres
        }
        return new PassengerDTO(
                entity.getPassportno(),
                entity.getFirstname(),
                entity.getLastname(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getSex()
        );
    }
    /* TODO
    public Optional<PassengerDTO> findPassengerByPassport(String passport) {
        Optional<PassengerEntity> passengerEntity = passengerDAO.findByPassportno(passport);
        return passengerEntity
                .map(entity ->
                        new PassengerDTO(entity.getPassportno(), entity.getFirstname(), entity.getLastname(), entity.getAddress(), entity.getPhone(), entity.getSex())
                );
    }

     */
    public void createPassenger(PassengerEntity passenger) {
        validatePassenger(passenger);
        passengerDAO.save(passenger);
    }

    // Validating Functions at SERVICE LAYER -
    private void validatePassport(String passport) {
        if (passport == null || passport.trim().isEmpty()) {
            throw new IllegalArgumentException("Passport identity is mandatory.");
        }
        if (passport.length() != 8) {
            throw new IllegalArgumentException("Passport identity number must be 8 characters long.");
        }
    }
    private void validatePassenger(PassengerEntity passenger) {
        validatePassport(passenger.getPassportno());

        if (passenger.getFirstname() == null || passenger.getFirstname().trim().isEmpty()) {
            throw new IllegalArgumentException("First name is mandatory.");
        }

        if (passenger.getLastname() == null || passenger.getLastname().trim().isEmpty()) {
            throw new IllegalArgumentException("Last name is mandatory.");
        }
    }
}

