package andres.flights_v2.controllersWEB;

import andres.flights_v2.models.entities.AirlineEntity;
import andres.flights_v2.models.entities.CityEntity;
import andres.flights_v2.service.AirportAirlineService;
import andres.flights_v2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class InformationController {
    @Autowired
    public AirportAirlineService airportAirlineService;
    @Autowired
    public CityService cityService;

    @GetMapping("/information")
    public String getInformation(Model model) {
        List<String> airlineCompany = airportAirlineService.getAirlineWithCode("FKFI");
        CityEntity city = cityService.getCityWithCode("FKF");
        model.addAttribute("company", airlineCompany);
        model.addAttribute("cityEntity", city);
        return "info";
    }
}
