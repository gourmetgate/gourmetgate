package app.gourmetgate.gourmetgate.db;

import org.hibernate.Session;

public class SchemaGenerator {

  public static void main(String[] args) {
    // Trigger Hibernate startup -> schema generation
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    session.close();
  }
}
