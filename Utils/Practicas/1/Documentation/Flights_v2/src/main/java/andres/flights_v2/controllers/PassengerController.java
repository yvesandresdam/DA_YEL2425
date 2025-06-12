package andres.flights_v2.controllers;

import andres.flights_v2.dto.PassengerDTO;
import andres.flights_v2.models.entities.PassengerEntity;
import andres.flights_v2.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar pasajeros.
 * Permite crear nuevos pasajeros y buscar pasajeros por número de pasaporte.
 */
@RestController
@RequestMapping("/Passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    /**
     * Endpoint: POST, Requiere un objeto DTO Passenger para crear un pasajero nuevo.
     *
     * @param passengerDTO Objeto PassengerDTO con los datos del pasajero a crear.
     * @return true si la creación fue exitosa, false en caso contrario.
     */
    @PostMapping("/CreateNewPassenger")
    public boolean createNewPassenger(@RequestBody PassengerDTO passengerDTO) {
        return passengerService.createPassenger(passengerDTO);
    }

    /**
     * Endpoint: Devuelve un objeto pasajero para un pasaporte dado.
     *
     * @param passportno Número de pasaporte del pasajero a buscar.
     * @return PassengerEntity con los datos del pasajero encontrado.
     */
    @GetMapping("/Passport/{passportno}")
    public PassengerEntity findPassengerByPassport(@PathVariable String passportno) {
        return passengerService.findPassengerByPassport(passportno);
    }

}
