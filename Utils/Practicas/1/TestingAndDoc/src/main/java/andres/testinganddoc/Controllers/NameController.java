package andres.testinganddoc.Controllers;

import andres.testinganddoc.Services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/names")
public class NameController {
    @Autowired
    public NameService nameService;

    @GetMapping("/{moodNumber}")
    public List<String> getNameWithMood(@PathVariable Integer moodNumber){
        return nameService.myFindAllNamesByMood(moodNumber);
    }
}
