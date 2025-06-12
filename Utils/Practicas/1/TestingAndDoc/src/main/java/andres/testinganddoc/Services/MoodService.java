package andres.testinganddoc.Services;

import andres.testinganddoc.Entities.MoodEntity;
import andres.testinganddoc.Repositories.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoodService {
    @Autowired
    public MoodRepository moodDAO;

    public List<MoodEntity> findAllMoods() {
        return (List<MoodEntity>) moodDAO.findAll();
    }
}
