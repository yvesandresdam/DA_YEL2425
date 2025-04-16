package andres.flights_v2.service;

import andres.flights_v2.models.dao.IPassengerEntityDAO;
import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.entities.PassengerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    private IPassengerEntityDAO passengerDAO;
    public void createPassenger(PassengerDTO passengerDTO) {
        // validatePassenger(passengerDTO);
        // Convertir el DTO a una entidad
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setPassportno(passengerDTO.getPassportno());
        passengerEntity.setFirstname(passengerDTO.getFirstname());
        passengerEntity.setLastname(passengerDTO.getLastname());
        passengerEntity.setAddress(passengerDTO.getAddress());
        passengerEntity.setPhone(passengerDTO.getPhone());
        passengerEntity.setSex(passengerDTO.getSex());

        // Guardar la entidad en la base de datos usando el DAO
        passengerDAO.save(passengerEntity);
    }

    public PassengerEntity findPassengerByPassport(String passportno){
        return passengerDAO.findByPassportno(passportno);
    }

    // VALIDATING FUNCTIONS
    // SERVICE LAYER
    private void validatePassport(String passport) {
        if (passport == null || passport.trim().isEmpty()) {
            throw new IllegalArgumentException("Passport identity is mandatory.");
        }
        if (passport.length() != 8) {
            throw new IllegalArgumentException("Passport identity number must be 8 characters long.");
        }
    }
    private void validatePassenger(PassengerEntity passenger) {
        if (passenger.getFirstname() == null || passenger.getFirstname().trim().isEmpty()) {
            throw new IllegalArgumentException("First name is mandatory.");
        }

        if (passenger.getLastname() == null || passenger.getLastname().trim().isEmpty()) {
            throw new IllegalArgumentException("Last name is mandatory.");
        }
    }
}

