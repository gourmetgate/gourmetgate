package app.gourmetgate.gourmetgate.db.data;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.schema.PersonEntity;

import java.util.List;
import java.util.UUID;

public class PersonDataProvider extends AbstractInitialDataProvider<PersonEntity> {

  @Override
  public List<PersonEntity> getInitialData() {
    PersonEntity alice = new PersonEntity();
    alice.setPersonId(UUID.randomUUID());
    alice.setFirstName("Alice");
    alice.setLastName("Miller");
    alice.setSalary(4000);
    alice.setExternal(true);

    PersonEntity bob = new PersonEntity();
    bob.setPersonId(UUID.randomUUID());
    bob.setFirstName("Bob");
    bob.setLastName("Smith");
    bob.setSalary(3000);
    bob.setExternal(false);

    return List.of(alice, bob);
  }
}
