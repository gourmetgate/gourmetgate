package app.gourmetgate.gourmetgate.db;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.common.HibernateSessionFactory;
import org.eclipse.scout.rt.platform.BEANS;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;

public class DatabaseReset {

  public static void main(String[] args) {
    Session session = HibernateSessionFactory.getSessionFactory(true).openSession();
    Transaction tx = session.beginTransaction();
    persistInitialData(session);
    tx.commit();
    session.close();
  }

  @SuppressWarnings("unchecked")
  protected static void persistInitialData(Session session) {
    BEANS.all(AbstractInitialDataProvider.class).stream()
      .map(AbstractInitialDataProvider::getInitialData)
      .flatMap(Collection::stream)
      .forEach(session::persist);
  }
}
