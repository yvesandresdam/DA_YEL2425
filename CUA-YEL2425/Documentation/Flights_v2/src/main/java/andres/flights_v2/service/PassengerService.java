package andres.flights_v2.service;

import andres.flights_v2.models.dao.IPassengerEntityDAO;
import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.entities.PassengerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar pasajeros.
 *
 * Proporciona métodos para crear pasajeros y buscarlos por su número de pasaporte.
 * Incluye validaciones básicas para asegurar que los datos esenciales estén presentes.
 */
@Service
public class PassengerService {

    @Autowired
    private IPassengerEntityDAO passengerDAO;

    /**
     * Crea un nuevo pasajero en la base de datos a partir de un DTO.
     * Valida que los datos mínimos sean correctos antes de guardar.
     *
     * @param passengerDTO datos del pasajero a crear.
     * @return true si se guarda correctamente, false si hay error.
     */
    public boolean createPassenger(PassengerDTO passengerDTO) {
        validatePassenger(passengerDTO);

        // Convertir DTO a entidad
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setPassportno(passengerDTO.getPassportno());
        passengerEntity.setFirstname(passengerDTO.getFirstname());
        passengerEntity.setLastname(passengerDTO.getLastname());
        passengerEntity.setAddress(passengerDTO.getAddress());
        passengerEntity.setPhone(passengerDTO.getPhone());
        passengerEntity.setSex(passengerDTO.getSex());

        try {
            passengerDAO.save(passengerEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Busca un pasajero por su número de pasaporte.
     *
     * @param passportno número de pasaporte.
     * @return entidad pasajero o null si no se encuentra.
     */
    public PassengerEntity findPassengerByPassport(String passportno) {
        return passengerDAO.findByPassportno(passportno);
    }

    /**
     * Valida que los datos esenciales del pasajero estén completos.
     * Lanza excepción si falta algún dato requerido.
     *
     * @param passenger DTO con datos a validar.
     */
    private void validatePassenger(PassengerDTO passenger) {
        if (passenger.getFirstname() == null || passenger.getFirstname().trim().isEmpty()) {
            throw new IllegalArgumentException("First name is mandatory.");
        }

        if (passenger.getLastname() == null || passenger.getLastname().trim().isEmpty()) {
            throw new IllegalArgumentException("Last name is mandatory.");
        }

        if (passenger.getPassportno() == null || passenger.getPassportno().trim().isEmpty()) {
            throw new IllegalArgumentException("Passport identity is mandatory.");
        }
        if (passenger.getPassportno().length() != 8) {
            throw new IllegalArgumentException("Passport identity number must be 8 characters long.");
        }
    }
}
