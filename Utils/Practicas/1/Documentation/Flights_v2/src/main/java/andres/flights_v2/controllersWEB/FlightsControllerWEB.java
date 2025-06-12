package andres.flights_v2.controllersWEB;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controlador MVC para la gestión de vuelos desde la interfaz web.
 * Proporciona endpoints que devuelven datos en formato JSON para ser consumidos por la interfaz.
 */
@Controller
@RequestMapping("/Web/Flights")
public class FlightsControllerWEB {
    @Autowired
    private FlightService flightService;

    /**
     * Endpoint: Devuelve todos los orígenes posibles.
     *
     * @return Lista de AirportEntity con todos los aeropuertos de origen disponibles.
     */
    @GetMapping("/Origins")
    @ResponseBody
    public List<AirportEntity> findOrigins() {
        return flightService.findAllOrigins();
    }

    /**
     * Endpoint: Devuelve todos los destinos para un origen dado.
     *
     * @param originId Código o id del aeropuerto de origen.
     * @return Lista de AirportEntity con los destinos asociados al origen.
     */
    @GetMapping("/Destinations/{originId}")
    @ResponseBody
    public List<AirportEntity> findDestinationsByOrigin(@PathVariable String originId) {
        return flightService.findDestinationsByOrigin(originId);
    }

    /**
     * Devuelve una lista de códigos de vuelo para un origen y un destino específicos.
     *
     * @param originId Código o id del aeropuerto de origen.
     * @param destinationId Código o id del aeropuerto de destino.
     * @return Lista de Strings con los códigos de vuelo que cubren la ruta.
     */
    @GetMapping("/{originId}/{destinationId}")
    @ResponseBody
    public List<String> findFlightCodeByRoute(@PathVariable String originId,
                                              @PathVariable String destinationId) {
        return flightService.findFlightCodeByRoute(originId, destinationId);
    }
}
