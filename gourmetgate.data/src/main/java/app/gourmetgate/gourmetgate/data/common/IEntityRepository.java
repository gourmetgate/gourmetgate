package app.gourmetgate.gourmetgate.data.common;

import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Default repository for an entity that works with {@link DoEntity}
 *
 * @param <DO> persistence data object of the entity
 */
@ApplicationScoped
public interface IEntityRepository<DO extends DoEntity> {

  Stream<DO> getAllActive();

  Optional<DO> getById(UUID id);

  DO create(DO dataObject);

  int store(UUID id, DO dataObject);

  int delete(UUID id);
}
