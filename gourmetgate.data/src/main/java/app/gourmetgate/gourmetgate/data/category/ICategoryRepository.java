package app.gourmetgate.gourmetgate.data.category;

import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
public interface ICategoryRepository {

  Stream<CategoryPersistenceDo> getAllActive();

  Optional<CategoryPersistenceDo> getById(UUID id);

  CategoryPersistenceDo create(CategoryPersistenceDo category);

  void store(UUID id, CategoryPersistenceDo category);

  int delete(UUID id);
}
