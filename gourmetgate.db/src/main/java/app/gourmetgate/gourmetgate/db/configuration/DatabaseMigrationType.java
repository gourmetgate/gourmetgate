package app.gourmetgate.gourmetgate.db.configuration;

public enum DatabaseMigrationType {
  /**
   * No database migration will be performed
   */
  NONE,
  /**
   * The database schema will be migrated. No initial data is created.
   */
  MIGRATE,
  /**
   * The database schema is recreated and filled with initial data.
   */
  RECREATE
}
