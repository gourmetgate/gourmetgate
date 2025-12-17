package app.gourmetgate.gourmetgate.db.data;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.schema.ExampleEntity;

import java.util.List;

public class ExampleDataProvider extends AbstractInitialDataProvider<ExampleEntity> {

  @Override
  public List<ExampleEntity> getInitialData() {
    ExampleEntity exampleEntity = new ExampleEntity();
    exampleEntity.setName("Mr Example");

    return List.of(exampleEntity);
  }
}
