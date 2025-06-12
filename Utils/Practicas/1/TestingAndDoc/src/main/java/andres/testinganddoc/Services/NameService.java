package andres.testinganddoc.Services;

import andres.testinganddoc.Entities.NameEntity;
import andres.testinganddoc.Repositories.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameService {
    @Autowired
    public NameRepository nameDAO;

    public List<NameEntity> findAllNames(){
        return (List<NameEntity>) nameDAO.findAll();
    }

    public List<String> findNamesWithMood(Integer id){
        return nameDAO.findAllById(id);
    }

    public List<String> myFindAllNamesByMood(Integer mood){
        return nameDAO.findByMoodIndex(mood);
    }
}
