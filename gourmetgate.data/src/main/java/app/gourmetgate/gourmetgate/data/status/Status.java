package app.gourmetgate.gourmetgate.data.status;

public enum Status {

  /**
   * Entity is active
   */
  ACTIVE("ACTIVE"),
  /**
   * Entity is deleted
   */
  DELETED("DELETED");

  public final String id;

  Status(String id) {
    this.id = id;
  }
}
