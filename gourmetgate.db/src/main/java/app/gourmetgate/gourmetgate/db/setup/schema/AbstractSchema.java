package app.gourmetgate.gourmetgate.db.setup.schema;

import app.gourmetgate.gourmetgate.db.setup.AbstractDatabaseObject;

public abstract class AbstractSchema extends AbstractDatabaseObject implements IDatabaseSchema {

  @Override
  public void create() {
    getLogger().info("SQL-DEV create schema: {}", getName());
    super.create();
  }

  @Override
  public void drop() {
    getContext()
        .dropSchemaIfExists(getName())
        .execute();
  }
}
