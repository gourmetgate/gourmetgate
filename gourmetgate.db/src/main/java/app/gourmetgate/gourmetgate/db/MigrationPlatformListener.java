package app.gourmetgate.gourmetgate.db;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.common.HibernateSessionFactory;
import app.gourmetgate.gourmetgate.db.configuration.DatabaseMigrationType;
import app.gourmetgate.gourmetgate.db.configuration.MigrateDatabaseConfigProperty;
import org.eclipse.scout.rt.platform.*;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Order(6000)
public class MigrationPlatformListener implements IPlatformListener {

  private static final Logger LOG = LoggerFactory.getLogger(MigrationPlatformListener.class);

  @Override
  public void stateChanged(PlatformEvent event) {
    if (event.getState() != IPlatform.State.BeanManagerValid) {
      return;
    }

    DatabaseMigrationType migType = CONFIG.getPropertyValue(MigrateDatabaseConfigProperty.class);
    if (migType == DatabaseMigrationType.NONE) {
      LOG.info("Skipping database migration.");
      return;
    }

    boolean reset = migType == DatabaseMigrationType.RECREATE;
    LOG.info(reset ? "Recreating database schema" : "Migrating database schema...");
    try (SessionFactory factory = BEANS.get(HibernateSessionFactory.class).createSessionFactory(reset)) {
      Session session = factory.openSession();
      if (reset) {
        LOG.info("Persisting initial data...");
        Transaction tx = session.beginTransaction();
        persistInitialData(session);
        tx.commit();
      }
    }
    LOG.info("Migration done.");
  }

  @SuppressWarnings("unchecked")
  protected void persistInitialData(Session session) {
    BEANS.all(AbstractInitialDataProvider.class).stream()
      .map(AbstractInitialDataProvider::getInitialData)
      .flatMap(Collection::stream)
      .forEach(session::persist);
  }
}
