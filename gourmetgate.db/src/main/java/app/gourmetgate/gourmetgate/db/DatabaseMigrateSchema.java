package app.gourmetgate.gourmetgate.db;

import app.gourmetgate.gourmetgate.db.common.HibernateSessionFactory;

public class DatabaseMigrateSchema {

  public static void main(String[] args) {
    HibernateSessionFactory.getSessionFactory()
      .openSession()
      .close();
  }
}
