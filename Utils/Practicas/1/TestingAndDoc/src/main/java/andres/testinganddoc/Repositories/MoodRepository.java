package andres.testinganddoc.Repositories;

import andres.testinganddoc.Entities.MoodEntity;
import org.springframework.data.repository.CrudRepository;

public interface MoodRepository extends CrudRepository<MoodEntity,Integer> {
}
