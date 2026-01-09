package app.gourmetgate.gourmetgate.db.configuration;

import app.gourmetgate.gourmetgate.data.configuration.AbstractEnumConfigProperty;

public class MigrateDatabaseConfigProperty extends AbstractEnumConfigProperty<DatabaseMigrationType> {

  @Override
  public String getKey() {
    return "gourmetgate.db.migration";
  }

  @Override
  protected DatabaseMigrationType mappingFunction(String rawValue) {
    return DatabaseMigrationType.valueOf(rawValue);
  }

  @Override
  public String description() {
    return "Indicates what type of database migration is performed.";
  }

  @Override
  public DatabaseMigrationType getDefaultValue() {
    return DatabaseMigrationType.NONE;
  }
}
