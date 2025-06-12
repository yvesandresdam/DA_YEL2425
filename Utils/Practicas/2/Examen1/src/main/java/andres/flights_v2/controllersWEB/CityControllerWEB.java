package andres.flights_v2.controllersWEB;

import andres.flights_v2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/web/cities")
public class CityControllerWEB {
    @Autowired
    CityService cityService;

    @GetMapping("/allcodes")
    public String getAllCodes(Model model){
        List<String> codesCity =  cityService.getAllCodes();
        model.addAttribute("codes", codesCity);
        return "city";
    }

    @GetMapping("/information/{codigo}")
    public List<String> getInformation(@PathVariable String codigo){
        return cityService.getParcialCityWithCode(codigo);
    }

    @GetMapping("/partial/{code}")
    public String getPartialCityWithCode(@PathVariable String code){
        return "city";
    }

}
