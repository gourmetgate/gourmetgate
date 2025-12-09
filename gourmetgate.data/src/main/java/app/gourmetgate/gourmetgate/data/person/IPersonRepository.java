package app.gourmetgate.gourmetgate.data.person;

import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
public interface IPersonRepository {

  void store(UUID id, PersonDo person);

  Stream<PersonDo> list(PersonRestrictionDo restrictions, int numberOfRows);

  Optional<PersonDo> getById(UUID id);

  int remove(UUID id);

  PersonDo create(PersonDo person);
}
