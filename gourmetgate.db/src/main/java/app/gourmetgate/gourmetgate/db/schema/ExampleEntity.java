package app.gourmetgate.gourmetgate.db.schema;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "example")
public class ExampleEntity {

  @Id
  private String exampleId;

  private String name;

  public String getExampleId() {
    return exampleId;
  }

  public void setExampleId(String exampleId) {
    this.exampleId = exampleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
