package andres.testinganddoc.Controllers;

import andres.testinganddoc.Entities.MoodEntity;
import andres.testinganddoc.Services.MoodService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Controlador REST para gestionar las entidades de estado de ánimo (Mood).
 * Proporciona endpoints para obtener la lista completa de estados de ánimo.
 *
 * @author Josefa
 * @version 1.0
 */
@RestController
@RequestMapping("/moods")
public class MoodController {

    /**
     * Servicio que maneja la lógica de negocio relacionada con los estados de ánimo.
     */
    @Autowired
    public MoodService moodService;

    /**
     * Endpoint GET para obtener todos los estados de ánimo.
     *
     * @return lista de todas las entidades MoodEntity disponibles
     */
    @GetMapping("/all")
    public List<MoodEntity> getAllMoods() {
        return moodService.findAllMoods();
    }
}

/*
package andres.testinganddoc.Controllers;

import andres.testinganddoc.Entities.MoodEntity;
import andres.testinganddoc.Services.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/moods")
public class MoodController {
    @Autowired
    public MoodService moodService;

    @GetMapping("/all")
    public List<MoodEntity> getAllMoods(){
        return moodService.findAllMoods();
    }
}

 */
