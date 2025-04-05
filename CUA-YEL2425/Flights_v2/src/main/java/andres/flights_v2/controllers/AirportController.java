package andres.flights_v2.controllers;

import andres.flights_v2.models.entities.AirportEntity;
import andres.flights_v2.models.dao.IAirportEntityDAO;
import andres.flights_v2.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// Controller showing data info about entity 'Airport'.
// The endpoints are managed with the 'airportService' class.

@RestController
@RequestMapping("/Airport")
public class AirportController {
    @Autowired
    private AirportService airportService;
}

