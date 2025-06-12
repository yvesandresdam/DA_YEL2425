package andres.testinganddoc.Repositories;

import andres.testinganddoc.Entities.NameEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NameRepository extends CrudRepository<NameEntity, Integer> {
    List<String> findAllById(Integer id);
    List<String> findByMoodIndex(Integer mood);
}
