package app.gourmetgate.gourmetgate.core.person;

import static org.eclipse.scout.rt.platform.util.Assertions.assertNotNull;
import static org.eclipse.scout.rt.platform.util.Assertions.assertTrue;
import static org.eclipse.scout.rt.platform.util.StringUtility.hasText;

import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;

import app.gourmetgate.gourmetgate.data.person.IPersonRepository;
import app.gourmetgate.gourmetgate.data.person.PersonDo;
import app.gourmetgate.gourmetgate.data.person.PersonRestrictionDo;
import org.eclipse.scout.rt.shared.session.Sessions;

public class PersonService implements IService {

  public PersonDo store(String id, PersonDo personDo) {
    //TODO add validation and business logic here
    BEANS.get(IPersonRepository.class).store(id, assertPersonDo(personDo));
    return personDo;
  }

  public Optional<PersonDo> getById(String personId) {
    //TODO add validation and business logic here
    return BEANS.get(IPersonRepository.class).getById(personId);
  }

  public PersonDo create(PersonDo person) {
    //TODO add validation and business logic here
    return BEANS.get(IPersonRepository.class).create(assertPersonDo(person));
  }

  public int remove(String id) {
    //TODO add validation and business logic here
    return BEANS.get(IPersonRepository.class).remove(id);
  }

  public Stream<PersonDo> list(PersonRestrictionDo restrictions, int numberOfRows) {
    //TODO add validation and business logic here
    return BEANS.get(IPersonRepository.class).list(restrictions, numberOfRows);
  }

  protected PersonDo assertPersonDo(PersonDo person) {
    assertTrue(hasText(assertNotNull(person).getLastName()));
    return person;
  }
}
